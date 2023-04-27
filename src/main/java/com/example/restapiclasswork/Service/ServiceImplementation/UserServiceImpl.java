package com.example.restapiclasswork.Service.ServiceImplementation;

import com.example.restapiclasswork.DTO.UserDTO;
import com.example.restapiclasswork.Model.User;
import com.example.restapiclasswork.Repository.UserRepository;
import com.example.restapiclasswork.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(UserDTO userDTO) {
        User user = new User(userDTO);
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->
                new NullPointerException("No user"));
        return user;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public User loginUser(UserDTO userDTO) {
        return null;
    }
}
