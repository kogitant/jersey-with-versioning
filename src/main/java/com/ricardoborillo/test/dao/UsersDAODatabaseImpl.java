package com.ricardoborillo.test.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAUpdateClause;
import com.ricardoborillo.test.db.QUserDTO;
import com.ricardoborillo.test.db.UserDTO;

@Repository
public class UsersDAODatabaseImpl implements UsersDAO
{
    @PersistenceContext
    private EntityManager entityManager;

    private QUserDTO qUserDTO = QUserDTO.userDTO;

    @Override
    public List<UserDTO> getUsers()
    {
        JPAQuery query = new JPAQuery(entityManager);
        return query.from(qUserDTO).list(qUserDTO);
    }
    
    @Override
    @Transactional
    public UserDTO find(Integer id)
    {
        JPAQuery query = new JPAQuery(entityManager);
        return query.from(qUserDTO).where(qUserDTO.id.eq(id)).list(qUserDTO).get(0);
    }
    
    @Override
    @Transactional
    public void removeUser(Integer id)
    {
        JPADeleteClause delete = new JPADeleteClause(entityManager, qUserDTO);
        delete.where(qUserDTO.id.eq(id)).execute();
    }

    @Override
    @Transactional
    public UserDTO addUser(UserDTO userDTO)
    {
        entityManager.persist(userDTO);
        return userDTO;
    }

    @Override
    @Transactional
    public void updateUser(UserDTO user)
    {
        JPAUpdateClause update = new JPAUpdateClause(entityManager, qUserDTO);
        update.set(qUserDTO.name, user.getName()).where(qUserDTO.id.eq(user.getId())).execute();
    }
}
