package org.model;

/**
 * Interface entity. @author MyEclipse Persistence Tools
 */

public class Interface implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String input;
	private String output;
	private String description;
	private Long time;
	private Long MId;

	// Constructors

	/** default constructor */
	public Interface() {
	}

	/** minimal constructor */
	public Interface(String name, String output, Long time, Long MId) {
		this.name = name;
		this.output = output;
		this.time = time;
		this.MId = MId;
	}

	/** full constructor */
	public Interface(String name, String input, String output,
			String description, Long time, Long MId) {
		this.name = name;
		this.input = input;
		this.output = output;
		this.description = description;
		this.time = time;
		this.MId = MId;
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

	public String getInput() {
		return this.input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return this.output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getTime() {
		return this.time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Long getMId() {
		return this.MId;
	}

	public void setMId(Long MId) {
		this.MId = MId;
	}

}