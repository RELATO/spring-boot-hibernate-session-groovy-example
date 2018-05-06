package com.devglan.dao;

import java.util.List;

import com.devglan.model.UserDetails;

public interface UserDao {

	List<UserDetails> getUserDetails();

	public Integer add(UserDetails userDetails);

	public void delete(String id);
}
