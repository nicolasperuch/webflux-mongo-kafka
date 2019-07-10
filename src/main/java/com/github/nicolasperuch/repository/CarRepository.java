package com.github.nicolasperuch.repository;

import com.github.nicolasperuch.entity.CarEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CarRepository extends ReactiveMongoRepository <CarEntity, String>{ }
