package org.example.resources;

import org.example.dto.LoginDTO;
import org.example.entities.Login;
import org.example.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/login")
public class LoginResource {

    @Autowired
    private LoginService loginService;

    @PostMapping("/auth")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginDTO loginDTO) {
        boolean autenticado = loginService.autenticar(loginDTO.getUsername(), loginDTO.getPassword());
        if (autenticado) {
            String token = "token_de_exemplo_123456";

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


    @PostMapping("/register")
    public ResponseEntity<String> registrar(@RequestBody LoginDTO loginDTO) {
        if (loginService.existeUsuario(loginDTO.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já existe");
        }
        Login novoLogin = new Login();
        novoLogin.setUsername(loginDTO.getUsername());
        novoLogin.setPassword(loginDTO.getPassword());
        loginService.salvarLogin(novoLogin);
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionário registrado com sucesso");
    }

}
