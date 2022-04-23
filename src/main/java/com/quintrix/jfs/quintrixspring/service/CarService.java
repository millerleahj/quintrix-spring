package com.quintrix.jfs.quintrixspring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.quintrix.jfs.quintrixspring.models.Car;

public class CarService {
  // @Autowired

  List<Car> carsList = new ArrayList<>(Arrays.asList(

      new Car(1L, "Ford", "SUV", 2011), new Car(2L, "Honda", "SUV", 2005),
      new Car(3L, "Volvo", "Truck", 2015), new Car(4L, "Honda", "Sedan", 2012)

  ));

  // @RequestMapping(method = RequestMethod.GET, value = "/cars")
  // List<Car> getCars() {
  // return carsList;
  // }

  @RequestMapping(method = RequestMethod.GET, value = "/cars")
  List<Car> getCars(@RequestParam(name = "make", required = false) String make) {
    if (make != null) {
      return carsList.stream().filter(c -> c.getMake().equals(make)).collect(Collectors.toList());
    } else {
      return carsList;
    }

    /*
     * adding the requestparam where it is needs the required = false statement so that an error
     * doesn't occur if not present
     */

  }

  @RequestMapping(method = RequestMethod.GET, value = "/cars/{id}")
  Car getCarDetails(@PathVariable Long id) {

    Optional<Car> car =
        carsList.stream().filter(c -> c.getId().longValue() == id.longValue()).findAny();

    // return carsList.stream().anyMatch(c -> c.getId().longValue() == id.longValue()).orElse(null);

    if (car.isPresent()) {
      return car.get();
    } else {
      return new Car();
    }

    /*
     * "/cars/{id}" selects cars with an id PathVariable is argument that uses id in code; code
     * checks to see if id exists and will print the data if it does else returns null
     * 
     * Optional: a container object used to contain not-null objects; has various utility methods to
     * facilitate code to handle values as 'available' or 'not available' instead of checking null
     * values
     */
  }

  @RequestMapping(method = RequestMethod.POST, value = "/cars")
  Car addCar(@RequestBody Car car) {

    carsList.add(car);

    return car;

    /*
     * creating a post method to create
     */

  }

}


