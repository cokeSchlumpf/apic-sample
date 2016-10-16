package exceptions;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import util.BaseObject;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceError extends BaseObject {

	@XmlTransient
	public final int httpStatus;

	@XmlElement(name = "id")
	public final int id;

	@XmlElement(name = "message")
	public final String message;

	@XmlElement(name = "parameter")
	@XmlElementWrapper(name = "parameters")
	public final Map<String, String> parameters;

	private ServiceError(final int httpStatus, final int id, String message,
			final List<Pair<String, String>> parameters) {
		final ImmutableMap.Builder<String, String> mb = new ImmutableMap.Builder<String, String>();

		for (final Pair<String, String> parameter : parameters) {
			final String value = Optional.ofNullable(parameter.getValue()).orElse("n/a");
			message = message.replace("%" + parameter.getKey() + "%", value);
			mb.put(parameter.getKey(), value);
		}

		this.httpStatus = httpStatus;
		this.id = id;
		this.message = message;
		this.parameters = mb.build();
	}

	private ServiceError() {
		this(0, 0, null, null);
	}

	@SuppressWarnings("unchecked")
	public static ServiceError UnhandledException(final Throwable e) {
		return new ServiceError(500, 1, "Server Error: `%message%`.",
				Lists.newArrayList(Pair.of("message", e.getMessage())));
	}

	/**
	 * An example exception which shows how to create an exception with multiple
	 * parameters.
	 * 
	 * @param e
	 *            The original exception.
	 * @param username
	 *            The username used to login.
	 */
	@SuppressWarnings("unchecked")
	public static ServiceError LoginException(final Exception e, String username) {
		return new ServiceError(400, 2, "Unable to login user %username%: `%message%`.",
				Lists.newArrayList( //
						Pair.of("message", e.getMessage()), //
						Pair.of("username", username)));
	}

}
