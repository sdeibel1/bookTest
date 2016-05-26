package bookTest.writeStuff;
import java.io.IOException;
import java.io.*;
public class TextWrite {

	public static void main(String[] args) throws IOException {
		String file_name = "/Users/90299012/Documents/text.txt";
		
		try {
			ReadFile file1 = new ReadFile(file_name);
			String[] arrLines = file1.OpenFile();
			for (int i=0; i<arrLines.length;i++){
				System.out.println(arrLines[i]);
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		WriteFile data = new WriteFile(file_name,false);
		
		data.writeToFile("Sasdfasdfasdfasdf");
		System.out.println("Text has been written to " + file_name);
	}

}
