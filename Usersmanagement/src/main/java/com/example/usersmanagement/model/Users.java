package com.example.usersmanagement.model;


import javax.validation.constraints.NotEmpty;

public class Users{

    @NotEmpty(message = "id is required !")
    private Integer Id;
    @NotEmpty(message = "Name is required !")
    private String username;
    @NotEmpty(message = "password is required !")
    private String password;
    @NotEmpty(message = "email is required !")
    private String email;
    @NotEmpty(message = "role is required !")
    private String role;
    @NotEmpty(message = "joiningyear is required !")
    private String joiningyear;
    @NotEmpty(message = "age is required !")
    private Integer age;

    public Users(Integer id, String username, String password, String email, String role, String joiningyear,
                 Integer age) {

        Id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.joiningyear = joiningyear;
        this.age = age;
    }
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getJoiningyear() {
        return joiningyear;
    }
    public void setJoiningyear(String joiningyear) {
        this.joiningyear = joiningyear;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }



}