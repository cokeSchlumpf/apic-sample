package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import util.BaseObject;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "application", "version" })
public class About extends BaseObject {

	@XmlElement(name = "application")
	public final String application;

	@XmlElement(name = "version")
	public final String version;

	/**
	 * Constructor for instantiation via JAXB
	 */
	@SuppressWarnings("unused")
	private About() {
		this(null, null);
	}

	public About(String version, String application) {
		this.application = application;
		this.version = version;
	}

}
