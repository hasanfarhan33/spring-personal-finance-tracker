package com.example.spring_personal_finance_tracker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_personal_finance_tracker.model.Transaction;
import com.example.spring_personal_finance_tracker.repository.TransactionRepository;


// TODO: Add more methods to the TransactionService class as needed
@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository; 
    }
 
    // GET ALL TRANSACTIONS
    public Iterable<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    // GET ONE TRANSACTION BY ID
    public Optional<Transaction> getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId)
    }

    // GET TRANSACTION BY USER ID 
    public Optional<Transaction> getTransactionByUserId(long userId) {
        return transactionRepository.findByUserId(userId);
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // DELETE TRANSACTION
    public void deleteTransaction(long transactionId) {
        transactionRepository.deleteById(transactionId);
    }
    
}
