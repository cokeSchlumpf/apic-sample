package ws;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class AboutServiceITest extends AbstractServiceTest {

	@Test
	public void create() throws UnirestException {
		HttpResponse<JsonNode> response = Unirest //
				.get(url("/about")) //
				.asJson();

		LOG.debug("Response from /about", response.getBody());

		assertEquals(CONFIG.getString("app.version"), response.getBody().getObject().getString("version"));
	}

}
