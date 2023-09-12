package com.gfa.springadvanced;

import com.gfa.springadvanced.models.User;
import com.gfa.springadvanced.repositories.UserRepository;
import com.gfa.springadvanced.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAdvancedApplication implements CommandLineRunner {
    private final UserService userService;
    private final UserRepository userRepository;
    @Autowired
    public SpringAdvancedApplication(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringAdvancedApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Lapca", "11111", "lapca@lapca.com");
        User user2 = new User("Erik", "22222", "erik@erik.com");
        User user3 = new User("Gusti", "33333", "gusti@gusti.com");
        User user4 = new User("Laci", "44444", "laci@laci.com");
        User user5 = new User("Pavel", "55555", "pavel@pavel.com");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
    }
}
