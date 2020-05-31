package com.CMRCET.sharebit;

public class User {
protected String username,password,year,mobileno,fullname;

    public User() {

    }

    public  User(String username,String password,String year,String mobileno,String fullname){
        this.fullname=fullname;
        this.username=username;
        this.mobileno=mobileno;
        this.year=year;
        this.password=password;
    }
}
