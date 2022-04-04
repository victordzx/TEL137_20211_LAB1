package edu.pucp.gtics.lab1_gtics_20211.repository;

import edu.pucp.gtics.lab1_gtics_20211.entity.Juegos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegosRepository extends JpaRepository<Juegos, Integer> {
}