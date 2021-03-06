package pl.krepec.stockExchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krepec.stockExchange.Operation;
import pl.krepec.stockExchange.model.UserDTO;
import pl.krepec.stockExchange.repository.model.UserDAO;
import pl.krepec.stockExchange.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/stockexchange/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDTO findUserById(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }

    @GetMapping("/user")
    public List<UserDAO> findAllUsers() {
        return userService.finadAllUsers();
    }

    @GetMapping(value = "/check")
    public Boolean checkUserExist(@RequestParam(required = true, value = "username") String userName) {

        try {
            return userService.checkUserNameExist(userName);
        } catch (NullPointerException e) {
            System.out.println("User name don't exist");
        }

        return false;
    }

    @GetMapping("/login")
    public UserDTO login(@RequestParam(required = true, value = "username") String userName,
                          @RequestParam(required = true, value = "password") String password) {
        return userService.findByUserNameAndPassword(userName, password);
    }

    @PutMapping("/{id}")
    private String updateUserCash(@PathVariable(required = true, value = "id") Integer id,
                                  @RequestParam(required = true, value = "quantity") Integer quantity,
                                  @RequestParam(required = true, value = "operation") Operation operation,
                                  @RequestParam(required = true, value = "stockSymbol") String stockSymbol)

    {

        return userService.updateUserCash(id, quantity, operation, stockSymbol);

    }


    @PostMapping(value = "/user", consumes = "application/json")
    public Integer addNewUser(@RequestBody UserDTO userDTO) {
        return userService.addNewUser(userDTO);
    }


}
