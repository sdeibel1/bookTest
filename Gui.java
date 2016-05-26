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

public class Gui extends JFrame{

	private JButton reg;
	private JTextField item;
	private JTextField item2;
	
	public Gui(){
		super("The title"); //constructor from JFrame - it's the title
		setLayout(new FlowLayout());
		
		reg = new JButton("Add");
		add(reg);
		
		item = new JTextField("Title"); //10 is the length
		add(item); //adds the item
		
		item2 = new JTextField("Author");
		add(item2);
		
//		custom = new JButton("CustButton");
//		add(custom);
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
//		custom.addActionListener(handler);
	}
	
	public class HandlerClass implements ActionListener{
		public void actionPerformed(ActionEvent event){
//			JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()));
			String t = item.getText();
			String a = item2.getText();
			Book b = new Book(t,a);
			Shelf.this.getBooks();
			Shelf.this.
		}
	}
}
