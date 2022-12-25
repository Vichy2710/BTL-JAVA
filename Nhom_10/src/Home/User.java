package Home;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String EMAIL = "NO EMAIL";
	public static final String PASSWORD = "NO PASSWORD";
	
	private String email;
	private String password;
	
	
	
	public User() {
		this(User.EMAIL, User.PASSWORD);
	}

	public User(String email, String password) {
		
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]\n";
	}
	
	
}
