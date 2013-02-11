package com.ricardoborillo.test.dao;

import java.util.List;

import com.ricardoborillo.test.db.UserDTO;

public interface UsersDAO
{
    List<UserDTO> getUsers();

    void removeUser(Integer id);

    UserDTO addUser(UserDTO user);

    void updateUser(UserDTO user);

    UserDTO find(Integer id);
}