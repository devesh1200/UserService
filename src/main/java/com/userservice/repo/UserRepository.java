package com.userservice.repo;

import com.userservice.entities.UserInfo;
import com.userservice.entities.UserInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, String> {
    Optional<UserInfo> findByUserId(String userId);


}
