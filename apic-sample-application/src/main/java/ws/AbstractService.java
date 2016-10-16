package ws;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import exceptions.ServiceError;
import exceptions.WebApplicationException;
import util.BaseObject;

public abstract class AbstractService extends BaseObject {

	@Context
	private HttpServletRequest request;

	@AroundInvoke
	public Object aroundInvoke(final InvocationContext context) throws Exception {
		try {
			logRequest(context);
			final Object ret = context.proceed();
			logResponse(context, ret);

			return ret;
		} catch (final WebApplicationException e) {
			logResponse(context, e.error);
			throw e;
		} catch (final Exception e) {
			ServiceError error = ServiceError.UnhandledException(e);
			logError(context, error, e);
			throw new WebApplicationException(error);
		}
	}

	private void logError(final InvocationContext context, ServiceError error, Exception e) {
		if (!LOG.isDebugEnabled()) {
			LOG.error(e.getMessage(), e);
		} else {
			try {
				logResponse(context, error);
			} catch (Exception ex) {
				LOG.error(e.getMessage(), e);
			}
		}
	}

	private void logRequest(final InvocationContext context) {

		if (LOG.isDebugEnabled()) {
			Object body = null;

			if (request.getMethod() == "POST") {
				body = context.getParameters()[context.getParameters().length - 1];
			}

			LOG.debug(String.format( //
					"%s %s -> %s", //
					request.getMethod(), //
					request.getRequestURI(), //
					context.getMethod().getName()), body);
		}
	}

	private void logResponse(final InvocationContext context, final Object result) {
		if (LOG.isDebugEnabled()) {
			LOG.debug(
					String.format( //
							"%s %s <- %s", //
							request.getMethod(), //
							request.getRequestURI(), //
							context.getMethod().getName()), //
					result);
		}
	}

}
