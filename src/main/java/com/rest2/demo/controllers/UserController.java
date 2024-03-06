package com.rest2.demo.controllers;

import com.rest2.demo.models.UserModel;
import com.rest2.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/users")
public class UserController {

     @Autowired
        private UserService userService;

     //Retornar un listado de todos los usuarios
    @GetMapping("/")
    public ArrayList<UserModel> getAllUsers() {
        return this.userService.getAllUsers();
    }

    //Retornar un usuario por su id
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id) {
        return this.userService.getUserById(id);
    }

    //Guardar un usuario
    @PostMapping("/")
    public UserModel saveUser(UserModel user) {
        return this.userService.saveUser(user);
    }

    //Actualizar un usuario
    @PutMapping(path = "/{id}")
    public Optional<UserModel> updateUser(UserModel request, Long id) {
        return this.userService.updateUser(request, id);
    }

    //Eliminar un usuario
    @DeleteMapping(path = "/{id}")
    public Boolean deleteUser(Long id) {
        return this.userService.deleteUser(id);
    }
}
