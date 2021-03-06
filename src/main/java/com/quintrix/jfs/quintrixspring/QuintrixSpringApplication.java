package com.quintrix.jfs.quintrixspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.quintrix.jfs.quintrixspring.controller.CarController;
import com.quintrix.jfs.quintrixspring.repository.EmployeeRepository;

@SpringBootApplication
public class QuintrixSpringApplication implements CommandLineRunner {

  @Autowired
  EmployeeRepository employeeRepository;

  @Autowired
  CarController carController;

  public static void main(String[] args) {
    SpringApplication.run(QuintrixSpringApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    // TODO Auto-generated method stub

    long countOfRecords = employeeRepository.count();
    // if (employee.isPresent()) {
    System.out.println(countOfRecords);
    // }

  }



}
