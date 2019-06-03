package com.deepak.springboot.rest.example.versioning;
public class StudentV2 {
  private Name name;
  private String version;

  public StudentV2() {
    super();
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public StudentV2(Name name) {
    super();
    this.name = name;
  }

  public StudentV2(Name name, String version) {
    super();
    this.name = name;
    this.setVersion(version);
  }

  public Name getName() {
    return name;
  }

  public void setName(Name name) {
    this.name = name;
  }

}