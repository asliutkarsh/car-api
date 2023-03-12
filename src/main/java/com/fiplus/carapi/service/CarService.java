package com.fiplus.carapi.service;

import com.fiplus.carapi.entity.Car;

import java.util.List;

public interface CarService {

    Car createCar(Car car);

    Car updateCar(Car car,Long carId);

    List<Car> getAllCar();

    Car getCarById(Long carId);
}
