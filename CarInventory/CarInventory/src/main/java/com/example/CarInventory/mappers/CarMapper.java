package com.example.CarInventory.mappers;

import com.example.CarInventory.dto.car.CarDto;
import com.example.CarInventory.dto.car.CarToSaveDto;
import com.example.CarInventory.entities.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @Mapping(target = "id", ignore = true)
    Car CarToSaveDtoToEntity(CarToSaveDto carToSaveDto);

    Car CarDtoToEntity(CarDto carDto);

    CarDto EntityToDto(Car car);

}
