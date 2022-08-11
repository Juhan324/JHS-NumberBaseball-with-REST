package com.jhs.numberbaseball.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhs.numberbaseball.dao.UserDAO;
import com.jhs.numberbaseball.vo.UserVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LoginService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserDAO userMapper;

    @Transactional
    public void joinUser(UserVO user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        userMapper.insertUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        UserVO user = userMapper.getUser(id);
        if(user == null){
            throw new UsernameNotFoundException("User not authorized.");
        }
        String pw = user.getPassword();
        String role = user.getRole();
        return User.builder()
            .username(id)
            .password(pw)
            .roles(role)
            .build();
    }
    
}
