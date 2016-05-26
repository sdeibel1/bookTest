package bookTest.writeStuff;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class WriteFile {
	private String path;
	private boolean append_to_field = false;
	
	public WriteFile(String file_path){
		path = file_path;
	}
	
	public WriteFile(String file_path, boolean append_value){
		path = file_path;
		append_to_field = append_value;
	}
	
	public void writeToFile(String text) throws IOException {
		FileWriter write = new FileWriter (path, false);
		PrintWriter print_line = new PrintWriter(write);
		
		print_line.printf("%s + %n", text);
		print_line.close();
	}
}
