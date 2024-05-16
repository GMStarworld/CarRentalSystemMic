package com.example.CarInventory.controllers;

import com.example.CarInventory.dto.car.CarDto;
import com.example.CarInventory.dto.car.CarToSaveDto;
import com.example.CarInventory.services.car.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/cars")
public class CarController {
    private final CarServices carServices;

    @Autowired
    public CarController(CarServices carServices){
        this.carServices = carServices;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> findcarByID(@PathVariable UUID id){
        CarDto res = carServices.findcarByID(id);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> findAll(){
        List<CarDto> res = carServices.findAll();
        return ResponseEntity.ok().body(res);
    }

    @PostMapping()
    public ResponseEntity<CarDto> postCliente(@RequestBody CarToSaveDto car){
        CarDto res = carServices.saveCar(car);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/listAvaliable")
    public ResponseEntity<List<CarDto>> listAvaliableCar(){
        List<CarDto> res = carServices.listAvaliableCar();
        return ResponseEntity.ok().body(res);
    }

    @PutMapping("/reserve/{id}")
    public ResponseEntity<CarDto> reserveCar(@PathVariable UUID id){
        CarDto res = carServices.reserveCar(id);
        return ResponseEntity.ok().body(res);
    }

    @PutMapping("/return/{id}")
    public ResponseEntity<CarDto> returnCar(@PathVariable UUID id){
        CarDto res = carServices.returnCar(id);
        return ResponseEntity.ok().body(res);
    }
}
