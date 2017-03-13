package org.view;

/**
 * VIM entity. @author MyEclipse Persistence Tools
 */

public class VIM implements java.io.Serializable {

	// Fields

	private VIMId id;

	// Constructors

	/** default constructor */
	public VIM() {
	}

	/** full constructor */
	public VIM(VIMId id) {
		this.id = id;
	}

	// Property accessors

	public VIMId getId() {
		return this.id;
	}

	public void setId(VIMId id) {
		this.id = id;
	}

}