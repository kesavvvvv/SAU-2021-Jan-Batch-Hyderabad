package com.accolite.learningRest.controllers;

import com.accolite.learningRest.entity.UserData;
import com.accolite.learningRest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Map;

@RestController
@RequestMapping("/home/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signup")
    public UserData newUser(@RequestBody Map<String, String> userDet) {

        System.out.println((userDet));
        String email = userDet.get("email");
        String pass = userDet.get("pass");
        UserData user = new UserData();
        user.setEmail(email);
        user.setPass(pass);

        UserData savedUser = userService.addUser(user);
        return savedUser;
    }
    @GetMapping("/get/{id}")
    public UserData getUser(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateUser(@RequestBody UserData updateUser,
                                             @RequestHeader("password") String passwordLogin){
        UserData user = userService.getUserById(updateUser.getId());
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        if(bCryptPasswordEncoder.matches(passwordLogin, user.getPass())) {
            UserData us =  userService.updateUser(updateUser);
            return ResponseEntity.ok(us);
        }
        return ResponseEntity.ok("Invalid login");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id,
                                             @RequestHeader("password") String passwordLogin){
        UserData user = userService.getUserById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        if(bCryptPasswordEncoder.matches(passwordLogin, user.getPass())){
            String status = userService.deleteUser(id);
            return ResponseEntity.ok(status);
        }
        return ResponseEntity.ok("Invalid login");
    }
}
