package com.accolite.learningRest.controllers;

import com.accolite.learningRest.entity.PrivateMessage;
import com.accolite.learningRest.entity.UserData;
import com.accolite.learningRest.service.PmService;
import com.accolite.learningRest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home/message")
public class PmController {

    @Autowired
    UserService userService;

    @Autowired
    PmService pmService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/add/{userId}")
    public ResponseEntity<Object> postMessage(
            @RequestBody PrivateMessage privateMessage, @PathVariable("userId") Integer userId) {
        UserData user = userService.getUserById(userId);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        privateMessage.setUser(user);
        PrivateMessage createdMessage = pmService.add(privateMessage);
        return new ResponseEntity<Object>(createdMessage, HttpStatus.UNAUTHORIZED);
        }

    @GetMapping("/get/{userId}")
    public ResponseEntity<Object> getMessage(@PathVariable("userId") Integer userId,
                                             @RequestHeader("password") String password) {
        UserData user = userService.getUserById(userId);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        if(bCryptPasswordEncoder.matches(password, user.getPass())) {
            return ResponseEntity.ok(pmService.getMessages(userId));
        }
        return ResponseEntity.ok("Invalid cred");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id,
                                             @RequestHeader("password") String passwordLogin){
        UserData user = userService.getUserById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        if(bCryptPasswordEncoder.matches(passwordLogin, user.getPass())){
            String status = pmService.deletepm(id);
            return ResponseEntity.ok(status);
        }
        return ResponseEntity.ok("Invalid login");
    }


}
