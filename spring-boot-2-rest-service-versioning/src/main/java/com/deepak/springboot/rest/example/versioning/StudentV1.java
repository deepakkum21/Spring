package com.deepak.springboot.rest.example.versioning;
public class StudentV1 {
  private String name;
  private String version;

  public StudentV1() {
    super();
  }

  public StudentV1(String name) {
    super();
    this.name = name;
  }

  public StudentV1(String name, String version) {
    super();
    this.name = name;
    this.version = version;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  
}