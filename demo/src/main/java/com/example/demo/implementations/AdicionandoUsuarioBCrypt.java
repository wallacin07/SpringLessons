package com.example.demo.implementations;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.dto.Ex6;
import com.example.demo.model.Usuario;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.addUserBCrypt;

public class AdicionandoUsuarioBCrypt implements addUserBCrypt {

    @Override
    public boolean newUserBCrypt(Ex6 infUser, UserRepository repo) {
        boolean deuboa = false;
        String emailPost = infUser.email();
        String usernamePost = infUser.username();
        String senhaPost = infUser.password();
        var Usuario = repo.findByUsername(usernamePost);
        var email = repo.findByEmail(emailPost);
        if (Usuario.size() == 0 && email.size() == 0) {
            if (usernamePost.length() > 4 && emailPost.length() > 4) {
                if (emailPost.contains("@")) {
                    Usuario newUser = new Usuario();
                    var encoder = new BCryptPasswordEncoder();
                    String encryptedPassword = encoder.encode(senhaPost);
                    newUser.setEmail(emailPost);
                    newUser.setPassword(encryptedPassword);
                    newUser.setUsername(usernamePost);
                    repo.save(newUser);
                    deuboa = true;
                }
            }
        }
        return deuboa;
    }

}
