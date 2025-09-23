package com.example.SGE.Controller;


import com.example.SGE.Entity.AlertEntity;
import com.example.SGE.Repository.AlertRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alert")
public class AlertController {
    private final AlertRepository alertRepository;

    public AlertController(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @PostMapping
    public AlertEntity alertCreate(@RequestBody AlertEntity alert) {
        alert.setSendDate(LocalDateTime.now());
        return alertRepository.save(alert);
    }

    @GetMapping
    public List<AlertEntity> getAllAlerts() {
        return alertRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertEntity> getAlertId(@PathVariable long id) {
        return alertRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delAlert(@PathVariable Long id) {
        Optional<AlertEntity> alertOptional = alertRepository.findById(id);

        if (alertOptional.isPresent()) {
            alertRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertEntity> updateAlert(@PathVariable Long id, @RequestBody AlertEntity updateAlert) {
        Optional<AlertEntity> existingAlertOptional = alertRepository.findById(id);

        if (existingAlertOptional.isPresent()) {
            AlertEntity existingAlert = existingAlertOptional.get();

            existingAlert.setAlertType(updateAlert.getAlertType());
            existingAlert.setAlertAuthor(updateAlert.getAlertAuthor());
            existingAlert.setDescription(updateAlert.getDescription());
            existingAlert.setSendDate(updateAlert.getSendDate());

            alertRepository.save(existingAlert);

            return ResponseEntity.ok(existingAlert); // 200 OK com o usuário atualizado
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found se o ID não existir
        }
    }
}
