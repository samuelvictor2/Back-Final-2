package org.example.services;

import org.example.entities.Login;
import org.example.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void salvarLogin(Login login) {
        // Criptografa senha antes de salvar
        login.setPassword(passwordEncoder.encode(login.getPassword()));
        loginRepository.save(login);
    }

    public boolean autenticar(String username, String password) {
        Login usuario = loginRepository.findByUsername(username);
        if (usuario == null) {
            return false;
        }
        // Verifica senha
        return passwordEncoder.matches(password, usuario.getPassword());
    }
    // LoginService.java
    public boolean existeUsuario(String username) {
        return loginRepository.findByUsername(username) != null;
    }

}
