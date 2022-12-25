package Home;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ListUsers {
	private static List<User> list = new ArrayList<>();
	
	public static void init() {
		list.add(new User("phamduc2002", "phamduc2002"));
		list.add(new User("ngovi2002", "ngovi2002"));
		list.add(new User("tranlinh2002", "tranlinh2002"));
		list.add(new User("nguyenxuan2002","nguyenxuan2002"));
	}
	
	public static void usersOutputFile() throws IOException{
		File file = new File("account.bin");
		
		FileOutputStream outFile = new FileOutputStream(file);
		ObjectOutputStream out = new ObjectOutputStream(outFile);

		for (User user : list) {
			out.writeObject(user);
		}
		out.close();
		
	}
	
	public static List<User> usersInputFile() throws IOException, ClassNotFoundException {
		FileInputStream inputFile = new FileInputStream("account.bin");
		ObjectInputStream in = new ObjectInputStream(inputFile);

		List<User> tmp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			tmp.add((User)in.readObject());
		}		
		in.close();
		return tmp;

	}
	
	public static User checkUser(String email, String pass) {
		for (User user : list) {
			if(email.trim().equals(user.getEmail()) 
					&& pass.trim().equals(user.getPassword()))
				return user;	
		}
		return null;
	}
}
