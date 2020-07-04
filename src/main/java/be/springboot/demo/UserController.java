package be.springboot.demo;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://sreggers.github.io")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    private Flux<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    private Mono<User> addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

}
