package com.example.CarInventory.mappers;

import com.example.CarInventory.dto.car.CarDto;
import com.example.CarInventory.dto.car.CarToSaveDto;
import com.example.CarInventory.entities.Car;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-15T20:48:55-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public Car CarToSaveDtoToEntity(CarToSaveDto carToSaveDto) {
        if ( carToSaveDto == null ) {
            return null;
        }

        Car.CarBuilder car = Car.builder();

        car.model( carToSaveDto.model() );
        car.maker( carToSaveDto.maker() );
        car.avaliable( carToSaveDto.avaliable() );

        return car.build();
    }

    @Override
    public Car CarDtoToEntity(CarDto carDto) {
        if ( carDto == null ) {
            return null;
        }

        Car.CarBuilder car = Car.builder();

        car.id( carDto.id() );
        car.model( carDto.model() );
        car.maker( carDto.maker() );
        car.avaliable( carDto.avaliable() );

        return car.build();
    }

    @Override
    public CarDto EntityToDto(Car car) {
        if ( car == null ) {
            return null;
        }

        UUID id = null;
        String model = null;
        String maker = null;
        Boolean avaliable = null;

        id = car.getId();
        model = car.getModel();
        maker = car.getMaker();
        avaliable = car.getAvaliable();

        CarDto carDto = new CarDto( id, model, maker, avaliable );

        return carDto;
    }
}
