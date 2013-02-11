package com.ricardoborillo.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardoborillo.test.dao.UsersDAO;
import com.ricardoborillo.test.db.UserDTO;

@Service
public class UsersService
{
    @Autowired
    private UsersDAO usuariosDAO;
    
    public List<UserDTO> getUsuarios()
    {
        return usuariosDAO.getUsers();
    }

    public void removeUser(Integer id)
    {
        usuariosDAO.removeUser(id);
    }

    public UserDTO addUser(UserDTO user)
    {
        return usuariosDAO.addUser(user);
    }

    public void updateUser(UserDTO user)
    {
        usuariosDAO.updateUser(user);
    }
    
    public UserDTO find(Integer id){
        return usuariosDAO.find(id);
    }
}
