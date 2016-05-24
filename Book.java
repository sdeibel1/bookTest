package bookTest;

public class Book {

	private String title;
	private String author;
	private int id;
	private static int idCount;
	private boolean isCheckedOut = false;
	
	public Book(String i, String j){
		title = i;
		author = j;
		id = idCount;
		idCount++;
	}
	
	public String getTitleBook(){
		return this.title;
	}
	
	public void setTitle(String i){
		this.title=title;
	}
	
	public String getAuthorBook(){
		return this.author;
	}
	
	public int numOfBooks(){
		return idCount;
	}
	
	public int getIDBook(){
		return this.id;
	}
	
	public String toString(){
		return this.title + ", " + this.author;
	}
}
