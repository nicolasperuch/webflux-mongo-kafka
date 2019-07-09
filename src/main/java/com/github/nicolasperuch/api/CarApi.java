package com.github.nicolasperuch.api;

import com.github.nicolasperuch.entity.CarEntity;
import com.github.nicolasperuch.repository.CarRepository;
import com.github.nicolasperuch.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.status;


@RestController
@RequestMapping("/car")
public class CarApi {

    private CarRepository carRepository;
    private CarService carService;

    public CarApi(CarRepository carRepository, CarService carService) {
        this.carRepository = carRepository;
        this.carService = carService;
    }

    @PostMapping
    public Mono<ResponseEntity<?>> createCar(@RequestBody @Valid CarEntity carEntity){
        return carService.save(carEntity)
                .map(car -> status(CREATED).body(carEntity));
    }

    @GetMapping
    public Flux<CarEntity> getCars(){
        return carRepository.findAll();
    }
}
