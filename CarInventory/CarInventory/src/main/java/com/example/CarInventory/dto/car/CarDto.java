package com.example.CarInventory.dto.car;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public record CarDto(
        UUID id,

        String model,

        String maker,

        Boolean avaliable
) {
}
