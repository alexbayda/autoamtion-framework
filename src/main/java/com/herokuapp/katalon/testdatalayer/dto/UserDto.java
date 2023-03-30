package com.herokuapp.katalon.testdatalayer.dto;

public class UserDto {

    private String name;
    private String surname;
    private String username;
    private String password;

    private String postalCode;


    public UserDto(){
    }
    public UserDto(String name, String surname, String username, String password, String postalCode){
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public String getUsername() {
        return username;
    }

    public String getPostalCode(){
        return postalCode;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }
}