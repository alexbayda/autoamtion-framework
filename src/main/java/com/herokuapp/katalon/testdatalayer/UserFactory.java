package com.herokuapp.katalon.testdatalayer;

import com.herokuapp.katalon.testdatalayer.builder.UserBuilder;
import com.herokuapp.katalon.testdatalayer.dto.UserDto;
import com.herokuapp.katalon.utilities.RandomLoginGenerator;

public class UserFactory {


    public static UserDto getValidUser() {
        return new UserBuilder()
                .setName("Alex")
                .setSurname("Bayda")
                .setUsername("John Doe")
                .setPassword("ThisIsNotAPassword")
                .make();
    }

    public static UserDto getRandomEmailUser() {
        return new UserBuilder()
                .setUsername(RandomLoginGenerator.getEmail())
                .setPassword(RandomLoginGenerator.getPassword())
                .make();
    }
}