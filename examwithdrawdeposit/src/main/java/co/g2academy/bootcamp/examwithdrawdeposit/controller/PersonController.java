/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.bootcamp.examwithdrawdeposit.controller;

import co.g2academy.bootcamp.examwithdrawdeposit.entity.Person;
import co.g2academy.bootcamp.examwithdrawdeposit.entity.PersonDetail;
import co.g2academy.bootcamp.examwithdrawdeposit.repository.PersonDetailRepository;
import co.g2academy.bootcamp.examwithdrawdeposit.repository.PersonRepository;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author King Engine
 */
@RestController
public class PersonController {
    
    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private PersonDetailRepository personDetailRepository;
    
    @PostMapping("/person-detail")
    public ResponseEntity<String> setPersonDetail (@RequestBody PersonDetail personDetail, Principal principal) {
        if (principal != null) {
            Person person = personRepository.findPersonByName(principal.getName());
            personDetail.setPerson(person);
            personDetailRepository.save(personDetail);
        }
        return ResponseEntity.ok("ok");
    }
    
}
