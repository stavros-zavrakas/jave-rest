package com.lean.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/banks")
public class Banks {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String test() {
		return "banks";
	}
}
