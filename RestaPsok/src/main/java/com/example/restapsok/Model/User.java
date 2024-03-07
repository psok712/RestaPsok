package com.example.restapsok.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    public Long id;
    @Column(name="username", nullable = false)
    public String username;
    @Column(name="password", nullable = false)
    public String password;
    @Column(name="role", nullable = false)
    public Role role = Role.GUEST;
}
