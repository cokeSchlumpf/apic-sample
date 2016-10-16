package ws;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import model.About;

@Stateless
@Path("about")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api("about-service")
public class AboutService extends AbstractService {

	@GET
	public About about() {
		return new About(CONFIG.getString("app.version"), CONFIG.getString("app.name"));
	}

}
