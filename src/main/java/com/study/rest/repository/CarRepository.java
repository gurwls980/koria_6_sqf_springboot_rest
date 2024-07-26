package com.study.rest.repository;

import com.study.rest.entity.Car;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarRepository {

    private List<Car> carList = List.of(
            Car.builder().model("쏘나타").color("화이트").build(),
            Car.builder().model("K5").color("블랙").build()
    );

    public Car findCarByModel(String model) {
        return carList.stream()
                .filter(car -> car.getModel().equals(model))
                .collect(Collectors.toList())
                .get(0);
//        Car findCar = null;
//
//        List<Car> cars = List.of(Car.builder().model("쏘나타").color("화이트").build(),
//                Car.builder().model("K5").color("블랙").build());
//
////        if("쏘나타".equals(model)) {
////            findCar = cars.get(0);
////        }
////
////        if("K5".equals(model)) {
////            findCar = cars.get(1);
////        }
//
//        for(Car car : cars) {
//            if(car.getModel().equals(model)) {
//                findCar = car;
//                break;
//            }
//        }
//
//        return findCar;
    }
}
