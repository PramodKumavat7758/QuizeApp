package com.Pramod.QuizessApp.DAO;

import com.Pramod.QuizessApp.Model.Role;

public interface RoleDao {
    public Role findRolebyName(String theRoleName);
}
