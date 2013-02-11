package com.ricardoborillo.test.services.rest.v2;

import javax.xml.bind.annotation.XmlRootElement;

import com.ricardoborillo.test.db.UserDTO;

@XmlRootElement
public class User
{
    private Integer id;
    private String name;
    private String address;

    public User()
    {
    }
    
    public User(UserDTO usuarioDTO)
    {
        this.id = usuarioDTO.getId();
        this.name = usuarioDTO.getName();
        this.address = usuarioDTO.getAddress();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}