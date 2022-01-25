/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.bootcamp.examwithdrawdeposit.controller;

import co.g2academy.bootcamp.examwithdrawdeposit.entity.Transactions;
import co.g2academy.bootcamp.examwithdrawdeposit.entity.Person;
import co.g2academy.bootcamp.examwithdrawdeposit.entity.PersonDetail;
import co.g2academy.bootcamp.examwithdrawdeposit.repository.TransactionsRepository;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.g2academy.bootcamp.examwithdrawdeposit.repository.PersonRepository;
import co.g2academy.bootcamp.examwithdrawdeposit.repository.PersonDetailRepository;
import co.g2academy.bootcamp.examwithdrawdeposit.response.PostTransactions;
import java.util.Optional;

/**
 *
 * @author King Engine
 */
@RestController
//@RequestMapping("api")
public class TransactionController {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private PersonDetailRepository personDetailRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/transaction")
    public ResponseEntity<List<Transactions>> getTransactions(Principal principal) {
        Person person = personRepository.findPersonByName(principal.getName());
        PersonDetail personDetail = personDetailRepository.findPersonByPerson(person);
        
        if (personDetail.getPerson() != null) {
            personDetail.setPerson(null);
        }
        
        List<Transactions> transactions = transactionsRepository.findTransactionsByPersonDetail(personDetail);
        return ResponseEntity.ok(transactions);
    }

    @PostMapping("/transaction")
    public ResponseEntity<PostTransactions> save(@RequestBody Transactions transaction, Principal principal) {
        Person person = personRepository.findPersonByName(principal.getName());
        PersonDetail personDetail = personDetailRepository.findPersonByPerson(person);

        if (transaction.getType_of_transaction().equalsIgnoreCase("deposit")) {
            personDetail.setBalance(personDetail.getBalance() + transaction.getTotal());
        } else if (transaction.getType_of_transaction().equalsIgnoreCase("withdraw")) {
            personDetail.setBalance(personDetail.getBalance() - transaction.getTotal());
        }

        personDetailRepository.save(personDetail);
        transaction.setPersonDetail(personDetail);
        transactionsRepository.save(transaction);
        
        PostTransactions postTransactions = new PostTransactions();
        postTransactions.setBalance(personDetail.getBalance());
        return ResponseEntity.ok(postTransactions);
    }
}
