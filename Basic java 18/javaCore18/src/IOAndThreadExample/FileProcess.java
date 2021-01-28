package IOAndThreadExample;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileProcess {
	StringBuilder sb = new StringBuilder();
	String filePath = "/Users/maivanha/Documents/My Projects/"
					+ "JavaBasicClass/Basic java 18/javaCore18/src/textFile.txt";
	File textFile = null;
	
	public void readFileByChar() throws IOException {
		textFile = new File(filePath);
		FileInputStream fis = null;
		try {
			 fis = new FileInputStream(textFile);
			
			int data; 
			char c;
			while ((data = fis.read()) != -1  ) {
				c = (char) data;
				System.out.println(c);
				sb.append(c);
			}
		}catch (IOException  e) {
			throw e;
		}finally {
			fis.close();
		}
	}
	
	public void readFileByLine() throws IOException {
		textFile = new File(filePath);
		try {
			FileReader fr = new FileReader(textFile);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(line != null) {
				System.out.println(line);
				sb.append(line).append("\n");
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	
	public void writeFile() {
		try {
			FileOutputStream fos = new FileOutputStream("output.txt");
			fos.write(this.sb.toString().getBytes());
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		FileProcess fp = new FileProcess();
		try {
			fp.readFileByLine();
			System.out.println(fp.sb.toString());
			
			fp.sb.append("\n").append("Try hard !!!!!");
			
			fp.writeFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
