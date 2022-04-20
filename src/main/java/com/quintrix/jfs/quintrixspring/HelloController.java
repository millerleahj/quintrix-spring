package com.quintrix.jfs.quintrixspring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @RequestMapping("/")
  String hello() {
    return "Hello World! Welcome Spring Boot!";
  }

}
