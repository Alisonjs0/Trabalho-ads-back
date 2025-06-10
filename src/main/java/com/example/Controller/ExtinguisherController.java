package com.example.Controller;

import com.example.Entity.ExtinguisherEntity;
import com.example.Repository.ExtinguisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/extinguisher")
public class ExtinguisherController {

    @Autowired
    private final ExtinguisherRepository extinguisherRepository;

    public ExtinguisherController(ExtinguisherRepository extinguisherRepository){
        this.extinguisherRepository = extinguisherRepository;
    }

    @PostMapping
    public ExtinguisherEntity createExtinguisher(@RequestBody ExtinguisherEntity extinguisherEntity) {
        return extinguisherRepository.save(extinguisherEntity);
    }

    @GetMapping
    public List<ExtinguisherEntity> getAllExtinguishers() {
        return extinguisherRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExtinguisherEntity> getExtinguisher(@PathVariable long id) {
        return extinguisherRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delExtinguisher(@PathVariable Long id) {
        Optional<ExtinguisherEntity> extinguisherOptional = extinguisherRepository.findById(id);

        if (extinguisherOptional.isPresent()) {
            extinguisherRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExtinguisherEntity> updateUser(@PathVariable Long id, @RequestBody ExtinguisherEntity updateExtinguisher) {
        Optional<ExtinguisherEntity> existingExtinguisherOptional = extinguisherRepository.findById(id);

        if (existingExtinguisherOptional.isPresent()) {
            ExtinguisherEntity existingExtinguisher = existingExtinguisherOptional.get();

//            updateExtinguisher.setName(updateExtinguisher.getName());
            updateExtinguisher.setValidate(updateExtinguisher.getValidate());
            updateExtinguisher.setAgentType(updateExtinguisher.getAgentType());
            updateExtinguisher.setFireClass(updateExtinguisher.getFireClass());
            updateExtinguisher.setCapacity(updateExtinguisher.getCapacity());
            updateExtinguisher.setManufacturingDate(updateExtinguisher.getManufacturingDate());

//            updateExtinguisher.setMaturityDate(updateExtinguisher.getMaturityDate());
//            updateExtinguisher.setUnitId(updateExtinguisher.getUnitId());


            extinguisherRepository.save(existingExtinguisher);

            return ResponseEntity.ok(existingExtinguisher); // 200 OK com o usuário atualizado
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found se o ID não existir
        }
    }
}
