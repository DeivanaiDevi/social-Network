package com.BackEnd.DAO;

import org.springframework.stereotype.Service;

//import java.util.List;

import com.BackEnd.Model.UserDetail;

@Service
public interface UserDAO {

     public boolean addUser(UserDetail user);
     public boolean updateOnlineStatus(String status,UserDetail user);
	 //boolean saveUser(User user);
}