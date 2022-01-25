/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.g2academy.bootcamp.examwithdrawdeposit.repository;

import co.g2academy.bootcamp.examwithdrawdeposit.entity.Person;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author King Engine
 */
public interface PersonRepository extends CrudRepository<Person, Integer>{
    
    public Person findPersonByName (String username);
    
}
