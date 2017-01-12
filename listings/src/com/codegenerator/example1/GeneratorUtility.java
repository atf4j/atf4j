package com.codegenerator.example1;

public class GeneratorUtility {

  public static String firstToUpperCase(String string) {
    String post = string.substring(1,string.length());
    String first = (""+string.charAt(0)).toUpperCase();
    return first+post;
  }

}