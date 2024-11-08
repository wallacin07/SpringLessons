package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Usuario;


@Repository
public interface UserRepository  extends JpaRepository<Usuario, Long>{
    List<Usuario> findByUsername(String Username);
    List<Usuario> findByEmail(String Email);

    @Query("SELECT u FROM Usuario u WHERE u.username = :loginValue or u.email = :loginValue")
    List<Usuario> login(@Param("loginValue") String loginValue);
}