package com.userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class UserInfoDto {




    private String userId;

    private String firstName;


    private String lastName;


    private Long phoneNumber;


    private String email;


    private String profilePicture;
    public  UserInfo transformtoUserInfo(){
        return  UserInfo.builder().firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .email(email)
                .profilePicture(profilePicture)
                .userId(userId).build();

    }

}

