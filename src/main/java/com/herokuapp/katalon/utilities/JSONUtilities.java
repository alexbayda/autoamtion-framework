package com.herokuapp.katalon.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.herokuapp.katalon.testdatalayer.dto.UserDto;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONUtilities {

    public final List<UserDto> usersList;


    public JSONUtilities() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CollectionType listType = TypeFactory.defaultInstance().constructCollectionType(List.class, UserDto.class);
            File file = new File("src\\test\\resources\\users.json");
            usersList = objectMapper.readValue(file, listType);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("failed: " + e.getMessage());
        }
    }

    public List<UserDto> getUsersList() {
        return usersList;
    }
}


//create table username - password - used times