package com.example.login_auth_api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login_auth_api.domain.user.User;
import com.example.login_auth_api.dto.UserDTO;
import com.example.login_auth_api.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("{email}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String email) {

        UserDTO userRetorno = new UserDTO();

        Optional<User> usuario = userRepository.findByEmail(email);
        if (usuario.isPresent()) {
            userRetorno.setNome(usuario.get().getName());
            userRetorno.setEmail(usuario.get().getEmail());
        }
        return ResponseEntity.ok(userRetorno);

    }
}
