package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    public UserService userService;

    public void validateSelfOrAdmin(long userId){
        User me = userService.authenticated();
        if(!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)){
            throw new ForbiddenException("Access denied");
        }
    }
}
