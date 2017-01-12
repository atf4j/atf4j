package com.codegenerator.example1;

import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class ClassDescriptorImporter extends DefaultHandler {

  private ArrayList classes = new ArrayList();

  public ArrayList getClasses() {
    return classes;
  }

  public void startElement(String uri, String name, String qName, Attributes attr) throws SAXException {

    if (name.equals("Class")) {
      ClassDescriptor cl = new ClassDescriptor();
      cl.setName(attr.getValue("name"));
      classes.add(cl);
    }

    else if (name.equals("Attribute")) {
      AttributeDescriptor at = new AttributeDescriptor();
      at.setName(attr.getValue("name"));
      at.setType(attr.getValue("type"));
      ClassDescriptor parent = (ClassDescriptor) classes.get(classes.size()-1);
      parent.addAttribute(at);

    }

    else if (name.equals("Content")) {
    }

    else throw new SAXException("Element " + name + " not valid");

  }

  public void endElement(String uri, String name, String qName) throws SAXException {
  }



}