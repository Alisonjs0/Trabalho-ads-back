package com.example.SGE.Controller;

import com.example.SGE.Entity.UnitEntity;
import com.example.SGE.Repository.UnitRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/unit")
public class UnitController {
    private final UnitRepository unitRepository;

    public UnitController(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @PostMapping
    public UnitEntity createUnit(@RequestBody UnitEntity unitEntity) {
        return unitRepository.save(unitEntity);
    }

    @GetMapping
    public List<UnitEntity> getAllUnits() {
        return unitRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnitEntity> getUnit(@PathVariable long id) {
        return unitRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delUnit(@PathVariable Long id) {
        Optional<UnitEntity> unitOptional = unitRepository.findById(id);

        if (unitOptional.isPresent()) {
            unitRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnitEntity> updateUnit(@PathVariable Long id, @RequestBody UnitEntity updateUnit) {
        Optional<UnitEntity> existingUnitOptional = unitRepository.findById(id);

        if (existingUnitOptional.isPresent()) {
            UnitEntity existingUnit = existingUnitOptional.get();

            existingUnit.setName(updateUnit.getName());
//            existingUnit.setUserId(updateUnit.getUserId());
//            existingUnit.setExtinguisherAmount(updateUnit.getExtinguisherAmount());

            unitRepository.save(existingUnit);

            return ResponseEntity.ok(existingUnit); // 200 OK com o usuário atualizado
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found se o ID não existir
        }
    }
}





