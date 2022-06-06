package com.quintrix.jfs.quintrixspring.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.quintrix.jfs.quintrixspring.models.Car;
import com.quintrix.jfs.quintrixspring.models.ClientCar;
import com.quintrix.jfs.quintrixspring.models.GetCarResponse;
import com.quintrix.jfs.quintrixspring.service.CarService;

public class CarControllerTests {


  @Test
  void mockTest() {

    CarService carServiceMock = Mockito.mock(CarService.class);

    Car car = new Car();
    car.setId(777L);
    // unnecessary:
    // car.setMake("Ford");
    // car.setModel("F150");

    Mockito.when(carServiceMock.getCarDetails(1L)).thenReturn(car);

    assertEquals(carServiceMock.getCarDetails(1L).getId(), 777L);
  }


  @Test
  void testDeleteCar() throws Exception {

    CarController carController = new CarController();
    CarService carServiceMock = Mockito.mock(CarService.class);


    carController.setCarService(carServiceMock);


    carController.setCarService(carServiceMock);

    Mockito.when(carServiceMock.deleteCarById(1L)).thenReturn(true);

    assertNotNull(carController.deleteCar(1L));


  }


  @Test
  void mockControllerNegTest() throws Exception {

    CarController carController = new CarController();
    CarService carServiceMock = Mockito.mock(CarService.class);

    Car car = new Car();
    car.setId(777L);


    carController.setCarService(carServiceMock);
    Mockito.when(carServiceMock.deleteCarById(1L)).thenReturn(true);
    assertNull(carController.deleteCar(2L));

  }


  @Test
  void mockMvcTest() throws Exception {

    CarController carController = new CarController();
    CarService carServiceMock = Mockito.mock(CarService.class);
    GetCarResponse getCarResponse = new GetCarResponse();

    List<ClientCar> carsList = new ArrayList<>();
    Car car = new Car();
    ClientCar clientCar = new ClientCar();

    clientCar.setMake("Honda");
    clientCar.setYear(1995);
    carsList.add(clientCar);
    getCarResponse.setAvailableCarList(carsList);

    carController.setCarService(carServiceMock);
    Mockito.when(carServiceMock.getCar("Honda")).thenReturn(getCarResponse);

    MockMvc mockMvc = standaloneSetup(carController).build();

    mockMvc.perform(get("/cars").param("make", "Honda"))
        .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(jsonPath("$", notNullValue()))
        .andExpect(jsonPath("$.availableCarList", notNullValue()))
        .andExpect(jsonPath("$.availableCarList", hasSize(1)))
        .andExpect(jsonPath("$.availableCarList[0].year", is(1995)))
        .andExpect(jsonPath("$.availableCarList[0].make", is("Honda")));

    /*
     * the name of the param "make" cannot be changed in the Controller (or where it is being called
     * from) or it will not work in test -- the name is specific
     * 
     * 
     * 
     * Required: import static
     * org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup; import static
     * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; import static
     * org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; import static
     * org.hamcrest.Matchers.notNullValue; import static org.hamcrest.Matchers.is;
     */

  }



}
