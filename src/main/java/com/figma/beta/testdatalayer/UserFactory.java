package com.figma.beta.testdatalayer;

import com.figma.beta.testdatalayer.builder.UserBuilder;
import com.figma.beta.testdatalayer.dto.UserDto;
import com.figma.beta.utilities.RandomGenerator;

public class UserFactory {


    public static UserDto getValidUser() {
        return new UserBuilder()
                .setName("Alex")
                .setSurname("Bayda")
                .setEmail("alex.bayda@yahoo.ca")
                .setPassword("1q2w3e4r")
                .make();
    }

    public static UserDto getRandomEmailUser() {
        return new UserBuilder()
                .setEmail(RandomGenerator.getEmail())
                .setPassword(RandomGenerator.getPassword())
                .make();
    }
}


//    @Getter
//    @Setter
//    private String name;
//    private String lastName;
//    private String email;
//    private String password;
//    }

//    public static final String DEFAULT_LOGIN = "alex.bayda@yahoo.ca";
//    public static final String DEFAULT_PASSWORD = "1q2w3e4r";
//
//    private String firstName;
//    private String lastName;
//
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//}

//add Propertiaor (exclude 2 method, only property reader)
//add ScreenshotUtils (after fail take screenshot)
//add StringGenerator