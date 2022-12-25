package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;

public class Stream {

	static void copy(InputStream in, OutputStream out) throws IOException {
		int c;
		while((c = in.read())!= -1) 
			out.write(c);
	}
	
	static void copy(Reader in, Writer out) throws IOException {
		int c;
		while((c = in.read())!= -1) 
			out.write(c);
	}
	public static void main(String[] args) {
		try {
			FileReader in1 = new FileReader("file0.txt");
			FileWriter out1 = new  FileWriter("file1.txt");
			Stream.copy(in1, out1);
			in1.close(); out1.close();
			
			String msg = "Java rules a lot!";
			StringReader in2 = new StringReader(msg);
			FileWriter out2= new FileWriter("file2.txt");
			Stream.copy(in2, out2);
			in2.close(); out2.close();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
