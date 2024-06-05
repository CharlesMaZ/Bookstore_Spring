package com.karol.lab.service;

import com.karol.lab.model.Role;
import com.karol.lab.model.User;
import com.karol.lab.repository.RoleRepository;
import com.karol.lab.repository.UserRepository;
import com.karol.lab.repository.UserRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    //@Qualifier("UserRepositoryCustomImpl")
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

//    @Transactional
//    public Optional<User> findByUsername(String username){
//        return userRepository.findByUsername(username);
//
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User nort found with username: " + username));
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));

    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }




//    @Transactional
//    public  String registerUser(User user){
//        if (userRepository.findByUsername(user.getUsername()).isPresent()){
//            return "failure";
//        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//
//        Role userRole = roleRepository.findByName("USER").orElseGet(null);
//        if (userRole != null){
//            user.getRoles().add(userRole);
//
//        }
//        else {
//            Role role = new Role();
//            role.setName("USER");
//            user.getRoles().add(role);
//
//        }
//        userRepository.save(user);
//        return  "success";
//
//    }

}
