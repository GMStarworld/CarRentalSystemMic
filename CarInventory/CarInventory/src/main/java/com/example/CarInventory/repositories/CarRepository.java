package com.example.CarInventory.repositories;

import com.example.CarInventory.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    List<Car> findByAvaliable(Boolean avaliable);
}
