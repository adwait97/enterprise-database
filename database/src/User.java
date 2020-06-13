
public class User {
	protected String first_name;
	protected String last_name;
	protected String username;
	protected String password;
	protected int age;
	
	public User() {};
	
	public User(String first_name, String last_name, String username, String password, int age) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.age = age;
	}
	
	public void setFirst_Name(String first_name) {
		this.first_name = first_name;
	}
	public void setLast_Name(String last_name) {
		this.last_name = last_name;
	}
	public String getName() {
		return first_name + " " + last_name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
}
