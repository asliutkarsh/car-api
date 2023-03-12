package com.fiplus.carapi.controller;


import com.fiplus.carapi.entity.Car;
import com.fiplus.carapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;


    @PostMapping("/add")
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        return new ResponseEntity<>(carService.createCar(car), HttpStatus.CREATED);
    }

    @PutMapping("/{carId}")
    public ResponseEntity<Car> updateCar( @PathVariable("carId")Long carId, @RequestBody Car car){
        Car updatedCar = carService.updateCar(car,carId);
        return ResponseEntity.ok(updatedCar);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> fetchAllCars(){
        return ResponseEntity.ok(carService.getAllCar());
    }

    @GetMapping("/{carId}")
    public ResponseEntity<Car> fetchCarById(@PathVariable("carId") Long carId)  {
        return ResponseEntity.ok(carService.getCarById(carId));
    }

}
