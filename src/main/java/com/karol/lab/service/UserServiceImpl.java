package com.karol.lab.service;

import com.karol.lab.model.Cart;
import com.karol.lab.model.Role;
import com.karol.lab.model.User;
import com.karol.lab.repository.RoleRepository;
import com.karol.lab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;
    @Transactional
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);

    }

    @Transactional
    public String registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()){
            return "failure";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCart(new Cart());
        //Role userRole = roleRepository.findByName("USER").orElseGet(null);
        Role userRole = roleRepository.findByName("USER").orElse(null);
        if (userRole != null){
            user.getRoles().add(userRole);
        }
        else {
            Role role = new Role();
            role.setName("USER");
            user.getRoles().add(role);
            //userRepository.save(user);

        }
        userRepository.save(user);
        return "success";
    }

    @Transactional
    public User getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        return userRepository.findByUsername(username).orElse(null);
    }

    @Transactional
    public void save(User user){
        userRepository.save(user);
    }
}
