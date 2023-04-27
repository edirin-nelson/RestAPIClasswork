package com.example.restapiclasswork.Service;

import com.example.restapiclasswork.DTO.UserDTO;
import com.example.restapiclasswork.Model.User;

import java.util.List;

public interface UserService {
    User saveUser(UserDTO userDTO);

    List<User> findAll();

    User findById(Long id);

    void deleteById(Long id);

    User loginUser(UserDTO userDTO);

    User updateUser(Long id, UserDTO userDTO);
}
