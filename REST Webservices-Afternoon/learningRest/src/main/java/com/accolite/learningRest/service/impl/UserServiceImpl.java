package com.accolite.learningRest.service.impl;

import com.accolite.learningRest.entity.UserData;
import com.accolite.learningRest.repository.UserRepository;
import com.accolite.learningRest.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Bean
    @Primary
    public BCryptPasswordEncoder getpce()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserData addUser(UserData user) {
        //Encrypt pass
        String plainPassword = user.getPass();
        String encryptedPassword = getEncryptedPassword(plainPassword);
        user.setPass(encryptedPassword);
        //Add to DB

        UserData saveddUser = userRepository.save(user);
        return saveddUser;
    }

    @Override
    public UserData getUserById(Integer id) {
        Optional<UserData> user = userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }
    @Override
    public UserData updateUser(UserData user) {
        String plainPassword = user.getPass();
        String encryptedPassword = getEncryptedPassword(plainPassword);
        user.setPass(encryptedPassword);
        user = userRepository.save(user);
        return user;
    }

    @Override
    public String deleteUser(Integer id){
        userRepository.deleteById(id);
        return "Delete Success";
    }
    private String getEncryptedPassword(String plainPassword) {
        return getpce().encode(plainPassword);
    }


}
