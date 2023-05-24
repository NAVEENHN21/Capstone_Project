package com.example.Medicare.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Medicare.entity.Medicine;

public interface MedicineRepository extends CrudRepository<Medicine, Integer> {

}
