package com.codegenerator.example1;

import java.util.*;

public class ClassDescriptor {

  private String name;
  private ArrayList attributes = new ArrayList();

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void addAttribute(AttributeDescriptor attribute) {
    attributes.add(attribute);
  }

  public ArrayList getAttributes() {
    return attributes;
  }


}