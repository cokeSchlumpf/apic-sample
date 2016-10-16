package ws;

import org.junit.Before;

import com.mashape.unirest.http.Unirest;

import util.BaseObject;

public abstract class AbstractServiceTest extends BaseObject {

	@Before
	public void setup() {
		Unirest.setDefaultHeader("Content-Type", "application/json");
		Unirest.setDefaultHeader("Accept", "application/json");
	}

	protected String url(String uri) {
		return "http://localhost:7080/" + CONFIG.getString("app.name") + "/api" + uri;
	}

}
