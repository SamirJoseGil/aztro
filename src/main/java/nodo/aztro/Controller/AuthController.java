package nodo.aztro.Controller;

import nodo.aztro.Config.JwtUtil;
import nodo.aztro.Models.User;
import nodo.aztro.Services.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (user == null) {
            return ResponseEntity.badRequest().body("El cuerpo de la solicitud está vacío.");
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("El email no puede estar vacío.");
        }

        // Validar si el email ya está en uso
        if (userService.findUserByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("El email ya está en uso.");
        }

        // Guardar el usuario
        userService.saveUser(user);
        return ResponseEntity.ok("Usuario registrado exitosamente.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody User user) {
        try {
            // Intentar autenticar al usuario
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            // Generar JWT
            String jwtToken = jwtUtil.generateToken(user.getUsername());

            // Devolver el JWT al usuario
            return ResponseEntity.ok("Bearer " + jwtToken);
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().body("Credenciales inválidas.");
        }
    }

}