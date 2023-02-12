package it.gianottoroberto.simplecrud.controller;

import it.gianottoroberto.simplecrud.service.UserService;
import it.gianottoroberto.simplecrud.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Add a new user to the database
     * @param userDTO userDTO
     * @return html template
     */
    @GetMapping("/signup")
    public String showSignupForm(UserDTO userDTO) {
        return "add-user";
    }

    @PostMapping("/addUser")
    public String addUser(@Valid UserDTO userDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add-user";
        }

        userService.addNewUser(userDTO);

        return "index";
    }

}
