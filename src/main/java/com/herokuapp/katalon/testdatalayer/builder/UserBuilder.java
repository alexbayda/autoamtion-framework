package com.herokuapp.katalon.testdatalayer.builder;

import com.herokuapp.katalon.testdatalayer.dto.UserDto;

public class UserBuilder {

    public UserDto user = new UserDto();

    public UserDto make() {
        return new UserDto();//create copy Constructor
    }

    public UserBuilder setName(String name) {
        user.setName(name);
        return this;
    }

    public UserBuilder setSurname(String surname) {
        user.setSurname(surname);
        return this;
    }

    public UserBuilder setPassword(String password) {
        user.setPassword(password);
        return this;
    }

    public UserBuilder setUsername(String email) {
        user.setUsername(email);
        return this;
    }
}

