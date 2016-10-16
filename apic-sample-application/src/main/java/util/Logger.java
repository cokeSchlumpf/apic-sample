package util;

import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

public class Logger implements org.slf4j.Logger {

	private final org.slf4j.Logger LOG;

	public static final Logger DEFAULT = new Logger("default");

	public Logger(String name) {
		LOG = LoggerFactory.getLogger(name);
	}

	private String prepare(String message, Object... metadata) {
		if (metadata != null) {
			String meta = null;

			for (Object m : metadata) {
				if (m != null) {
					if (meta == null)
						meta = new String();
					meta += "\r\n" + m.toString().replaceAll("(?m)^", "  ");
				}
			}

			if (meta != null) {
				return String.format("%s%s", message, meta);
			} else {
				return message;
			}
		} else {
			return message;
		}
	}

	@Override
	public void debug(String message) {
		LOG.debug(message);
	}

	@Override
	public void debug(String message, Object metadata) {
		LOG.debug(prepare(message, metadata));
	}

	@Override
	public void debug(String message, Object... metadata) {
		LOG.debug(prepare(message, metadata));
	}

	@Override
	public void debug(String message, Throwable t) {
		LOG.debug(message, t);
	}

	@Override
	public void debug(Marker marker, String arg1) {
		LOG.debug(marker, arg1);
	}

	@Override
	public void debug(String message, Object metadata, Object object) {
		LOG.debug(prepare(message, metadata, object));
	}

	@Override
	public void debug(Marker marker, String arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void debug(Marker marker, String arg1, Object... arg2) {
		LOG.debug(marker, arg1, arg2);
	}

	@Override
	public void debug(Marker marker, String arg1, Throwable arg2) {
		LOG.debug(marker, arg1, arg2);
	}

	@Override
	public void debug(Marker marker, String arg1, Object arg2, Object arg3) {
		LOG.debug(marker, arg1, arg2, arg3);
	}

	@Override
	public void error(String message) {
		LOG.error(message);
	}

	@Override
	public void error(String message, Object metadata) {
		LOG.error(prepare(message, metadata));
	}

	@Override
	public void error(String message, Object... metadata) {
		LOG.error(prepare(message, metadata));
	}

	@Override
	public void error(String message, Throwable t) {
		LOG.error(message, t);
	}

	@Override
	public void error(Marker marker, String arg1) {
		LOG.error(marker, arg1);
	}

	@Override
	public void error(String message, Object metadata, Object arg2) {
		LOG.error(prepare(message, metadata, arg2));
	}

	@Override
	public void error(Marker marker, String arg1, Object arg2) {
		LOG.error(marker, arg1, arg2);
	}

	@Override
	public void error(Marker marker, String arg1, Object... arg2) {
		LOG.error(marker, arg1, arg2);
	}

	@Override
	public void error(Marker marker, String arg1, Throwable arg2) {
		LOG.error(marker, arg1, arg2);
	}

	@Override
	public void error(Marker marker, String arg1, Object arg2, Object arg3) {
		LOG.error(marker, arg1, arg2, arg3);
	}

	@Override
	public String getName() {
		return LOG.getName();
	}

	@Override
	public void info(String message) {
		LOG.info(message);
	}

	@Override
	public void info(String message, Object metadata) {
		LOG.info(prepare(message, metadata));
	}

	@Override
	public void info(String message, Object... metadata) {
		LOG.info(prepare(message, metadata));
	}

	@Override
	public void info(String message, Throwable t) {
		LOG.info(message, t);
	}

	@Override
	public void info(Marker marker, String arg1) {
		LOG.info(marker, arg1);
	}

	@Override
	public void info(String message, Object metadata, Object arg2) {
		LOG.info(prepare(message, metadata, arg2));
	}

	@Override
	public void info(Marker marker, String arg1, Object arg2) {
		LOG.info(marker, arg1, arg2);
	}

	@Override
	public void info(Marker marker, String arg1, Object... arg2) {
		LOG.info(marker, arg1, arg2);
	}

	@Override
	public void info(Marker marker, String arg1, Throwable arg2) {
		LOG.info(marker, arg1, arg2);
	}

	@Override
	public void info(Marker marker, String arg1, Object arg2, Object arg3) {
		LOG.info(marker, arg1, arg2, arg3);
	}

	@Override
	public boolean isDebugEnabled() {
		return LOG.isDebugEnabled();
	}

	@Override
	public boolean isDebugEnabled(Marker marker) {
		return LOG.isDebugEnabled(marker);
	}

	@Override
	public boolean isErrorEnabled() {
		return LOG.isErrorEnabled();
	}

	@Override
	public boolean isErrorEnabled(Marker marker) {
		return LOG.isErrorEnabled(marker);
	}

	@Override
	public boolean isInfoEnabled() {
		return LOG.isInfoEnabled();
	}

	@Override
	public boolean isInfoEnabled(Marker marker) {
		return LOG.isInfoEnabled(marker);
	}

	@Override
	public boolean isTraceEnabled() {
		return LOG.isTraceEnabled();
	}

	@Override
	public boolean isTraceEnabled(Marker marker) {
		return LOG.isTraceEnabled(marker);
	}

	@Override
	public boolean isWarnEnabled() {
		return LOG.isWarnEnabled();
	}

	@Override
	public boolean isWarnEnabled(Marker marker) {
		return LOG.isWarnEnabled(marker);
	}

	@Override
	public void trace(String message) {
		LOG.trace(message);
	}

	@Override
	public void trace(String message, Object metadata) {
		LOG.trace(prepare(message, metadata));
	}

	@Override
	public void trace(String message, Object... metadata) {
		LOG.trace(prepare(message, metadata));
	}

	@Override
	public void trace(String message, Throwable t) {
		LOG.trace(message, t);
	}

	@Override
	public void trace(Marker marker, String arg1) {
		LOG.trace(marker, arg1);
	}

	@Override
	public void trace(String message, Object metadata, Object arg2) {
		LOG.trace(prepare(message, metadata, arg2));
	}

	@Override
	public void trace(Marker marker, String arg1, Object arg2) {
		LOG.trace(marker, arg1, arg2);
	}

	@Override
	public void trace(Marker marker, String arg1, Object... arg2) {
		LOG.trace(marker, arg1, arg2);
	}

	@Override
	public void trace(Marker marker, String arg1, Throwable arg2) {
		LOG.trace(marker, arg1, arg2);
	}

	@Override
	public void trace(Marker marker, String arg1, Object arg2, Object arg3) {
		LOG.trace(marker, arg1, arg2, arg3);
	}

	@Override
	public void warn(String message) {
		LOG.warn(message);
	}

	@Override
	public void warn(String message, Object metadata) {
		LOG.warn(prepare(message, metadata));
	}

	@Override
	public void warn(String message, Object... metadata) {
		LOG.warn(prepare(message, metadata));
	}

	@Override
	public void warn(String message, Throwable t) {
		LOG.warn(prepare(message, t));
	}

	@Override
	public void warn(Marker marker, String arg1) {
		LOG.warn(marker, arg1);
	}

	@Override
	public void warn(String message, Object metadata, Object arg2) {
		LOG.warn(prepare(message, metadata, arg2));
	}

	@Override
	public void warn(Marker marker, String arg1, Object arg2) {
		LOG.warn(marker, arg1, arg2);
	}

	@Override
	public void warn(Marker marker, String arg1, Object... arg2) {
		LOG.warn(marker, arg1, arg2);
	}

	@Override
	public void warn(Marker marker, String arg1, Throwable arg2) {
		LOG.warn(marker, arg1, arg2);
	}

	@Override
	public void warn(Marker marker, String arg1, Object arg2, Object arg3) {
		LOG.warn(marker, arg1, arg2, arg3);
	}

}
