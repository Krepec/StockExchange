package pl.krepec.stockExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register", consumes = "application/json")
    public UserDAO addNewUser(@RequestBody UserDTO userDTO){
        return userService.addNewUser(userDTO);
    }

    @GetMapping("/{id}")
    public UserDAO findUserById(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }
}
