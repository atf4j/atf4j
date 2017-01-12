package com.codegenerator.example1;

import java.util.*;
import java.io.*;

// SAX
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

// Velocity
import org.apache.velocity.app.*;
import org.apache.velocity.*;
import org.apache.velocity.exception.*;

public class ClassGenerator {

  private static ArrayList classes;
  private static ClassDescriptorImporter cdImporter;
  private static XMLReader xmlReader;

  static void init() throws Exception {

    // SAX parser initialization
    SAXParserFactory spf = SAXParserFactory.newInstance();
    spf.setNamespaceAware(true);
    SAXParser saxParser = spf.newSAXParser();
    xmlReader = saxParser.getXMLReader();

    // Set the ClassDescriptorImporter as hadler
    cdImporter = new ClassDescriptorImporter();
    xmlReader.setContentHandler(cdImporter);

    // Init Velocity
    Velocity.init();
  }

  public static void start(String modelFile, String templateFile) throws Exception {

    // Load the model
    FileInputStream input = new FileInputStream(modelFile);
    xmlReader.parse(new InputSource(input));
    input.close();
    classes = cdImporter.getClasses(); // ClassDescriptor Array

    //Generate classes
    GeneratorUtility utility = new GeneratorUtility();
    for (int i = 0; i < classes.size(); i++) {

      VelocityContext context = new VelocityContext();
      ClassDescriptor cl = (ClassDescriptor) classes.get(i);
      context.put("class", cl);
      context.put("utility", utility);

      Template template = Velocity.getTemplate(templateFile);

      BufferedWriter writer =
        new BufferedWriter(new FileWriter(cl.getName()+".java"));

      template.merge(context, writer);
      writer.flush();
      writer.close();

      System.out.println("Class " + cl.getName() + " generated!");
    }

  }

  private static void showClasses() {

    for (int i = 0; i < classes.size(); i++) {
      ClassDescriptor cl = (ClassDescriptor) classes.get(i);
      System.out.println(cl.getName());
      ArrayList attrs = cl.getAttributes();
      for (int j = 0; j < attrs.size(); j++) {
        AttributeDescriptor at = (AttributeDescriptor) attrs.get(j);
        System.out.print("\t" + at.getType());
        System.out.println(" " + at.getName());
      }

    }

  }

  public static void main(String args[]) throws Exception {

    if (args.length!=2) {
      System.out.print("Syntax: ClassGenerator <model> <template>");
      System.exit(1);
    }

    String modelFile = args[0];
    String templateFile = args[1];

    ClassGenerator.init();
    ClassGenerator.start(modelFile,templateFile);

  }

}