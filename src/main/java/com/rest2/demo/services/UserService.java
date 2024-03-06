package com.rest2.demo.services;

import com.rest2.demo.models.UserModel;
import com.rest2.demo.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getAllUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> updateUser(UserModel request, Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isPresent()) {
            user.get().setFirstName(request.getFirstName());
            user.get().setLastName(request.getLastName());
            user.get().setEmail(request.getEmail());

            userRepository.save(user.get());
        }
        return user;
    }
   public Boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



}
