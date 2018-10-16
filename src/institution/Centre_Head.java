package institution;

import java.util.*;
import javax.persistence.*;

@Entity
public class Centre_Head {
	private String c_name;
	private int c_code;
	private String centre_name;
	private Set<Staff> staff = new HashSet<Staff>();

	public Centre_Head() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	public int getC_code() {
		return c_code;
	}

	public void setC_code(int c_code) {
		this.c_code = c_code;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getCentre_name() {
		return centre_name;
	}

	public void setCentre_name(String centre_name) {
		this.centre_name = centre_name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "c_code")
	public Set<Staff> getStaff() {
		return staff;
	}

	public void setStaff(Set<Staff> staff) {
		this.staff = staff;
	};

}
