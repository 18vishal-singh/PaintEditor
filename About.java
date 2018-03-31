import javax.swing.*;
import java.awt.Color;
import java.awt.*;
public class About
{
	static final String NEWLINE = System.getProperty("line.separator");
	JTextArea ta;
	About()
	{
		JFrame f = new JFrame("About programmer");
		JPanel jp=new JPanel();
		ta=new JTextArea();
		ta.setText("*****************VISHAL SINGH*****************"+NEWLINE+"This Paint Editor is developed in java."+NEWLINE+"Copyright by VISHAL SINGH.");
		ta.setEditable(false);
		jp.setLayout(new BorderLayout());
		jp.add(ta,BorderLayout.CENTER);
		jp.setBackground(Color.GREEN);
		f.add(jp);
		f.setLocation(200,200);
		f.setSize(500,500);
		f.setResizable(false);
		jp.setBorder(BorderFactory.createEmptyBorder(80,80,80,80));
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
}	