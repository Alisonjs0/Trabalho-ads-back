package com.example.Controller;

import com.example.DTO.LoginRequest;
import com.example.DTO.LoginResponse;
import com.example.Entity.UserEntity;
import com.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        List<UserEntity> users = userRepository.findByCpf(request.getCpf());

        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não encontrado.");
        }

        // Filtra o usuário com senha correta
        UserEntity usuario = users.stream()
                .filter(u -> u.getSenha().equals(request.getPassword()))
                .findFirst()
                .orElse(null);

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta.");
        }

        return ResponseEntity.ok(new LoginResponse("Login realizado com sucesso", usuario.getNome()));
    }
}
