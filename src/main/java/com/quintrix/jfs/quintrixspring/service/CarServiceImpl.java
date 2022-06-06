package com.quintrix.jfs.quintrixspring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quintrix.jfs.quintrixspring.exception.CarNotFoundException;
import com.quintrix.jfs.quintrixspring.models.Car;
import com.quintrix.jfs.quintrixspring.models.ClientCar;
import com.quintrix.jfs.quintrixspring.models.GetCarResponse;
import com.quintrix.jfs.quintrixspring.models.agent.Agents;
import com.quintrix.jfs.quintrixspring.repository.CarRepository;
import com.quintrix.jfs.quintrixspring.restservice.AgentService;

@Service
public class CarServiceImpl implements CarService {

  private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

  @Autowired
  CarRepository carRepository;

  @Autowired
  AgentService agentService;



  List<Car> carsList = new ArrayList<>(Arrays.asList(

      new Car(1L, "Ford", "SUV", 2011), new Car(2L, "Honda", "SUV", 2005),
      new Car(3L, "Volvo", "Truck", 2015), new Car(4L, "Honda", "Sedan", 2012)

  ));


  @Override
  // public List<Car> getCars(String make) {
  public GetCarResponse getCar(String make) {
    GetCarResponse getCarResponse = new GetCarResponse();

    // Iterable<Car> isCar = CarRepository.findAll();

    // carsList = Streamable.of(isCar).toList();

    if (make != null) {
      // return carsList.stream().filter(c ->
      // c.getMake().equals(make)).collect(Collectors.toList());
      getCarResponse.setAvailableCarList(
          // carsList.stream().filter(c -> c.getMake().equals(make)).collect(Collectors.toList()));
          carsList.stream().filter(c -> c.getMake().equals(make))
              .map(c -> new ClientCar(c.getMake(), c.getModel(), c.getYear()))
              .collect(Collectors.toList()));
    } // else {
      // return carsList;
      // getCarRespose.setAvailableCarList(carsList);
    // }


    getCarResponse.setAvailableWarranty("2-year Warranty");

    List<Agents> agentList = agentService.getAgentList();

    getCarResponse.setAgentsList(agentList);
    return getCarResponse;

  }



  @Override
  public Car getCarDetails(Long id) {

    // Optional<Car> car =
    // carsList.stream().filter(c -> c.getId().longValue() == id.longValue()).findAny();


    // CarRepository carRepository = new CarRepository();
    Optional<Car> car = carRepository.findById(id);

    if (car.isPresent()) {
      return car.get();
    } else {

      logger.error("How can this happen? Why is the customer calling with id = {}", id);

      // throw new IllegalStateException("Invalid ID");
      throw new CarNotFoundException("Invalid ID", "Please use a different ID");
      // return new Car();
    }

  }


  @Override
  public Car addCar(Car car) {

    // carsList.add(car);
    /*
     * Post: body: (raw, JSON) Input data -- saves car to table
     */
    Car createCar = carRepository.save(car);
    return createCar;

  }



  @Override
  public boolean deleteCarById(Long id) {
    // TODO Auto-generated method stub
    return false;
  }



}


