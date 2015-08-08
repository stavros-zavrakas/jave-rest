package com.lean.api.resources;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lean.api.services.UsersService;

// @todo: how to handle parse errors:
// http://stackoverflow.com/questions/14853939/how-to-handle-parser-exceptions-during-unmarshalling-of-json-data

@Path("/users")
public class Users {

	UsersService usersService = new UsersService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		return Response.ok(usersService.getAllUsers()).build();
	}

	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("userId") int userId) {
		return Response.ok(usersService.getUser(userId)).build();
	}

	// how to consume JSON objects.
	// @see:
	// http://examples.javacodegeeks.com/enterprise-java/rest/jersey/json-example-with-jersey-jackson/
	// https://www.nabisoft.com/tutorials/java-ee/producing-and-consuming-json-or-xml-in-java-rest-services-with-jersey-and-moxy
	// http://stackoverflow.com/questions/4486787/jackson-with-json-unrecognized-field-not-marked-as-ignorable
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(Map<String, Object> bodyMap) {
		String firstName = (String) bodyMap.get("firstName");
		String lastName = (String) bodyMap.get("lastName");

		Map<String, Object> res = new HashMap<String, Object>();
		res.put("firstName", firstName);
		res.put("lastName", lastName);

		return Response.ok(usersService.addUser(res)).build();
	}

	@PUT
	@Path("/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(@PathParam("userId") Long userId, Map<String, Object> bodyMap) {
		bodyMap.put("id", userId);
		
		return Response.ok(usersService.updateUser(bodyMap)).build();
	}

	@DELETE
	@Path("/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("userId") Long userId) {
		usersService.deleteUser(userId);
	}
}
