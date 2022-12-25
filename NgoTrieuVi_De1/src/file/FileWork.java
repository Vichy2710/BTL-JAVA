package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import mobile.*;

public class FileWork {
	private static String FILE_PATH ="mobiles.bin";
	public void writeMobile(ArrayList<Mobile> mobiles) throws IOException {
		FileOutputStream fos = new FileOutputStream(FILE_PATH);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(mobiles);
		oos.close();
	} 
	public ArrayList<Mobile> readMobiles(){
		ArrayList<Mobile> list = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(FILE_PATH);
			ObjectInputStream ois = new ObjectInputStream(fis);
			list = (ArrayList<Mobile>) ois.readObject();
			ois.close();
		}catch (IOException | ClassNotFoundException e) {
			// TODO: handle exception
		}
		
		return list;
	}

}
