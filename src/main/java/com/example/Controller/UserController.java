package com.example.Controller;

import com.example.Entity.UserEntity;

import com.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:8081")
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public String createUser(@RequestBody UserEntity user) {
        userRepository.save(user);
        return "Usuario Salvo";
    }

    @GetMapping
    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserId(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delUser(@PathVariable Long id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity updatedUser) {
        Optional<UserEntity> existingUserOptional = userRepository.findById(id);

        if (existingUserOptional.isPresent()) {
            UserEntity existingUser = existingUserOptional.get();

            existingUser.setNome(updatedUser.getNome());
            existingUser.setCpf(updatedUser.getCpf());
            existingUser.setCargo(updatedUser.getCargo());
            existingUser.setEmail(updatedUser.getEmail());

            userRepository.save(existingUser);

            return ResponseEntity.ok(existingUser); // 200 OK com o usuário atualizado
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found se o ID não existir
        }
    }


}
