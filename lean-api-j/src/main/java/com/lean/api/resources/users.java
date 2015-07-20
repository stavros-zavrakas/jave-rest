package com.lean.api.resources;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// @todo: how to handle parse errors:
// http://stackoverflow.com/questions/14853939/how-to-handle-parser-exceptions-during-unmarshalling-of-json-data

@Path("/users")
public class users {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsers() {
		return "users";
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

		return Response.ok(res).build();
	}
}
