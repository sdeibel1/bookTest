package bookTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Shelf {

	private ArrayList<Book> books;
	private int shelfNum;
	private String genre;
	
	public Shelf(){
		books = new ArrayList<Book>();
	}
	
	public Shelf(int i){
		books = new ArrayList<Book>(i);
	}
	
	public ArrayList<Book> getBooks(){
		return this.books;
	}
	
	public String getGenre(){
		return this.genre;
	}
	
	//returns the title of the book at index i
	public String getTitle(int i){
		return this.books.get(i).getTitleBook();
	}
	//returns the author of the book at index i
	public String getAuthor(int i){
		return this.books.get(i).getAuthorBook();
	}
	
	public int size(){
		return this.books.size();
	}
	
	public void add(Book b){
		this.books.add(b);
	}
	
	public int getID(int i){
		return this.books.get(i).getIDBook();
	}
	
	public void sortTitle(){
		//go through the list of books
		for(int i=0;i<this.books.size();i++){
			int comp = (int) getTitle(i).charAt(0);
//			if(getTitle(i).indexOf("The")==0)
//				comp = (int) getTitle(i).charAt(4);
			//go through a book's title
			
			for(int j=0;j<i;j++){
				// if the first letter is the same, keep going letter by letter 
				// until one is different, then swap if necessary
				if(comp==(int) getTitle(j).charAt(0)){
					for(int k=0;k<Math.min(getTitle(j).length(),getTitle(i).length());k++){
						if(getTitle(i).charAt(k)>getTitle(j).charAt(k)){
							Book temp = this.books.get(i);
							this.books.set(i,this.books.get(j));
							this.books.set(j,temp);
						}
					}
				// if the letter being compared is "less" alphabetically then a
				// letter before it, swap the two
				} else if (comp<(int) getTitle(j).charAt(0)){
					Book temp = this.books.get(i);
					this.books.set(i, this.books.get(j));
					this.books.set(j,temp);
				// else do nothing
				} else {
					//nothing
				}
			}
		}
	}
	
	public void sortAuthor(){
		for(int i=0;i<this.books.size();i++){
			int comp = (int) getAuthor(i).charAt(0);
			for(int j=0;j<i;j++){
				// if the first letter is the same, keep going letter by letter 
				// until one is different, then swap if necessary
				if(comp==(int) getAuthor(j).charAt(0)){
					for(int k=0;k<Math.min(getAuthor(j).length(),getAuthor(i).length());k++){
						if(getAuthor(i).charAt(k)>getAuthor(j).charAt(k)){
							Book temp = this.books.get(i);
							this.books.set(i,this.books.get(j));
							this.books.set(j,temp);
						}
					}
				// if the letter being compared is "less" alphabetically then a
				// letter before it, swap the two
				} else if (comp<(int) getAuthor(j).charAt(0)){
					Book temp = this.books.get(i);
					this.books.set(i, this.books.get(j));
					this.books.set(j,temp);
				// else do nothing
				} else {
					//nothing
				}
			}
		}
	}
	
	public void print(){
		for(int i=0;i<this.books.size();i++){
			System.out.println(this.books.get(i).toString());
		}
	}
	
	public void write(){
		String all = "";
		for(int i=0;i<this.size();i++){
			all += this.getTitle(i) + ", " + this.getAuthor(i) + this.getID(i) + "\n";
		}
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("writePath")))) {
		    out.println(all);
		    out.println("Number of books: " + size());
		}catch (IOException e) {
		    System.err.println(e);
		}
	}
	
	

	public String search(String s) {
		String str = "";
		for(int i=0; i<this.size(); i++){
			if (this.getTitle(i).toLowerCase().indexOf(s.toLowerCase())>=0 || this.getAuthor(i).toLowerCase().indexOf(s.toLowerCase())>=0)
				str += this.books.get(i) + "\n";
		}
		return str;
	}
	
}
