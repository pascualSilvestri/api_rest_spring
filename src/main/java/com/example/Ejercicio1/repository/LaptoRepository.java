package com.example.Ejercicio1.repository;

import com.example.Ejercicio1.models.Lapto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptoRepository extends JpaRepository<Lapto,Long> {
}
