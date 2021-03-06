package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.dao.abstracts.RoleDao;
import com.amr.project.dao.abstracts.UserDao;
import com.amr.project.model.entity.Role;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl extends ReadWriteServiceImpl<User, Long> implements UserService {
    private UserDao userDao;
    private RoleDao roleDao;

    protected UserServiceImpl(ReadWriteDao<User, Long> readWriteDao, UserDao userDao, RoleDao roleDao) {
        super(readWriteDao);
        this.userDao = userDao;
        this.roleDao = roleDao;
    }


    @Override
    public void registerNewUser(User user) {
        Set<Role> role = new HashSet<>();
        role.add(roleDao.getRoleById(1L));
        user.setRoles(role);
        user.setActivate(true);
        userDao.persist(user);
    }

    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }
}
