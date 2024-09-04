package com.crud.abogados.controller;

import com.crud.abogados.entity.User;
import com.crud.abogados.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users") // Ruta base para el controlador
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register") // Ruta para mostrar el formulario de registro
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // Nombre del archivo Thymeleaf (src/main/resources/templates/register.html)
    }

    @PostMapping("/register") // Ruta para procesar el registro
    public String registerUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("message", "User registered successfully!");
        return "redirect:/users/login"; // Redirige al login después del registro
    }

    @GetMapping("/login") // Ruta para mostrar el formulario de login
    public String showLoginForm(Model model) {
        return "login"; // Nombre del archivo Thymeleaf (src/main/resources/templates/login.html)
    }

    @PostMapping("/login") // Ruta para procesar el login
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.findUserByUsernameAndPassword(username, password);
        if (user != null) {
            return "redirect:/clientes"; // Redirige al apartado de clientes si el usuario es válido
        } else {
            model.addAttribute("error", "Invalid username or password.");
            return "login"; // Regresar al formulario de inicio de sesión si el usuario es inválido
        }
    }
}
