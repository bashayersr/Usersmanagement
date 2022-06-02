package com.example.usersmanagement.Controller;


import java.util.List;

import javax.validation.Valid;

import com.example.usersmanagement.model.Users;
import com.example.usersmanagement.services.Usersservices;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/Users")
public class UsersController {

    private  Usersservices usersService;

    @GetMapping
    public ResponseEntity<List<Users>> getUserss(){
        return ResponseEntity.status(200).body(usersService.getUsers());
    }

    @PostMapping
    public ResponseEntity<?> addUsers(@RequestBody @Valid Users users, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(200).body(errors.getFieldError().getDefaultMessage());
        }
        usersService.addUsers(users);
        return ResponseEntity.status(200).body("Users added !");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUsers(@PathVariable Integer id){

        return ResponseEntity.status(200).body(usersService.getUsers(id));
    }

    @GetMapping("/email")
    public ResponseEntity<Users> getUsersByEmail(@RequestParam String email){
        return ResponseEntity.status(200).body(usersService.getUsersByName(email));
    }


    @GetMapping("/age")
    public ResponseEntity<List<Users>> getUsersByAge(@RequestParam Integer age){
        return ResponseEntity.status(200).body(usersService.getUsersByAge(age));
    }


    @GetMapping("/role")
    public ResponseEntity<String> getUsersByAge(@RequestParam String role){
        return ResponseEntity.status(200).body("total Count as Role : "+usersService.getCountUsersByRole(role));
    }


    @GetMapping("/usr_validate")
    public ResponseEntity<String> CheckValidateuser(@RequestParam String username,@RequestParam String password){

        boolean valis=usersService.CheckValidateuser(username,password);
        if(valis)
            return ResponseEntity.status(200).body("username and password is correct : ");
        else
            return ResponseEntity.status(200).body("username and password is Error : ");
    }

    @GetMapping("/usr_update")
    public ResponseEntity<String> UpdateUser(@RequestParam int usrid,@RequestParam Users users){

        int valis=usersService.UpdateUser(usrid,users);
        if(valis==1)
            return ResponseEntity.status(200).body("Update Users : ");
        else if(valis==0)
            return ResponseEntity.status(200).body("Users Not Admin : ");
        else
            return ResponseEntity.status(200).body("Users Not Found : ");
    }
    @GetMapping("/usr_pwdupdate")
    public ResponseEntity<String> UpdatePwdUser(@RequestParam int usrid,@RequestParam String password){

        int valis=usersService.UpdatePwdUser(usrid,password);
        if(valis==1)
            return ResponseEntity.status(200).body("Update Passord Users : ");
        else
            return ResponseEntity.status(200).body("Users Not Found : ");
    }
    @GetMapping("/usr_validate_joined")
    public ResponseEntity<String> ValidatJoinUser(@RequestParam int usrid,@RequestParam String joinyear){

        boolean valis=usersService.ValidatJoinUser(usrid,joinyear);
        if(valis)
            return ResponseEntity.status(200).body("this user  joined data  ");
        else
            return ResponseEntity.status(200).body("this user not joined data  ");
    }
    //


    @GetMapping("/usr_joiningyear")
    public ResponseEntity<List<Users>> getUsersByJoiningyear(@RequestParam String joiningyear){
        return ResponseEntity.status(200).body(usersService.getUsersByJoiningyear(joiningyear));
    }

    @GetMapping("/usr_joiningyear_age")
    public ResponseEntity<List<Users>> getAllByJoiningyearAndAge(@RequestParam String joiningyear,int age){
        return ResponseEntity.status(200).body(usersService.getAllByJoiningyearAndAge(joiningyear,age));
    }

}
