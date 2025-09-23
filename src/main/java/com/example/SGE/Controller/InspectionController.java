package com.example.SGE.Controller;

import com.example.SGE.Entity.InspectionEntity;
import com.example.SGE.Repository.InspectionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inspections")
public class InspectionController {
    private final InspectionRepository inspectionRepository;

    public InspectionController(InspectionRepository inspectionRepository) {
        this.inspectionRepository = inspectionRepository;
    }

    @PostMapping
    public InspectionEntity createInspection(@RequestBody InspectionEntity inspectionEntity) {
        return inspectionRepository.save(inspectionEntity);
    }

    @GetMapping
    public List<InspectionEntity> getAllInspections() {
        return inspectionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InspectionEntity> getInspection(@PathVariable long id) {
        return inspectionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delInspection(@PathVariable Long id) {
        Optional<InspectionEntity> inspectionOptional = inspectionRepository.findById(id);

        if (inspectionOptional.isPresent()) {
            inspectionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<InspectionEntity> updateInspection(@PathVariable Long id, @RequestBody InspectionEntity updateInspection) {
        Optional<InspectionEntity> existingInspectionOptional = inspectionRepository.findById(id);

        if (existingInspectionOptional.isPresent()) {
            InspectionEntity existingInspection = existingInspectionOptional.get();

            existingInspection.setInspectionDate(updateInspection.getInspectionDate());
            existingInspection.setInspectionAuthor(updateInspection.getInspectionAuthor());
            existingInspection.setExtinguisher(updateInspection.getExtinguisher());
            existingInspection.setManometro(updateInspection.isManometro());
            existingInspection.setSeal(updateInspection.isSeal());
            existingInspection.setRotulo(updateInspection.isRotulo());
            existingInspection.setDamages(updateInspection.isDamages());
            existingInspection.setObstructions(updateInspection.isObstructions());
            existingInspection.setSinalizacao(updateInspection.isSinalizacao());
            existingInspection.setSuporteFixacao(updateInspection.isSuporteFixacao());

            inspectionRepository.save(existingInspection);

            return ResponseEntity.ok(existingInspection); // 200 OK com o usuário atualizado
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found se o ID não existir
        }
    }

}
