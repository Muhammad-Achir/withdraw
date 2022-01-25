/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.bootcamp.examwithdrawdeposit.controller;

import co.g2academy.bootcamp.examwithdrawdeposit.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import co.g2academy.bootcamp.examwithdrawdeposit.repository.PersonRepository;

/**
 *
 * @author King Engine
 */
@RestController
public class RegisterController {
    
    @Autowired
    private PersonRepository personRepository;
    
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
    @PostMapping("/register")
    public ResponseEntity<String> register (@RequestBody Person register) {
        String encryptedPassword = passwordEncoder.encode(register.getPassword());
        register.setPassword(encryptedPassword);
        personRepository.save(register);
        return ResponseEntity.ok("ok");
    }
    
}
