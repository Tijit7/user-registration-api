package com.userregistration;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String name;
    private String gender;

    @Column(nullable = false)
    private String password;

    // Getters and Setters
}
