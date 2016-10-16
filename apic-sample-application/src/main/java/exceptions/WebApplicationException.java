package exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class WebApplicationException extends javax.ws.rs.WebApplicationException {

	/**  */
	private static final long serialVersionUID = 4151916917142174062L;

	public final ServiceError error;

	public WebApplicationException(final Throwable cause, final ServiceError error) {
		super(//
				error.message, //
				cause, //
				Response.status(error.httpStatus).entity(error).type(MediaType.APPLICATION_JSON).build());

		this.error = error;
	}

	public WebApplicationException(final ServiceError error) {
		super(//
				error.message, //
				Response.status(error.httpStatus).entity(error).type(MediaType.APPLICATION_JSON).build());

		this.error = error;
	}

	public ServiceError getError() {
		return error;
	}

}
