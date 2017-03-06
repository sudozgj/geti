package org.model;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Long id;
	private String username;
	private String password;
	private Boolean ack;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String username, String password, Boolean ack) {
		this.username = username;
		this.password = password;
		this.ack = ack;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAck() {
		return this.ack;
	}

	public void setAck(Boolean ack) {
		this.ack = ack;
	}

}