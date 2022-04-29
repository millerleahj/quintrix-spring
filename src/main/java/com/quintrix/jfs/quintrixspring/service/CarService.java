package com.quintrix.jfs.quintrixspring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.quintrix.jfs.quintrixspring.models.Car;
import com.quintrix.jfs.quintrixspring.repository.CarRepository;

@Service
public class CarService {

  @Autowired
  CarRepository carRepository;


  List<Car> carsList = new ArrayList<>(Arrays.asList(

      new Car(1L, "Ford", "SUV", 2011), new Car(2L, "Honda", "SUV", 2005),
      new Car(3L, "Volvo", "Truck", 2015), new Car(4L, "Honda", "Sedan", 2012)

  ));



  public List<Car> getCars(@RequestParam(name = "make", required = false) String make) {
    if (make != null) {
      return carsList.stream().filter(c -> c.getMake().equals(make)).collect(Collectors.toList());
    } else {
      return carsList;
    }

  }


  public Car getCarDetails(@PathVariable Long id) {

    // Optional<Car> car =
    // carsList.stream().filter(c -> c.getId().longValue() == id.longValue()).findAny();


    // CarRepository carRepository = new CarRepository();
    Optional<Car> car = carRepository.findById(1L);

    if (car.isPresent()) {
      return car.get();
    } else {
      return new Car();
    }

  }


  public Car addCar(@RequestBody Car car) {

    // carsList.add(car);
    /*
     * Post: body: (raw, JSON) Input data -- saves car to table
     */
    Car createCar = carRepository.save(car);
    return createCar;

  }

}


