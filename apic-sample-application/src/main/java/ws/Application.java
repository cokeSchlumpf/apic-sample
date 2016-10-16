package ws;

import java.util.Set;

import javax.ws.rs.ApplicationPath;

import com.google.common.collect.Sets;

@ApplicationPath("api")
public class Application extends javax.ws.rs.core.Application {

	@Override
	public Set<Class<?>> getClasses() {
		return Sets.newHashSet( //
				AboutService.class, //
				CalculationService.class);
	}

}
