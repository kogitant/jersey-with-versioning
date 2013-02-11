package com.ricardoborillo.test.services.rest.v1;

import javax.xml.bind.annotation.XmlRootElement;

import com.ricardoborillo.test.db.UserDTO;

@XmlRootElement
public class User
{
    private Integer id;
    private String name;

    public User()
    {
    }
    
    public User(UserDTO usuarioDTO)
    {
        this.id = usuarioDTO.getId();
        this.name = usuarioDTO.getName();
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}