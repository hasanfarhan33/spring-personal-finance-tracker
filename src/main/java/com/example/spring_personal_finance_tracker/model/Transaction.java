package com.example.spring_personal_finance_tracker.model;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Represents a financial transaction.
 * 
 * <p>This entity is mapped to the "TRANSACTIONS" table in the database.
 * Each transaction is associated with a user and contains details such as
 * type, amount, description, and creation timestamp.</p>
 * 
 * <p>Attributes:</p>
 * <ul>
 *   <li>id: Unique identifier for the transaction.</li>
 *   <li>user: The user associated with the transaction.</li>
 *   <li>type: The type of transaction (e.g., income, expense).</li>
 *   <li>amount: The amount of the transaction.</li>
 *   <li>description: A brief description of the transaction.</li>
 *   <li>createdAt: The timestamp when the transaction was created.</li>
 * </ul>
 * 
 * <p>Constructors:</p>
 * <ul>
 *   <li>Transaction(): Default constructor.</li>
 *   <li>Transaction(long id, User user, String type, double amount, String description): Constructor with all attributes except createdAt.</li>
 *   <li>Transaction(User user, String type, double amount, String description): Constructor without id and createdAt.</li>
 * </ul>
 * 
 * <p>Methods:</p>
 * <ul>
 *   <li>getId(): Returns the transaction id.</li>
 *   <li>setId(long id): Sets the transaction id.</li>
 *   <li>getUser(): Returns the user associated with the transaction.</li>
 *   <li>setUser(User user): Sets the user associated with the transaction.</li>
 *   <li>getType(): Returns the type of transaction.</li>
 *   <li>setType(String type): Sets the type of transaction.</li>
 *   <li>getAmount(): Returns the amount of the transaction.</li>
 *   <li>setAmount(double amount): Sets the amount of the transaction.</li>
 *   <li>getDescription(): Returns the description of the transaction.</li>
 *   <li>setDescription(String description): Sets the description of the transaction.</li>
 *   <li>getCreatedAt(): Returns the creation timestamp of the transaction.</li>
 *   <li>setCreatedAt(LocalDateTime createdAt): Sets the creation timestamp of the transaction.</li>
 *   <li>toString(): Returns a string representation of the transaction.</li>
 * </ul>
 */
@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    @ManyToOne 
    @JoinColumn(name = "user_id", nullable = false)
    private User user; 
    @Column(nullable = false)
    private String type; 
    @Column(nullable = false)
    private double amount; 
    @Column(nullable = true)
    private String description;
    @Column(name = "created_at", nullable = false) 
    private LocalDateTime createdAt; 
    
    public Transaction() {}

    public Transaction(long id, User user, String type, double amount, String description) {
        this.id = id; 
        this.user = user; 
        this.type = type; 
        this.amount = amount; 
        this.description = description; 
    }

    public Transaction(User user, String type, double amount, String description) {
        this.user = user; 
        this.type = type; 
        this.amount = amount; 
        this.description = description; 
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", user='" + getUser() + "'" +
            ", type='" + getType() + "'" +
            ", amount='" + getAmount() + "'" +
            ", description='" + getDescription() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            "}";
    }


}
