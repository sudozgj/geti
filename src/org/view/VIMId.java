package org.view;

/**
 * VIMId entity. @author MyEclipse Persistence Tools
 */

public class VIMId implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String input;
	private String output;
	private String description;
	private String time;
	private Long MId;
	private String mname;
	private String mdescription;

	// Constructors

	/** default constructor */
	public VIMId() {
	}

	/** minimal constructor */
	public VIMId(Long id, String name, String output, Long MId, String mname) {
		this.id = id;
		this.name = name;
		this.output = output;
		this.MId = MId;
		this.mname = mname;
	}

	/** full constructor */
	public VIMId(Long id, String name, String input, String output,
			String description, String time, Long MId, String mname,
			String mdescription) {
		this.id = id;
		this.name = name;
		this.input = input;
		this.output = output;
		this.description = description;
		this.time = time;
		this.MId = MId;
		this.mname = mname;
		this.mdescription = mdescription;
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

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getMId() {
		return this.MId;
	}

	public void setMId(Long MId) {
		this.MId = MId;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMdescription() {
		return this.mdescription;
	}

	public void setMdescription(String mdescription) {
		this.mdescription = mdescription;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VIMId))
			return false;
		VIMId castOther = (VIMId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getInput() == castOther.getInput()) || (this
						.getInput() != null && castOther.getInput() != null && this
						.getInput().equals(castOther.getInput())))
				&& ((this.getOutput() == castOther.getOutput()) || (this
						.getOutput() != null && castOther.getOutput() != null && this
						.getOutput().equals(castOther.getOutput())))
				&& ((this.getDescription() == castOther.getDescription()) || (this
						.getDescription() != null
						&& castOther.getDescription() != null && this
						.getDescription().equals(castOther.getDescription())))
				&& ((this.getTime() == castOther.getTime()) || (this.getTime() != null
						&& castOther.getTime() != null && this.getTime()
						.equals(castOther.getTime())))
				&& ((this.getMId() == castOther.getMId()) || (this.getMId() != null
						&& castOther.getMId() != null && this.getMId().equals(
						castOther.getMId())))
				&& ((this.getMname() == castOther.getMname()) || (this
						.getMname() != null && castOther.getMname() != null && this
						.getMname().equals(castOther.getMname())))
				&& ((this.getMdescription() == castOther.getMdescription()) || (this
						.getMdescription() != null
						&& castOther.getMdescription() != null && this
						.getMdescription().equals(castOther.getMdescription())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getInput() == null ? 0 : this.getInput().hashCode());
		result = 37 * result
				+ (getOutput() == null ? 0 : this.getOutput().hashCode());
		result = 37
				* result
				+ (getDescription() == null ? 0 : this.getDescription()
						.hashCode());
		result = 37 * result
				+ (getTime() == null ? 0 : this.getTime().hashCode());
		result = 37 * result
				+ (getMId() == null ? 0 : this.getMId().hashCode());
		result = 37 * result
				+ (getMname() == null ? 0 : this.getMname().hashCode());
		result = 37
				* result
				+ (getMdescription() == null ? 0 : this.getMdescription()
						.hashCode());
		return result;
	}

}