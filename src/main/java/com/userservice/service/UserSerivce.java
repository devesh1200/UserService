package com.userservice.service;


import com.userservice.entities.UserInfo;
import com.userservice.entities.UserInfoDto;
import com.userservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@Service
public class UserSerivce {

    @Autowired
    private UserRepository userRepository;

    public UserInfoDto createAndUpdateUser(UserInfoDto userInfoDto) {

        UnaryOperator<UserInfo> updatingUser = user -> { // user is of 1st UserInfo input one
            user.setUserId(userInfoDto.getUserId());
            user.setFirstName(userInfoDto.getFirstName());
            user.setLastName(userInfoDto.getLastName());
            user.setPhoneNumber(userInfoDto.getPhoneNumber());
            user.setEmail(userInfoDto.getEmail());
            user.setProfilePicture(userInfoDto.getProfilePicture());

            return userRepository.save(user);

        };

        Supplier<UserInfo> createUser = () -> {
            return userRepository.save(userInfoDto.transformtoUserInfo());
        };
        UserInfo userInfo = userRepository.findByUserId(userInfoDto.getUserId())
                .map(updatingUser)
                .orElseGet(createUser);

        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePicture()
        );


    }

    public UserInfoDto getUser(UserInfoDto userInfoDto) throws Exception {
        Optional<UserInfo> userInfoDtoOpt = userRepository.findByUserId(userInfoDto.getUserId());
        if (userInfoDtoOpt.isEmpty()) {
            throw new Exception("User not found");
        }
        UserInfo userInfo = userInfoDtoOpt.get();
        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePicture()
        );
    }


}
