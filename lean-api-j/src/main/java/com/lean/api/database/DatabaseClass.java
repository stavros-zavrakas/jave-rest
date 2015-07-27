package com.lean.api.database;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {

	private static Map<Long, Map<String, Object>> users = new HashMap<Long, Map<String, Object>>();

	public static Map<Long, Map<String, Object>> getUsers() {
		return users;
	}
}
