package com.mmdbanking.controllers;

import com.mmdbanking.models.Account;
import com.mmdbanking.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("/find")
    @ResponseBody
    public ResponseEntity<String> findOne(@RequestParam("id") String id) {
        System.out.println("this is the incoming request " + " " + id);
        Account retrievedAccount = accountService.findOneById(id);
        return ResponseEntity.status(HttpStatus.OK).body("this is the response from the account controllers /find get mapping" + " " + retrievedAccount.toString());
    }

}
