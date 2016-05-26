package bookTest;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class EventHandler extends JFrame{
	
	private JTextField item;
	private JTextField item2;
	private JTextField item3;
	private JPasswordField passwf;
	
	public EventHandler(){
		super("Title Bar");
		setLayout(new FlowLayout()); //gives the layout
		
		item = new JTextField(10); //10 is the length
		add(item); //adds the item
		
		item2 = new JTextField("Title");
		add(item2);
		
		item3 = new JTextField("Author", 20);
//		item3.setEditable(false); //makes the text uneditable
//		add(item3);
//		
//		passwf = new JPasswordField("password");
//		add(passwf);
		
		theHandler handler = new theHandler();
		item.addActionListener(handler);
		item2.addActionListener(handler);
//		item3.addActionListener(handler);
//		passwf.addActionListener(handler);
//		
	}
	
	public class theHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String s = "";
			
			if(event.getSource()==item)
				s = String.format("field 1: %s", event.getActionCommand());
			else if(event.getSource()==item2)
				s = String.format("field 2: %s", event.getActionCommand());
//			else if(event.getSource()==item3)
//				s = String.format("field 3: %s", event.getActionCommand());
//			else if(event.getSource()==passwf)
//				s = String.format("password field is: %s", event.getActionCommand());
			
			JOptionPane.showMessageDialog(null, s);
		}
		
	}
}
