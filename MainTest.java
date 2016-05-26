package bookTest;
import javax.swing.JFrame;
public class MainTest {

	public static void main(String[] args) {
		Book a = new Book("The Hobbit", "Tolkien");
		Book b = new Book("Harry Potter", "Rowling");
		Book c = new Book("Green Eggs and Ham", "Seuss");
		Book d = new Book("The Stranger", "Camus");
		Book e = new Book("The Bath", "Test");
		
		Shelf s = new Shelf(100, "Test");
		s.add(a);
		s.add(b);
		s.add(c);
		s.add(d);
		s.add(e);
		
		Gui go = new Gui();
		go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		go.setSize(400,600);
		go.setVisible(true);
		
//		s.sortTitle();
//		s.print();
//		System.out.println();
//		s.sortAuthor();
		s.print();
		s.write();
		System.out.println();
		
//		System.out.println(s.search("The"));
		
	}

}
