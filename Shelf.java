package bookTest;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bookTest.Gui.HandlerClass;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Shelf{

	private ArrayList<Book> books;
	private int shelfNum;
	private String genre;
	
	public Shelf(){
		books = new ArrayList<Book>();
	}
	
	public Shelf(String g){
		books = new ArrayList<Book>();
		genre = g;
	}
	
	public Shelf(int i){
		books = new ArrayList<Book>(i);
	}
	
	public Shelf(int i, String g){
		books = new ArrayList<Book>(i);
		genre = g;
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
		for(int i=0;i<this.books.size();i++){
			all += this.getTitle(i) + ", " + this.getAuthor(i) + " ID: " + this.getID(i) + "\n";
		}
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("writePath")))) {
		    out.println(all);
		    out.println("Number of books: " + this.books.size());
		}catch (IOException e) {
		    System.err.println(e);
		}
	}
	
	private class HandlerClass implements ActionListener{
		public void actionPerformed(ActionEvent event){
//			JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()));
			
		}
	}

	public String search(String s) {
		String str = "";
		for(int i=0; i<this.books.size(); i++){
			if (this.getTitle(i).toLowerCase().indexOf(s.toLowerCase())>=0 || this.getAuthor(i).toLowerCase().indexOf(s.toLowerCase())>=0)
				str += this.books.get(i) + "\n";
		}
		return str;
	}
	
	public class Gui extends JFrame {

		private JButton reg;
		private JTextField item;
		private JTextField item2;
		
		public Gui(){
		super(); //constructor from JFrame - it's the title
			setLayout(new FlowLayout());
			
			reg = new JButton("Add");
			add(reg);
			
			item = new JTextField("Title"); //10 is the length
			add(item); //adds the item
			
			item2 = new JTextField("Author");
			add(item2);
			
//			custom = new JButton("CustButton");
//			add(custom);
			//to get a picture for button
			//Icon b = new ImageIcon(getClass().getResource("file_name.png"))
			//Icon x = new ImageIcon(getClass().getResource("file_name2.png"))
			//custom = new JButton("Custom", b);
			//to have image on rollover
			//custom.setRolloverIcon(x);
			//add(custom);
			
			HandlerClass handler = new HandlerClass();
			//adds handler for the buttons
			reg.addActionListener(handler);
//			custom.addActionListener(handler);
		}
		
		public class HandlerClass implements ActionListener{
			public void actionPerformed(ActionEvent event){
//				JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()));
				String t = item.getText();
				String a = item2.getText();
				Book b = new Book(t,a);
				System.out.println("added");
				
			}
		}
	}
}
