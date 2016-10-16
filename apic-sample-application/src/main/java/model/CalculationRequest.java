package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "n1", "n2" })
public class CalculationRequest {

	@XmlElement(name = "n1", required = true)
	public final int n1;

	@XmlElement(name = "n2", required = false)
	public final int n2;

	/**
	 * Constructor for instantiation via JAXB
	 */
	@SuppressWarnings("unused")
	private CalculationRequest() {
		this(0, 0);
	}

	public CalculationRequest(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}

}
