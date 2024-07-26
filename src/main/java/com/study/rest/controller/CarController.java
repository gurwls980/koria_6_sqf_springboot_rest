package com.study.rest.controller;

import com.study.rest.entity.Car;
import com.study.rest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @ResponseBody
    @GetMapping("/car")
    public Car getCar(@RequestParam String model) {

        return carService.getCar(model);
    }

}

/*
*   요청 GET - /car?model=K5
*   CarEntity           -> model, color
*
*   CarRepository       -> Car findCarByModel(String model)
*       -> List<Car>
            -> index0: Car(model: "쏘나타", color: "화이트")      model.equal
            -> index1: Car(model: "K5", color: "블랙")
*
*   CarService          -> Car getCar(String model)
*
*   CarController       -> Car getCar(@RequestParam String model)
*
*   의존관계 : CarController(끝) > CarService > CarRepository(시작)
* */
