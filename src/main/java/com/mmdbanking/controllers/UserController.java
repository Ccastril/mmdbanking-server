package com.mmdbanking.controllers;

//Enable cross origins to recieve request

import com.mmdbanking.models.Account;
import com.mmdbanking.services.IUserService;
import com.mmdbanking.templates.LoginFormTemplate;
import com.mmdbanking.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("users")
public class UserController {
    //get a service object
    @Autowired
    private IUserService userService;

    //get request
    //response body is used to return only data not rendered web pages
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<User> login(@RequestBody LoginFormTemplate lft) {
        User retrievedUser = userService.login(lft);
        for (Account account : retrievedUser.getAccounts()) {
        }

        return ResponseEntity.status(HttpStatus.OK).body(retrievedUser);
    }
    @GetMapping("/find")
    @ResponseBody
    public ResponseEntity<String> findOne(@RequestParam("id") String id) {
        User retrievedUser = userService.findOneById(id);
        return ResponseEntity.status(HttpStatus.OK).body("this is the body of the find one request " + retrievedUser.toString());
    }
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<String> createUser(@RequestBody User userTemplate ) {
        System.out.println(userTemplate.toString());
        User newUser = userService.save(userTemplate);
        return ResponseEntity.status(HttpStatus.OK).body("This is the return body of the create method" + newUser.toString());
    }
    @PostMapping("/create_new")
    @ResponseBody
    public ResponseEntity<String> createUserEmptyAccount(@RequestBody User newUser) {
        User createdUser = userService.createUserEmptyAccount(newUser);
        return ResponseEntity.status(HttpStatus.OK).body("This is the response of the createUserEmptyAccount method");

    }
}
