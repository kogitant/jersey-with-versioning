package com.ricardoborillo.test.services.rest.v1;

import java.util.ArrayList;
import java.util.List;

import com.ricardoborillo.test.db.UserDTO;

public class UserConverter {
    
    public static User convert(UserDTO userDTO){
        User u = new User();
        u.setId(userDTO.getId());
        u.setName(userDTO.getName());
        // userDTO.getAddress(); // Not supported
        return u;
    }

    public static UserDTO convert(User user){
        UserDTO u = new UserDTO();
        u.setId(user.getId());
        u.setName(user.getName());
        u.setAddress(null); // Nothing to set
        return u;
    }
    
    public static List<User> convert(List<UserDTO> usuarios) {
        List<User> users = new ArrayList<User>();
        for(UserDTO u : usuarios){
            users.add(convert(u));
        }
        return users;
    }
}
