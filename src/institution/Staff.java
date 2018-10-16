package institution;

import javax.persistence.*;

@Entity
public class Staff {
	private String s_name;
	private int s_code;
	private String specialization;
	private String centre_name;

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCentre_name() {
		return centre_name;
	}

	public void setCentre_name(String centre_name) {
		this.centre_name = centre_name;
	}

	@Id
	public int getS_code() {
		return s_code;
	}

	public void setS_code(int s_code) {
		this.s_code = s_code;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

}
