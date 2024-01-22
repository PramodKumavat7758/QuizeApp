package com.Pramod.QuizessApp.Service;

import com.Pramod.QuizessApp.DAO.RoleDao;
import com.Pramod.QuizessApp.DAO.UserDao;
import com.Pramod.QuizessApp.Model.Role;
import com.Pramod.QuizessApp.Model.User;
import com.Pramod.QuizessApp.user.WebUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private  UserDao userDao;
    private BCryptPasswordEncoder passwordEncoder;
    private RoleDao roleDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao, BCryptPasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUserName(String theUserName) {
        return userDao.findByUserName(theUserName);
    }

    @Override
    public void save(WebUser webUser) {
        User user = new User();
        user.setUserName(webUser.getUserName());
        user.setPassword(passwordEncoder.encode(webUser.getPassword()));
     //   user.setPassword(passwordEncoder.encode(webUser.getPassword()));
        user.setFirstName(webUser.getFirstName());
        user.setLastName(webUser.getLastName());
        user.setEmail(webUser.getEmail());

        user.setRoles(Arrays.asList(roleDao.findRolebyName("ROLE_EMPLOYEE")));

        userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        Collection<SimpleGrantedAuthority> authorities = mapRolesToAuthorities(user.getRoles());

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(), user.getPassword(),authorities
        );

    }

    private Collection<SimpleGrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role tmpRole : roles){
            SimpleGrantedAuthority tmpAuthority = new SimpleGrantedAuthority(tmpRole.getName());
            authorities.add(tmpAuthority);
        }
        return authorities;
    }
}
