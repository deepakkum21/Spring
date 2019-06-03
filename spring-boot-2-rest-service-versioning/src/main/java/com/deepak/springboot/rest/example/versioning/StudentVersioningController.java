package com.deepak.springboot.rest.example.versioning;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentVersioningController {

  @GetMapping("v1/student")
  public StudentV1 studentV1() {
    return new StudentV1("Deepak Kumar", "V1");
  }

  @GetMapping("v2/student")
  public StudentV2 studentV2() {
    return new StudentV2(new Name("Deepak", "Kumar"), "V2");
  }

  // http://localhost:8081/student/param?version=1
  @GetMapping(value = "/student/param", params = "version=1")
  public StudentV1 paramV1() {
    return new StudentV1("Deepak Kumar", "V1");
  }

  // http://localhost:8081/student/param?version=2
  @GetMapping(value = "/student/param", params = "version=2")
  public StudentV2 paramV2() {
    return new StudentV2(new Name("Deepak", "Kumar"), "V2");
  }

  // in headers
  // Key = X-API-VERSION
  // Value = 1
  @GetMapping(value = "/student/header", headers = "X-API-VERSION=1")
  public StudentV1 headerV1() {
    return new StudentV1("Deepak Kumar", "V1");
  }

  // in headers
  // Key = X-API-VERSION
  // Value = 2
  @GetMapping(value = "/student/header", headers = "X-API-VERSION=2")
  public StudentV2 headerV2() {
    return new StudentV2(new Name("Deepak", "Kumar"), "V2");
  }

  // in headers
  // key = Accept
  // Value = application/vnd.company.app-v1+json
  @GetMapping(value = "/student/produces", produces = "application/vnd.company.app-v1+json")
  public StudentV1 producesV1() {
    return new StudentV1("Deepak Kumar", "V1");
  }

  // in headers
  // Key = Accept
  // Value = application/vnd.company.app-v2+json
  @GetMapping(value = "/student/produces", produces = "application/vnd.company.app-v2+json")
  public StudentV2 producesV2() {
    return new StudentV2(new Name("Deepak", "Kumar"), "V2");
  }

}