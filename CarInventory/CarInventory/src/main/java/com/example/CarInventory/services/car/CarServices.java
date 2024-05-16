package com.example.CarInventory.services.car;

import com.example.CarInventory.dto.car.CarDto;
import com.example.CarInventory.dto.car.CarToSaveDto;

import java.util.List;
import java.util.UUID;

public interface CarServices {
    CarDto saveCar(CarToSaveDto carToSaveDto);
    List<CarDto> findAll();

    CarDto findcarByID(UUID id);

    List<CarDto> listAvaliableCar();

    CarDto reserveCar(UUID id);

    CarDto returnCar(UUID id);
}
