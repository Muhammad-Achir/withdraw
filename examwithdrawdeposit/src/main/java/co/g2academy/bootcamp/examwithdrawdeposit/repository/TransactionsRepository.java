/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.g2academy.bootcamp.examwithdrawdeposit.repository;

import co.g2academy.bootcamp.examwithdrawdeposit.entity.Person;
import co.g2academy.bootcamp.examwithdrawdeposit.entity.PersonDetail;
import co.g2academy.bootcamp.examwithdrawdeposit.entity.Transactions;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author King Engine
 */
public interface TransactionsRepository extends CrudRepository<Transactions, Integer>{
    
    public List <Transactions> findTransactionsByPersonDetail (PersonDetail personDetail);
    
//    public Transactions saveTransactionsByPersonAndDetail (Person person, PersonDetail personDetail);
    
}
