package com.Pramod.QuizessApp.DAO;

import com.Pramod.QuizessApp.Model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
String theUserName;
    @Override
    public User findByUserName(String theUserName) {
        TypedQuery<User> theQuery = entityManager.createQuery("from User where userName=:uName", User.class);
        theQuery.setParameter("uName", theUserName);
        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }
        return theUser;
    }

    @Override
    @Transactional
    public void save(User theUser) {
        entityManager.merge(theUser);
    }

    @Override
    public List<User> findAll() {
       // TypedQuery<User> theQ = entityManager.createQuery("select * from questiondb.user", User.class);
System.out.println("Helllo We are here");
TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class );

        return query.getResultList();

    }

    @Override
    public User findByUserId(int theUserId) {
        TypedQuery<User> query = entityManager.createQuery("from User where id=:uId", User.class);
        query.setParameter("uId", theUserId);
        System.out.println("Finding User by userId: " + theUserId);


        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void deleteById(int theUserId) {
        TypedQuery query = entityManager.createQuery("delete from User where id=:uId", User.class);
        query.setParameter("uId",theUserId);
        query.executeUpdate();

        //DELETE FROM `questiondb`.`user` WHERE (`id` = '9');
    }
}
