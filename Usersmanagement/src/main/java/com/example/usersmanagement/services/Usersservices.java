package com.example.usersmanagement.services;

import java.util.List;

import com.example.usersmanagement.Repoistory.UsersRepoistory;
import org.springframework.stereotype.Service;


import com.example.usersmanagement.model.Users;

@Service
public class Usersservices {

    private UsersRepoistory usersRepository;

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    public void addUsers(Users users) {
        usersRepository.save(users);
    }

    public Users getUsers(Integer id) {
        return usersRepository.findById(id).get();
    }

    public Users getUsersByName(String name) {
        return usersRepository.findByName(name);
    }
    public Users getUsersByEmail(String email) {
        return usersRepository.findByName(email);
    }
    public List<Users> getUsersByAge(Integer age) {
        return usersRepository.findAllByAgeGreaterThanEqual(age);
    }
    public int getCountUsersByRole(String role) {

        int _count=0;
        for (Users user : usersRepository.findAll()) {

            if(user.getRole().contains(role))
            {
                _count++;
            }
        }
        return _count;
    }
    public boolean CheckValidateuser(String usrname,String password) {
        for (Users user : usersRepository.findAll()) {

            if(user.getUsername().equals(usrname) && user.getPassword().equals(password))
            {
                return true;
            }
        }
        return false;
    }

    public int UpdateUser(Integer UsrId,Users users) {

        Users usx=getUsers(UsrId);
        if(!usx.getRole().equals("admin"))
        {
            return 0;
        }
        for (Users user : usersRepository.findAll()) {

            if(user.getId()==users.getId())
            {
                user.setUsername(users.getUsername());
                user.setPassword(users.getPassword());
                user.setEmail(users.getEmail());
                user.setRole(users.getRole());
                user.setJoiningyear(users.getJoiningyear());
                return 1;
            }
        }
        return -1;
    }
    public int UpdatePwdUser(Integer UsrId,String pssword) {

        for (Users user : usersRepository.findAll()) {

            if(user.getId()==UsrId)
            {
                user.setPassword(pssword);
                return 1;
            }
        }
        return 0;
    }

    public boolean ValidatJoinUser(Integer UsrId,String joinyear) {

        for (Users user : usersRepository.findAll()) {

            if(user.getId()==UsrId
                    && user.getJoiningyear()==joinyear)
            {
                return true;
            }
        }
        return false;
    }


    public List<Users> getUsersByJoiningyear(String Joiningyear) {
        return usersRepository.findAllByJoiningyear(Joiningyear);
    }
    public List<Users> getAllByJoiningyearAndAge(String Joiningyear,int age) {
        return usersRepository.findAllByJoiningyearAndAge(Joiningyear,age);
    }


}