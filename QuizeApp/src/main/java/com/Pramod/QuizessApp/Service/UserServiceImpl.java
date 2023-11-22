package com.Pramod.QuizessApp.Service;

import com.Pramod.QuizessApp.DAO.UserDao;
import com.Pramod.QuizessApp.Model.User;
import com.Pramod.QuizessApp.user.WebUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public void save(WebUser webUser) {
        User user = new User();
        user.setUserName(webUser.getUserName());
        user.setPassword(webUser.getPassword());
        // Set other properties as needed
        userDao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUserName())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}
