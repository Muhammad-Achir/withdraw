/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.g2academy.bootcamp.examwithdrawdeposit.repository;

import co.g2academy.bootcamp.examwithdrawdeposit.entity.Person;
import co.g2academy.bootcamp.examwithdrawdeposit.entity.PersonDetail;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author King Engine
 */
public interface PersonDetailRepository extends CrudRepository<PersonDetail, Integer>{
    
    public PersonDetail findPersonByPerson (Person person);
    
//    public PersonDetail findPersonByBalance (String name);
    
}
