package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Cargo; // Importa a sua classe Cargo

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
