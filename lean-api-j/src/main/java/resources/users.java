package resources;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class users {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsers() {
		return "users";
	}

	@POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
	public String createUser() {
		return "test";
	}
}
