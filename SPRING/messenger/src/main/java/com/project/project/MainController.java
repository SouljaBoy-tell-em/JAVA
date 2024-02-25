package com.project.project;


import com.project.project.rabbitmq.RabbitMQSender;
import com.project.project.repositories.UserRepository;
import com.project.project.user.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Configuration
@Controller
@RequestMapping
@SessionAttributes(names = "user")
public class MainController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @ModelAttribute(name = "user")
    public User User() {
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        if(authentication.isAuthenticated()) {
            User user = userRepository.findById(authentication.getName()).get();
            return user;
        }
        return new User();
    }

    @GetMapping("/register")
    public String REGISTER() {
        return "register";
    }

    @GetMapping("/profile")
    public String PROFILE() {
        return "profile";
    }

    @GetMapping("/successfully_register")
    public String SUCCESSFULLY_REGISTER() {
        return "successfully_register";
    }

    @PostMapping("/successfully_register")
    public String POST_MAPPING_SUCCESSFULLY_REGISTER(@ModelAttribute(name = "user") User user) {
        userRepository.save(new User(user.getUsername(),
                passwordEncoder.encode(user.getPassword())));

        return "successfully_register";
    }

    @PostMapping("/profile")
    public String POST_MAPPING_PROFILE(@ModelAttribute(name = "user") User user) {
        return "profile";
    }

    @GetMapping("/send")
    public String SEND_MESSAGE(@ModelAttribute(name = "user") User user) {

        USER_INFO(user);
        return "empty";
    }

    public void USER_INFO(User user) {
        System.out.println("#####INFO: #####");
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
    }
}
