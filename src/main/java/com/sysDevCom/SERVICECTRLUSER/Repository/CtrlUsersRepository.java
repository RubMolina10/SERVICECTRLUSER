package com.sysDevCom.SERVICECTRLUSER.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sysDevCom.SERVICECTRLUSER.Model.CtrlUsers;
public interface CtrlUsersRepository extends MongoRepository<CtrlUsers, String> {
    Optional<CtrlUsers> findByUserName(String userName);
    Optional<CtrlUsers> findByUserNameAndClvPass(String userName, String clvPass);
}