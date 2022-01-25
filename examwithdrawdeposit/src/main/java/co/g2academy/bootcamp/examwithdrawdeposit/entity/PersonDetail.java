/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.bootcamp.examwithdrawdeposit.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author King Engine
 */
@Entity
@Table(name = "T_PERSON_DETAIL")
public class PersonDetail implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person_detail")
    private Integer id_person_detail;
    
    @OneToOne
    @JoinColumn(name = "id_person", nullable = false)
    private Person person;
    
    @Column(name = "account_number", nullable = false, length = 255)
    private String account_number;
    
    @Column(name = "balance", nullable = false)
    private Integer balance;

    public Integer getId_person_detail() {
        return id_person_detail;
    }

    public void setId_person_detail(Integer id_person_detail) {
        this.id_person_detail = id_person_detail;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
    
    
    
}
