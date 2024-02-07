package com.mmdbanking.controllers;

//Enable cross origins to recieve request

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
    public ResponseEntity<String> login(@RequestBody LoginFormTemplate lft) {
        System.out.println("IN LOGIN");
        System.out.println(lft.getUsername() + " in java " + lft.getPassword());
        List<User> retrievedUsers = userService.login(lft);

        for(User user : retrievedUsers) {
            System.out.println(user.toString());
        }


        return ResponseEntity.status(HttpStatus.OK).body("This return http status headers and give use a body to use");
    }
    @GetMapping("/find")
    @ResponseBody
    public ResponseEntity<String> findOne(@RequestParam("id") String id) {
        System.out.println("This is the id " + id);
        User retrievedUser = userService.findOneById(id);
        return ResponseEntity.status(HttpStatus.OK).body("this is the body of the find one request " + retrievedUser.toString());
    }
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<String> createUser(@RequestBody User userTemplate ) {
        System.out.println(userTemplate.toString());
        User newUser = userService.save(userTemplate);
        System.out.println("this is back in the user controller allegedly one has been created");
        return ResponseEntity.status(HttpStatus.OK).body("This is the return body of the create method" + newUser.toString());
    }
    @PostMapping("/create_new")
    @ResponseBody
    public ResponseEntity<String> createUserEmptyAccount(@RequestBody User newUser) {
        System.out.println("you are now in the createUserEmptyAccount method");
        User createdUser = userService.createUserEmptyAccount(newUser);
        System.out.println(createdUser.toString());
        return ResponseEntity.status(HttpStatus.OK).body("This is the response of the createUserEmptyAccount method");

    }
}
