package com.crud.abogados.repository;

import com.crud.abogados.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Método para encontrar un usuario por nombre de usuario y contraseña
    User findByUsernameAndPassword(String username, String password);
}
