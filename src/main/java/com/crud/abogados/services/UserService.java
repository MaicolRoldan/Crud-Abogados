package com.crud.abogados.services;

import com.crud.abogados.entity.User;
import com.crud.abogados.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Método existente para guardar un usuario
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Método existente para obtener un usuario por ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Método existente para obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Método existente para eliminar un usuario
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Nuevo método para encontrar un usuario por nombre de usuario y contraseña
    public User findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
