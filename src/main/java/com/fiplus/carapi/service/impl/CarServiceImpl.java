package com.fiplus.carapi.service.impl;

import com.fiplus.carapi.entity.Car;
import com.fiplus.carapi.exception.ResourceNotFoundException;
import com.fiplus.carapi.repository.CarRepo;
import com.fiplus.carapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo carRepo;

    @Override
    public Car createCar(Car car) {
        return carRepo.save(car);
    }

    @Override
    public Car updateCar(Car car, Long carId) {
        Car findCar = carRepo.findById(carId)
                .orElseThrow(()-> new ResourceNotFoundException("Car","id",carId));
        findCar.setModel(car.getModel());
        findCar.setMaker(car.getMaker());
        findCar.setYear(car.getYear());
        findCar.setColor(car.getColor());
        return carRepo.save(findCar);
    }

    @Override
    public List<Car> getAllCar() {
        return carRepo.findAll();
    }

    @Override
    public Car getCarById(Long carId) {
        return carRepo.findById(carId)
                .orElseThrow(()-> new ResourceNotFoundException("Car","id",carId));
    }
}
