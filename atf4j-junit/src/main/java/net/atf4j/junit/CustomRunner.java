/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 *
 * Atf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with atf4j.  If not, see http://www.gnu.org/licenses/.
 */

package net.atf4j.junit;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.TestClass;

public class CustomRunner extends Runner {
    private final List<Method> testMethods = new ArrayList<Method>();
    private final TestClass testClass;

    public CustomRunner(final Class<?> aClass) {
        this.testClass = new TestClass(aClass);
        final Method[] classMethods = aClass.getDeclaredMethods();
        for (final Method classMethod : classMethods) {
            final Class<?> retClass = classMethod.getReturnType();
            final int length = classMethod.getParameterTypes().length;
            final int modifiers = classMethod.getModifiers();

            if (retClass == null || length != 0 || Modifier.isStatic(modifiers) || !Modifier.isPublic(modifiers)
                    || Modifier.isInterface(modifiers) || Modifier.isAbstract(modifiers)) {
                continue;
            }

            final String methodName = classMethod.getName();
            if (methodName.toUpperCase().startsWith("TEST") || classMethod.getAnnotation(Test.class) != null) {
                this.testMethods.add(classMethod);
            }

            if (classMethod.getAnnotation(Ignore.class) != null) {
                this.testMethods.remove(classMethod);
            }
        }
    }

    @Override
    public Description getDescription() {
        final Description spec = Description.createSuiteDescription(this.testClass.getName(),
                this.testClass.getJavaClass().getAnnotations());
        return spec;
    }

    @Override
    public void run(final RunNotifier runNotifier) {
        for (int i = 0; i < this.testMethods.size(); i++) {
            final Method method = this.testMethods.get(i);
            final Description spec = Description.createTestDescription(method.getClass(), method.getName());
            runNotifier.fireTestStarted(spec);
        }
    }
}
