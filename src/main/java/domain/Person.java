package domain;


public class Person {
	
	public String id, fname, lname, email, contactNo;
	
	public Person() {
		
	}
	
	public Person(String i, String fname, String lname, String email, String contactNo) {
		this.id = i;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contactNo = contactNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	
}
