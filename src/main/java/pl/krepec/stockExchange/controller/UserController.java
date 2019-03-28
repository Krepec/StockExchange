package pl.krepec.stockExchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krepec.stockExchange.model.UserDTO;
import pl.krepec.stockExchange.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserDTO findUserById(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }


    @PostMapping(value = "/register", consumes = "application/json")
    public Integer addNewUser(@RequestBody UserDTO userDTO){
        return userService.addNewUser(userDTO);
    }


}
