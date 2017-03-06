package org.model;

/**
 * Module entity. @author MyEclipse Persistence Tools
 */

public class Module implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String description;

	// Constructors

	/** default constructor */
	public Module() {
	}

	/** minimal constructor */
	public Module(String name) {
		this.name = name;
	}

	/** full constructor */
	public Module(String name, String description) {
		this.name = name;
		this.description = description;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}