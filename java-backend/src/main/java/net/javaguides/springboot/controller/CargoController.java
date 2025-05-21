package net.javaguides.springboot.controller;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Cargo;
import net.javaguides.springboot.repository.CargoRepository;

@CrossOrigin(origins = "http://localhost:8086")
@RestController
@RequestMapping("/api/v1/")
public class CargoController {
    @Autowired
    private CargoRepository cargoRepository;

    // get all cargos
    @GetMapping("/cargos")
    public List<Cargo> getAllCargos() {
        return cargoRepository.findAll();
    }

    // create cargo rest api
    @PostMapping("/cargos")
    public Cargo createCargo(@RequestBody Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    // get cargo by id rest api
    @GetMapping("/cargos/{id}")
    public ResponseEntity<Cargo> getCargoById(@PathVariable Long id) {
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cargo not exist with id :" + id));
        return ResponseEntity.ok(cargo);
    }

    // update cargo rest api
    @PutMapping("/cargos/{id}")
    public ResponseEntity<Cargo> updateCargo(@PathVariable Long id, @RequestBody Cargo cargoDetails) {
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cargo not exist with id :" + id));
        cargo.setNome(cargoDetails.getNome());
        cargo.setDescricao(cargoDetails.getDescricao());
        Cargo updatedCargo = cargoRepository.save(cargo);
        return ResponseEntity.ok(updatedCargo);
    }

    // delete cargo rest api
    @DeleteMapping("/cargos/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCargo(@PathVariable Long id) {
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cargo not exist with id :" + id));

        cargoRepository.delete(cargo);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
