package com.userdetails.demo.domain.repository;

import com.userdetails.demo.dataaccess.User;
import com.userdetails.demo.dataaccess.UserDao;
import lombok.extern.slf4j.Slf4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class UserRepository {
    public  static final String COULD_NOT_FIND_USER_WITH_ID_EM = "Could not find user with Id %s";

    @Autowired
    UserDao userDao;

    public com.userdetails.demo.domain.entity.User get(String userId) throws  Exception {
        User userDab = userDao.findById(userId).orElse(null);

        if(userDab == null) {
            String errs = String.format(COULD_NOT_FIND_USER_WITH_ID_EM,userId);
            log.warn(errs);
            throw new Exception(errs);
        }
        return com.userdetails.demo.domain.entity.User.builder()
           .userId(userDab.getUserId())
           .firstName(userDab.getFirstName())
           .lastName(userDab.getLastName())
           .lastName(userDab.getGender())
           .gender(userDab.getGender())
           .street(userDab.getStreet())
           .title(userDab.getTitle())
           .city(userDab.getCity())
           .state(userDab.getState())
           .postCode(userDab.getPostcode())
           .build();





    }
}
