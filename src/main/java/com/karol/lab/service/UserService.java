package com.karol.lab.service;

import com.karol.lab.model.User;
import com.karol.lab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public interface UserService {


    Optional<User> findByUsername(String username);
    String registerUser(User user);

    User getCurrentUser();


}
