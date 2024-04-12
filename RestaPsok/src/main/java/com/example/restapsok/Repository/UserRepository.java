package com.example.restapsok.Repository;

import com.example.restapsok.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
