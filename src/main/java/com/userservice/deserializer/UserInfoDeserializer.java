package com.userservice.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userservice.entities.UserInfoDto;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class UserInfoDeserializer implements Deserializer<UserInfoDto> {


    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        //configure
    }

    @Override
    public UserInfoDto deserialize(String arg0, byte[] arg1) {
        ObjectMapper mapper = new ObjectMapper();
        UserInfoDto user = null;
        try {
            user = mapper.readValue(arg1, UserInfoDto.class);

        } catch (Exception e) {
            System.out.println("Error in deserializing bytes " + e);
        }
        return user;
    }

    @Override
    public void close() {
        //close
    }
}
