package timBookStore;

public class Customer {
	private int id;
	private String name;
	private String gender;
	private String birthday;
	private String phone;
	private String address;
	
	public Customer(int ID, String Name, String Gender, String Birthday, String Phone, String Address){
		this.id = ID;
		this.name =Name;
		this.gender = Gender;
		this.birthday = Birthday;
		this.phone = Phone;
		this.address =Address;
				
	}
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	} 
	public String getGender() {
		return gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
}
