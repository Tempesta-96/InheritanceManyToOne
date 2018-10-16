import institution.Head_Staff_Manage;;

public class Client {

	public static void main(String[] a) {
		Head_Staff_Manage hs = new Head_Staff_Manage();
		hs.insertStaff(2001, "Sam", "java", "mumbai");
		hs.insertStaff(2002, "Samule", "java", "mumbai");
		hs.insertStaff(2003, "Eric", "java", "pune");
		hs.insertHead(10, "Smith", "mumbai");
		hs.insertHead(20, "Smitha", "pune");
		hs.add_to_centre_head(10, "mumbai");
		hs.add_to_centre_head(20, "pune");
		hs.deleteCHead(20);
		hs.list();
	}
}
