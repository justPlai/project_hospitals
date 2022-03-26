package soa.model;
// Generated Mar 26, 2022, 9:28:10 PM by Hibernate Tools 5.5.7.Final

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Doctor generated by hbm2java
 */
public class Doctor implements java.io.Serializable {

	private Integer doctorId;
	private Hospital hospital;
	private String doctorFirstname;
	private String doctorLastname;
	private String doctorPhonenumber;

	@JsonIgnore
	private Set medicinedetails = new HashSet(0);

	public Doctor() {
	}

	public Doctor(Hospital hospital, String doctorFirstname, String doctorLastname) {
		this.hospital = hospital;
		this.doctorFirstname = doctorFirstname;
		this.doctorLastname = doctorLastname;
	}

	public Doctor(Hospital hospital, String doctorFirstname, String doctorLastname, String doctorPhonenumber,
			Set medicinedetails) {
		this.hospital = hospital;
		this.doctorFirstname = doctorFirstname;
		this.doctorLastname = doctorLastname;
		this.doctorPhonenumber = doctorPhonenumber;
		this.medicinedetails = medicinedetails;
	}

	public Integer getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public String getDoctorFirstname() {
		return this.doctorFirstname;
	}

	public void setDoctorFirstname(String doctorFirstname) {
		this.doctorFirstname = doctorFirstname;
	}

	public String getDoctorLastname() {
		return this.doctorLastname;
	}

	public void setDoctorLastname(String doctorLastname) {
		this.doctorLastname = doctorLastname;
	}

	public String getDoctorPhonenumber() {
		return this.doctorPhonenumber;
	}

	public void setDoctorPhonenumber(String doctorPhonenumber) {
		this.doctorPhonenumber = doctorPhonenumber;
	}

	public Set getMedicinedetails() {
		return this.medicinedetails;
	}

	public void setMedicinedetails(Set medicinedetails) {
		this.medicinedetails = medicinedetails;
	}

}
