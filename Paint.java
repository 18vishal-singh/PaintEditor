import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/*
@author:Vishal Singh
*/
public class Paint extends JFrame implements ActionListener
{
	int fileToOpen;
    	int fileToSave;
    	JFileChooser fileOpen;
    	JFileChooser fileSave;

	
	JFileChooser jfc;
	JFrame frame;
	JButton b[];
	JButton b1[];
	JButton clear;
	JButton colorButton;
	static JTextArea ta;
	JPanel panel = new JPanel();
	JPanel panel1= new JPanel();
////////***************
	JMenuBar menuBar;
	JMenu menu,submenu;
	JMenuItem menuItem1,menuItem2,menuItem3,menuItem4,exit;
//////*****************
	Paint(int c1)
	{
		frame = new JFrame("Paint Editor");
		Container content = frame.getContentPane();						
		content.setLayout(new BorderLayout());
		PadDraw drawPad = new PadDraw();			
		content.add(drawPad, BorderLayout.CENTER);
		ta=new JTextArea();
		content.add(ta,BorderLayout.NORTH);
//////////////////////
		JPopupMenu p=new JPopupMenu("Pop");
		JMenuItem i1=new JMenuItem("new");
		JMenuItem i2=new JMenuItem("open");
		JMenuItem i3=new JMenuItem("save");
		JMenuItem i4=new JMenuItem("exit");
		p.add(i1);
		p.add(i2);
		p.add(i3);
		p.add(i4);
		
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		drawPad.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{	
				int x=e.getButton();
				if(x==MouseEvent.BUTTON3)				//3 stand for right click
					p.show(e.getComponent(),e.getX(),e.getY());
			}
		});
///////////////////////
		setColorMenu();
		
		b[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.green();
				drawPad.eventOutput("*************************green color selected*************************");
			}
		});
		b[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.blue();
				drawPad.eventOutput("*************************blue color selected*************************");
			}
		});
		b[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.magenta();
				drawPad.eventOutput("*************************magenta color selected*************************");
			}
		});
		b[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.black();
				drawPad.eventOutput("*************************black color selected*************************");
			}
		});
		b[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.red();
				drawPad.eventOutput("*************************red color selected*************************");
			}
		});
		b[5].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.gray();
				drawPad.eventOutput("*************************gray color selected*************************");
			}
		});
		b[6].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.pink();
				drawPad.eventOutput("*************************pink color selected*************************");
			}
		});
		b[7].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.yellow();
				drawPad.eventOutput("*************************yellow color selected*************************");
			}
		});
		b[8].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.orange();
				drawPad.eventOutput("*************************orange color selected*************************");
			}
		});
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.clear();
				drawPad.eventOutput("*************************screen cleared*************************");
			}
		});
	
		setButtonMenu();
	
		b1[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.pen();
				drawPad.eventOutput("*************************pen selected*************************");
			}
		});
		b1[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.brush();
				drawPad.eventOutput("*************************brush rectangle selected*************************");
			}
		});
		b1[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.circle();
				drawPad.eventOutput("*************************solid circle selected*************************");
			}
		});
		b1[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.rectangle();
				drawPad.eventOutput("*************************solid rectangle selected*************************");
			}
		});
		b1[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.rubber();
				drawPad.eventOutput("*************************rubber selected*************************");
			}
		});
		colorButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				drawPad.setColor();
				drawPad.eventOutput("*************************adavance color selection*************************");
			}
		});
		
		addItemToPanel();

		content.add(panel, BorderLayout.SOUTH);
		content.add(panel1,BorderLayout.WEST);
			
	}
	Paint()
	{
		this(1);
	
		jfc =new JFileChooser("D:\\java program" );
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(menu);
		menuItem1 = new JMenuItem("new",KeyEvent.VK_T);
	//	menuItem1.addActionListener(this);
	//	menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		menu.add(menuItem1);
		menuItem2 = new JMenuItem("open",KeyEvent.VK_T);
		menuItem2.addActionListener(this);
		menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		menu.add(menuItem2);
		menuItem3= new JMenuItem("save",KeyEvent.VK_T);
		menuItem3.addActionListener(this);
		menuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		menu.add(menuItem3);
		menu.addSeparator();
		exit=new JMenuItem("exit");
		exit.addActionListener(this);
		menu.add(exit);
		menuBar.add(menu);
		menu = new JMenu("About");
		menu.setMnemonic(KeyEvent.VK_N);
		menuBar.add(menu);
		menuItem4 = new JMenuItem("about",KeyEvent.VK_T);
		menuItem4.addActionListener(this);
		menuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menu.add(menuItem4);
		frame.setJMenuBar(menuBar);

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String...s)
	{
		Paint pt=new Paint();
	}
	void setColorMenu()
	{
		panel.setLayout(new GridLayout(2,5,10,10));
		b=new JButton[9];
		String s1[]={"green","blue","magneta","black","red","GRAY","PINK","YELLOW","ORANGE"};
		Color s2[]={Color.green,Color.blue,Color.magenta,Color.black,Color.red,Color.GRAY,Color.PINK,Color.YELLOW,Color.ORANGE};
		for(int i=0;i<b.length;i++)
		{
			b[i]=new JButton(s1[i]);
			b[i].setBackground(s2[i]);
			
		}
		clear=new JButton("clear screen");
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

	}
	void setButtonMenu()
	{
		panel1.setLayout(new GridLayout(3,2,10,10));
		b1=new JButton[5];
		String s1[]={"pen","dotted brush","3D cone","3D rectangle","rubber"};
		for(int i=0;i<b1.length;i++)
		{
			b1[i]=new JButton(s1[i]);
			
		}
		colorButton= new JButton("Advance color");
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	}
	void addItemToPanel()
	{							//*******color panel*******
		panel.add(b[0]);
		panel.add(b[1]);
		panel.add(b[2]);
		panel.add(b[3]);
		panel.add(b[4]);
		panel.add(b[5]);
		panel.add(b[6]);
		panel.add(b[7]);
		panel.add(b[8]);
		panel.add(clear);
								//*********menu panel*******
		panel1.add(b1[0]);
		panel1.add(b1[1]);
		panel1.add(b1[2]);
		panel1.add(b1[3]);
		panel1.add(b1[4]);
		panel1.add(colorButton);
	}
	public void actionPerformed(ActionEvent e)
	{
		int x;
		if(e.getActionCommand().equals("exit"))
			System.exit(0);
		if(e.getActionCommand().equals("about"))
		{
			ta.setText("********************Made by vishal singh (cs engg)********************");
			About a=new About();
		}
		if(e.getActionCommand().equals("open"))
		{
			openFile();
    			if (fileToOpen == JFileChooser.APPROVE_OPTION)
			{
    				ta.setText("");
    				try
				{
    					Scanner scan = new Scanner(new FileReader(fileOpen.getSelectedFile().getPath()));
   	 				while (scan.hasNext())
    					ta.append(scan.nextLine());
    				} 
				catch (Exception ex)
				{
   	 				System.out.println(ex.getMessage());
    				}
			}
		}
		if(e.getActionCommand().equals("save"))
		{
			x=jfc.showSaveDialog(null);
		}
	}
	public void openFile()
	{
    		JFileChooser open = new JFileChooser();
    		int option = open.showOpenDialog(null);
   		fileToOpen = option;
    		fileOpen = open;
    	}
     
    	public void saveFile()
	{
    		JFileChooser save = new JFileChooser();
   		int option = save.showSaveDialog(null);
    		fileToSave = option;
    		fileSave = save;
    }
}


//*******************	CLASS SECOND	***************

class PadDraw extends JComponent
{
	Image image;						
	Graphics2D graphics2D;
	int currentX, currentY, oldX, oldY,o1,o2;					
	int flag;									
	public PadDraw()
	{
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				oldX = e.getX();
				oldY = e.getY();
				o1=oldX;
				o2=oldY;
			}
		});
		addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseMoved(MouseEvent e) 
			{
        			eventOutput("mouse is moving",e);
    			}
		});								
		addMouseMotionListener(new MouseMotionAdapter()
		{	
			public void mouseDragged(MouseEvent e)
			{
				eventOutput("Mouse is dragging ",e);
				currentX = e.getX();
				currentY = e.getY();
				if(graphics2D != null)
				{
					if(flag==0)
					{
						graphics2D.drawLine(oldX, oldY, currentX, currentY);
					}
					if(flag==1)
					{
						graphics2D.fillOval(oldX, oldY,10,10);
					}
					if(flag==2)
					{
						graphics2D.drawOval(o1,o2, Math.abs(currentX-o1),Math.abs(currentY-o2));
					}
					if(flag==3)
					{
						graphics2D.drawRect(o1, o2,Math.abs(currentX-o1),Math.abs(currentY-o2));
					}
					if(flag==4)
					{
						graphics2D.setPaint(Color.white);
						graphics2D.fillOval(oldX, oldY,25,25);
					}	
				}
				repaint();
				oldX = currentX;
				oldY = currentY;
			}
		});																	
	}
					/*		this is the painting bit
							if it has nothing on it then
							it creates an image the size of the window
							sets the value of Graphics as the image
							sets the rendering
							runs the clear() method
							then it draws the image
												*/
	public void paintComponent(Graphics g)
	{
		if(image == null)
		{
			image = createImage(getSize().width, getSize().height);
			graphics2D = (Graphics2D)image.getGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();

		}
		g.drawImage(image, 0, 0, null);
			
	}									
	public void clear(){
		graphics2D.setPaint(Color.white);
		graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		repaint();
	}
	public void red(){
		graphics2D.setPaint(Color.red);
		repaint();
	}									
	public void black(){
		graphics2D.setPaint(Color.black);
		repaint();
	}									
	public void magenta(){
		graphics2D.setPaint(Color.magenta);
		repaint();
	}									
	public void blue(){
		graphics2D.setPaint(Color.blue);
		repaint();
	}									
	public void green(){
		graphics2D.setPaint(Color.green);
		repaint();
	}
	public void gray(){
		graphics2D.setPaint(Color.gray);
		repaint();
	}
	public void pink(){
		graphics2D.setPaint(Color.pink);
		repaint();
	}
	public void yellow(){
		graphics2D.setPaint(Color.yellow);
		repaint();
	}
	public void orange(){
		graphics2D.setPaint(Color.orange);
		repaint();
	}
	public void pen()
	{
		flag=0;
		graphics2D.setPaint(Color.black);
		repaint();
	}
	public void brush(){
			flag=1;
			graphics2D.setPaint(Color.black);
			repaint();
	}
	public void circle()
	{
		flag=2;
		graphics2D.setPaint(Color.black);
		repaint();
	}
	public void rectangle()
	{
		flag=3;
		graphics2D.setPaint(Color.black);
		repaint();
	}
	public void rubber()
	{
		flag=4;
		graphics2D.setPaint(Color.white);
		repaint();
	}
	public void setColor()
	{
		Color bgColor= JColorChooser.showDialog(this,"adavance color selection",Color.RED);
    			if (bgColor != null)
      				graphics2D.setPaint(bgColor);
	}
	void eventOutput(String des,MouseEvent e) 
	{
        	Paint.ta.setText(" (" + e.getX() + "," + e.getY() + ")"+"			"+des);
	}
	void eventOutput(String des) 
	{
        	Paint.ta.setText(des);
	}
	
}
