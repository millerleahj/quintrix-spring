package com.quintrix.jfs.quintrixspring.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quintrix.jfs.quintrixspring.models.Car;
import com.quintrix.jfs.quintrixspring.models.GetCarResponse;
import com.quintrix.jfs.quintrixspring.models.agent.Agents;
import com.quintrix.jfs.quintrixspring.restservice.AgentService;
import com.quintrix.jfs.quintrixspring.service.CarService;


@RestController
// @RequestMapping("/cars")
public class CarController {

  private static final Logger logger = LoggerFactory.getLogger(CarController.class);

  @Autowired
  private CarService carService;
  // List<Car> carsList = new ArrayList<>();

  @Autowired
  AgentService agentService;

  @RequestMapping(method = RequestMethod.GET, value = "/cars")
  // public List<Car> getCarService(@RequestParam(name = "make", required = false) String make) {
  public GetCarResponse getCarService(@RequestParam(name = "make", required = false) String make) {
    // GetCarRespose getCarRespose = new GetCarRespose();
    // return carService.getCars(make);
    // getCarRespose = carService.getCar(make);
    // return getCarRespose;
    return carService.getCar(make);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/cars/{id}")
  public Car getCarDetailsService(@PathVariable Long id) {

    logger.debug("Request: Called getCarDetails Controller {}", id);

    return carService.getCarDetails(id);
  }



  @RequestMapping(method = RequestMethod.POST, value = "/cars")
  // public Car addCarService(@RequestBody Car car) {
  public Car addCarService(String carStr) throws JsonMappingException, JsonProcessingException {

    System.out.println(carStr);

    ObjectMapper objectMapper = new ObjectMapper();

    Car car = objectMapper.readValue(carStr, Car.class);

    return carService.addCar(car);

    /*
     * when post 'bad request' prints what was posted by client so that you can see where the error
     * was
     */

  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/cars/{id}")
  Car deleteCar(@PathVariable Long id) {

    logger.debug("Request: Called deleteCar Controller {}");

    if (carService.deleteCarById(id)) {
      return new Car();
    }
    return null;

  }

  public CarService getCarService() {
    return carService;
  }

  public void setCarService(CarService carService) {
    this.carService = carService;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/agents")
  public List<Agents> getAgentList() {
    return agentService.getAgentList();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/agent/{id}")
  public Agents getAgent(@PathVariable int id) {
    return agentService.getAgent(id);
  }



  private void movedToService() {
    // @Autowired

    /*
     * List<Car> carsList = new ArrayList<>(Arrays.asList(
     * 
     * new Car(1L, "Ford", "SUV", 2011), new Car(2L, "Honda", "SUV", 2005), new Car(3L, "Volvo",
     * "Truck", 2015), new Car(4L, "Honda", "Sedan", 2012)
     * 
     * ));
     * 
     * // @RequestMapping(method = RequestMethod.GET, value = "/cars") // List<Car> getCars() { //
     * return carsList; // }
     * 
     * @RequestMapping(method = RequestMethod.GET, value = "/cars") List<Car>
     * getCars(@RequestParam(name = "make", required = false) String make) { if (make != null) {
     * return carsList.stream().filter(c -> c.getMake().equals(make)).collect(Collectors.toList());
     * } else { return carsList; }
     * 
     * /* adding the requestparam where it is needs the required = false statement so that an error
     * doesn't occur if not present
     * 
     * 
     * }
     * 
     * @RequestMapping(method = RequestMethod.GET, value = "/cars/{id}") Car
     * getCarDetails(@PathVariable Long id) {
     * 
     * Optional<Car> car = carsList.stream().filter(c -> c.getId().longValue() ==
     * id.longValue()).findAny();
     * 
     * // return carsList.stream().anyMatch(c -> c.getId().longValue() ==
     * id.longValue()).orElse(null);
     * 
     * if (car.isPresent()) { return car.get(); } else { return new Car(); }
     * 
     * /* "/cars/{id}" selects cars with an id PathVariable is argument that uses id in code; code
     * checks to see if id exists and will print the data if it does else returns null
     * 
     * Optional: a container object used to contain not-null objects; has various utility methods to
     * facilitate code to handle values as 'available' or 'not available' instead of checking null
     * values
     * 
     * }
     * 
     * @RequestMapping(method = RequestMethod.POST, value = "/cars") Car addCar(@RequestBody Car
     * car) {
     * 
     * carsList.add(car);
     * 
     * return car;
     * 
     * /* creating a post method to create
     * 
     * 
     * }
     * 
     * @ExceptionHandler(Exception.class) public void handleExceptions() {} Created Exception
     * handler so that it can be applied to all controllers
     * 
     * 
     */

  }

}
