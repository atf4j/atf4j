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

package net.atf4j.core;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Narrate a test from the call stack.
 */
public final class Narrator {

    private static final Logger LOG = LoggerFactory.getLogger(Narrator.class);
    private static final String LAYOUT_STYLE = "%s [%s]";

    /**
     * private constructor to prevent rampant instantiation.
     */
    private Narrator() {
        super();
    }

    /**
     * Use Reflection to produce String by introspection.
     *
     * @param object the object
     * @return the string Object.
     */
    public static String reflectObjectToString(final Object object) {
        // LOG.debug("reflectObjectToString(object = {})", object);
        if (object != null) {
            final StringBuilder reflection = new StringBuilder();
            final Class<? extends Object> aClass = object.getClass();
            reflection.append(Narrator.membersToString(object, aClass));
            reflection.append(Narrator.reflectClassToString(object, aClass));
            return String.format(LAYOUT_STYLE, aClass.getSimpleName(), reflection);
        } else {
            return "object=[NULL]";
        }
    }

    /**
     * Reflect class to string.
     *
     * @param object the object
     * @param aClass the a class
     * @return the string
     */
    private static String reflectClassToString(final Object object, final Class<? extends Object> aClass) {
        // LOG.debug("reflectClassToString(object = {}, aClass = {})", object,
        // aClass);
        final StringBuilder reflection = new StringBuilder();
        final Class<? extends Object> superClass = aClass.getSuperclass();
        if (superClass != null) {
            if (!superClass.isInstance(Object.class)) {
                final String simpleName = superClass.getSimpleName();
                final String reflectClassToString = Narrator.reflectClassToString(object, superClass);
                final String format = String.format(LAYOUT_STYLE, simpleName, reflectClassToString);
                reflection.append(format);
            } else {
                reflection.append(Narrator.membersToString(object, aClass));
            }
        } else {
            reflection.append("superClass == null");
        }
        return reflection.toString();
    }

    /**
     * Members to string.
     *
     * @param object the object
     * @param aClass the a class
     * @return the string
     */
    private static String membersToString(final Object object, final Class<?> aClass) {
        // LOG.debug("membersToString(object = {}, aClass = {})", object,
        // aClass);
        if (object != null) {
            final StringBuilder stringBuilder = new StringBuilder();
            final Field[] declaredFields = aClass.getDeclaredFields();
            if (declaredFields.length > 0) {
                for (final Field field : declaredFields) {
                    try {
                        field.setAccessible(true);
                        final String fieldName = field.getName();
                        final Object fieldType = field.get(object);
                        final String memberStr = String.format("%s = %s,", fieldName, fieldType);
                        stringBuilder.append(memberStr);
                    } catch (final Exception e) {
                        LOG.error(e.toString());
                    }
                }
                // stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                LOG.debug(stringBuilder.toString());

                return stringBuilder.toString();
            } else {
                return "[NONE]";
            }
        } else {
            return "[NULL]";
        }
    }
}
