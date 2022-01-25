/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.bootcamp.examwithdrawdeposit.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author King Engine
 */
@Entity
@Table(name = "T_TRANSACTIONS")
public class Transactions implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transactions")
    private Integer id_transactions;
    
    @ManyToOne
    @JoinColumn(name = "id_person_detail", nullable = false)
    private PersonDetail personDetail;
    
    @Column(name = "transaction_date", nullable = false)
    private Date transaction_date;
    
    @Column(name = "type_of_transaction", nullable = false, length = 255)
    private String type_of_transaction;
    
    @Column(name = "total", nullable = false)
    private Integer total;

    public Integer getId_transactions() {
        return id_transactions;
    }

    public void setId_transactions(Integer id_transactions) {
        this.id_transactions = id_transactions;
    }

    public PersonDetail getPersonDetail() {
        return personDetail;
    }

    public void setPersonDetail(PersonDetail personDetail) {
        this.personDetail = personDetail;
    }

    public Date getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }

    public String getType_of_transaction() {
        return type_of_transaction;
    }

    public void setType_of_transaction(String type_of_transaction) {
        this.type_of_transaction = type_of_transaction;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    
    
    
}
