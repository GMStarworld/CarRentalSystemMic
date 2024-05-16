package com.example.CarInventory.dto.car;

import java.util.UUID;

public record CarToSaveDto(

        String model,

        String maker,

        Boolean avaliable
) {
}
