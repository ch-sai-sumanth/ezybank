package com.sumanth.bank.ezybank.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String accountNumber;

    @NotEmpty
    private String accountType="Savings";



    @NotEmpty
    private String bankName="EzyBank";

    @NotEmpty
    private String branch="Gacchibowli,Hyderabad";

    @NotEmpty
    private String ifscCode="GCB0001";

    private double balance;
    private String pin;

    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private List<Token> tokens = new ArrayList<>();
}
