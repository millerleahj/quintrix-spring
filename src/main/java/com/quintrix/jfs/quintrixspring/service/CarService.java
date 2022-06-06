package com.quintrix.jfs.quintrixspring.service;

import com.quintrix.jfs.quintrixspring.models.Car;
import com.quintrix.jfs.quintrixspring.models.GetCarResponse;

public interface CarService {

  Car getCarDetails(Long id);

  // List<Car> getCars(String make);
  GetCarResponse getCar(String make);

  Car addCar(Car car);

  boolean deleteCarById(Long id);


}
