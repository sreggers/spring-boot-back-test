package be.springboot.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin(origins = "https://sreggers.github.io")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() throws ExecutionException, InterruptedException {
        return userService.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user) throws ExecutionException, InterruptedException {
        userService.save(user);
    }

}
