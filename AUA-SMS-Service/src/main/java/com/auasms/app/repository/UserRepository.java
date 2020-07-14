package com.auasms.app.repository;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.auasms.app.models.User;

@Repository
public interface UserRepository {

	@SqlUpdate("INSERT INTO User (name,email,phone,userStatus) VALUES(:name,:email,:phone,:userStatus)")
	public void addUser(@BindBean User user);
	
	@SqlQuery("SELECT * FROM User")
	@RegisterBeanMapper(User.class)
	public List<User> getAllUsers();
	
	@SqlQuery("SELECT * FROM User WHERE userId= :id")
	@RegisterBeanMapper(User.class)
	public User getUserById(@Bind int id);
	
	@SqlQuery("SELECT COUNT(1) FROM User WHERE userId = :id")
	public int userExists(@Bind int id);
	
	@SqlUpdate("UPDATE User SET name = :name,email= :email, phone= :phone,userStatus = :userStatus WHERE userId = :id")
	public void updateUserDetails(@BindBean User user,int id);
	
	@SqlUpdate("DELETE FROM User WHERE userId = :id")
	public boolean deleteUser(@Bind int id);

	@SqlQuery("SELECT * FROM User WHERE email = :email")
	public User userExistsByEmail(@Bind String email);
}
