package com.karol.lab.service;

import com.karol.lab.model.User;
import com.karol.lab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface UserService {


    Optional<User> findByUsername(String username);
    String registerUser(User user);

    User getCurrentUser();


}
