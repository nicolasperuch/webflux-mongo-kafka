package com.github.nicolasperuch.service;

import com.github.nicolasperuch.entity.CarEntity;
import com.github.nicolasperuch.repository.CarRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CarService {

    private KafkaTemplate kafkaTemplate;
    private CarRepository carRepository;
    private final String CAR_TOPIC = "order-car";

    public CarService(KafkaTemplate kafkaTemplate, CarRepository carRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.carRepository = carRepository;
    }

    public Mono<CarEntity> save(CarEntity carEntity){
        return carRepository.save(carEntity)
                .doOnSuccess(this::publish);
    }

    public void publish(CarEntity carEntity){
        kafkaTemplate.send(CAR_TOPIC, carEntity.toString());
    }
}
