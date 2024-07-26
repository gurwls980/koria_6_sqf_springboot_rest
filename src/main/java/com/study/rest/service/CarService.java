package com.study.rest.service;

import com.study.rest.entity.Car;
import com.study.rest.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

//    @Autowired // Autowired를 제거하면 생성자를 만들어 줘야 한다. final -> 상수 : 무조건 한번은 초기화를 해줘야 한다.
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;     // final의 carRepository 초기화문
    }

    public Car getCar(String model) {
        return carRepository.findCarByModel(model);
//        Car car = carRepository.findCarByModel();
    }
}
