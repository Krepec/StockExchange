package pl.krepec.stockExchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krepec.stockExchange.model.UserDTO;
import pl.krepec.stockExchange.repository.model.UserDAO;
import pl.krepec.stockExchange.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/stockexchange/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public UserDTO findUserById(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }

    @GetMapping("/user")
    public List<UserDAO> findAllUsers() {
        return userService.finadAllUsers();
    }

    @GetMapping(value = "/check")
    public Boolean checkUserExist(@RequestParam(required = true,value = "username") String userName) {
        return userService.checkUserNameExist(userName);

    }

    @GetMapping("/login")
    private UserDTO login(@RequestParam (required = true, value = "username") String userName,
                          @RequestParam (required = true , value = "password") String password){
        return userService.findByUserNameAndPassword(userName, password);
    }

    @PostMapping(value = "/register", consumes = "application/json")
    public Integer addNewUser(@RequestBody UserDTO userDTO) {
        return userService.addNewUser(userDTO);
    }

}
