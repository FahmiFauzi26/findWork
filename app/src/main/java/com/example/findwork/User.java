package com.example.findwork;

public class User {
    public String username;
    public String email;
    public String password;
    public String repassword;

    public User(){

    }
    public User (String username, String email, String password, String repassword){
        this.username = username;
        this.email = email;
        this.password = password;
        this.repassword = repassword;
    }
}
