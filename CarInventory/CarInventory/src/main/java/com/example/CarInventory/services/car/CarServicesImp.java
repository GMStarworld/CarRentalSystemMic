package com.example.CarInventory.services.car;

import com.example.CarInventory.dto.car.CarDto;
import com.example.CarInventory.dto.car.CarToSaveDto;
import com.example.CarInventory.entities.Car;
import com.example.CarInventory.mappers.CarMapper;
import com.example.CarInventory.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarServicesImp implements CarServices{

    private final CarRepository carRepository;

    private final CarMapper carMapper;

    @Autowired
    public CarServicesImp(CarRepository carRepository, CarMapper carMapper){
        this.carMapper=carMapper;
        this.carRepository=carRepository;
    }

    @Override
    public CarDto saveCar(CarToSaveDto carToSaveDto) {
        Car carSaved=carRepository.save(carMapper.CarToSaveDtoToEntity(carToSaveDto));
        return carMapper.EntityToDto(carSaved);
    }

    @Override
    public List<CarDto> findAll() {
        List<Car> cars = carRepository.findAll();

        List<CarDto> allCars =  new ArrayList<>();

        cars.forEach( car -> {
             CarDto c = carMapper.EntityToDto(car);
            allCars.add(c);
        });
        return allCars;
    }

    @Override
    public CarDto findcarByID(UUID id) {
        Optional<Car> cars = carRepository.findById(id);
        return carMapper.EntityToDto(cars.get());
    }

    @Override
    public List<CarDto> listAvaliableCar() {
        List<Car> cars = carRepository.findByAvaliable(true);
        List<CarDto> allCars =  new ArrayList<>();

        cars.forEach( car -> {
            CarDto c = carMapper.EntityToDto(car);
            allCars.add(c);
        });

        return allCars;
    }

    @Override
    public CarDto reserveCar(UUID id) {
        Optional<Car> car = carRepository.findById(id);
        car.get().setAvaliable(false);
        Car carSaved=carRepository.save(car.get());
        return carMapper.EntityToDto(carSaved);
    }

    @Override
    public CarDto returnCar(UUID id) {
        Optional<Car> car = carRepository.findById(id);
        car.get().setAvaliable(true);
        Car carSaved=carRepository.save(car.get());
        return carMapper.EntityToDto(carSaved);
    }
}
