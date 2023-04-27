package com.example.restapiclasswork.Repository;

import com.example.restapiclasswork.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
