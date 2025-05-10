package org.gtvapi.controller;

import lombok.RequiredArgsConstructor;
import org.gtvapi.EntityStatus;
import org.gtvapi.entity.User;
import org.gtvapi.login.jwt.model.AuthRequest;
import org.gtvapi.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(("/register"))
@RequiredArgsConstructor
public class RegisterController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody AuthRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body("Kullanıcı adı zaten var.");
        }

        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setName(request.getName());
        newUser.setSurname(request.getSurname());
        newUser.setEmail(request.getEmail());
        newUser.setRecordStatus(EntityStatus.ACTIVE.getCode());

        userRepository.save(newUser);

        return ResponseEntity.ok("Kayıt başarılı");
    }

}
