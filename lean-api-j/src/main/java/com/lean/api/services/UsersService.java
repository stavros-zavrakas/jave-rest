package com.lean.api.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lean.api.database.DatabaseClass;

public class UsersService {

	private Map<Long, Map<String, Object>> users = DatabaseClass.getUsers();

	public UsersService() {
		Map<String, Object> u1 = new HashMap<String, Object>();
		u1.put("id", 1);
		u1.put("firstName", "Stavros");
		u1.put("lastName", "Zavrakas");
		
		Map<String, Object> u2 = new HashMap<String, Object>();
		u2.put("id", 2);
		u2.put("firstName", "Nikos");
		u2.put("lastName", "Zavrakas");
		
		users.put(1L, u1);
		users.put(2L, u2);
	}
	
	public List<Object> getAllUsers() {
		return new ArrayList<Object>(users.values());
	}

	public Object getUser(long id) {
		return users.get(id);
	}

	public Object addUser(Map<String, Object> user) {
		users.put((long) (users.size() + 1), user);
		return user;
	}

	public Object updateUser(Map<String, Object> user) {
		if ((Long) user.get("id") <= 0) {
			return null;
		}

		users.put((Long) (user.get("id")), user);
		return user;
	}

	public Object deleteUser(long id) {
		return users.remove(id);
	
	}
}
