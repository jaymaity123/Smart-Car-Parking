package com.parking.Park.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue(value = "2")
public class Archon extends UserPark {

	@ApiModelProperty(name = "ArchonName", value = "Holds the min 3 characters Archon name", required = true)
	@Column
	@NotEmpty(message = "Archon name cannot be left blank or null")
	@Size(min = 3, max = 20, message = "Invalid Archon Name")
	private String archonName;

	@ApiModelProperty(name = "Mobile", value = "Mobile number cannot be null, holds max and min 10 digits")
	@Column
	@NotEmpty(message = "Mobile number cannot be left blank or null")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Enter 10 digit mobile number")
	private String mobile;

	public Archon() {
		super();

	}

	public String getArchonName() {
		return archonName;
	}

	public void setArchonName(String archonName) {
		this.archonName = archonName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Archon(
			@NotEmpty(message = "Archon name cannot be left blank or null") @Size(min = 3, max = 20, message = "Invalid Archon Name") String archonName,
			@NotEmpty(message = "Mobile number cannot be left blank or null") @Pattern(regexp = "(^$|[0-9]{10})", message = "Enter 10 digit mobile number") String mobile) {
		super();
		this.archonName = archonName;
		this.mobile = mobile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((archonName == null) ? 0 : archonName.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Archon other = (Archon) obj;
		if (archonName == null) {
			if (other.archonName != null)
				return false;
		} else if (!archonName.equals(other.archonName))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Archon [archonName=" + archonName + ", mobile=" + mobile + "]";
	}

	

}
