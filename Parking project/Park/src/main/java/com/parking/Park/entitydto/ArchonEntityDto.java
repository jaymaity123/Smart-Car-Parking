package com.parking.Park.entitydto;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
public class ArchonEntityDto extends UserParkEntityDto {
	@NotEmpty(message = "Archon name cannot be left blank or null")
	@Size(min = 3, max = 20, message = "Invalid Archon Name")
	private String archonName;

	@NotEmpty(message = "Mobile number cannot be left blank or null")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Enter 10 digit mobile number")
	private String mobile;

	

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

	public ArchonEntityDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ArchonEntityDto [archonName=" + archonName + ", mobile=" + mobile + "]";
	}

	
	

}
