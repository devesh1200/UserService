package com.userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {



    @Id
    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("first_name")
    @NotNull
    private String firstName;

    @JsonProperty("last_name")
    @NotNull
    private String lastName;

    @JsonProperty("phone_Number")
    @NotNull
    private Long phoneNumber;

    @JsonProperty("email")
    @NotNull
    private String email;

    @JsonProperty("profilepicture")
    private String profilePicture;




}



