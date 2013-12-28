package assignment2;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import oracle.spatial.*;
import oracle.spatial.geometry.*;
import oracle.spatial.geometry.JGeometry.Point;
import oracle.sql.STRUCT;


import org.apache.commons.lang3.StringUtils;

class LoginPanel extends JPanel{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextField username;
	JPasswordField password;
	JButton login;
	JButton signup;
	private String UserName;

	
	public void disablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].setEnabled(false);
		}
	}

	@SuppressWarnings("deprecation")
	public void enablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].setEnabled(true);
		}
	}

	LoginPanel(){
		this.setBounds(810, 30, 250, 100);
		this.setLayout(new GridLayout(3,2));
		this.add(new Label("UserName: "));
		username = new JTextField();
        this.add(username);
		this.add(new Label("Password: "));
		password = new JPasswordField();
        this.add(password);
        login = new JButton("Login");
        signup = new JButton("Signup");
        this.add(login);
        this.add(signup);
	}
	
	public String getUserName(){
		return UserName;
	}
	public void setUserName(String user){
		UserName=user;
	}
}

class SignupPanel extends JPanel{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JButton login;
	JButton signup;
	JPasswordField password;
	JPasswordField password2;

	JTextField country;
	JTextField state;
	JTextField city;
	JTextField email;
	JTextField birthday;
	JTextField fname;
	JTextField lname;
	JTextField str_no;
	JTextField str_address;
	JTextField zip;

	public void disablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].setEnabled(false);
		}
		disableButton();
	}

	public void enablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].setEnabled(true);
		}
		enableButton();
	}

	SignupPanel(){
		this.setBounds(810, 150, 250, 300);
		this.setLayout(new GridLayout(11,2));
		this.add(new Label("Email: "));
		email = new JTextField();
        this.add(email);
		this.add(new Label("Password: "));
		password = new JPasswordField();
        this.add(password);
		this.add(new Label("ReEnter Password: "));
		password2 = new JPasswordField();
        this.add(password2);
		this.add(new Label("First Name: "));
		fname = new JTextField();
        this.add(fname);
		this.add(new Label("Last Name: "));
		lname = new JTextField();
        this.add(lname);
		this.add(new Label("City: "));
		city = new JTextField();
        this.add(city);
		this.add(new Label("Birthday : "));
		birthday = new JTextField();
        this.add(birthday);
		this.add(new Label("strNo : "));
		str_no = new JTextField();
        this.add(str_no);
		this.add(new Label("strAdress : "));
		str_address = new JTextField();
        this.add(str_address);
        this.add(new Label("Zip : "));
		zip = new JTextField();
        this.add(zip);
        this.add(new Label(""));
        signup = new JButton("signup");
        this.add(signup);
        disablePanel();
	}

	public void disableButton(){
		signup.setEnabled(false);
	}
	public void enableButton(){
		signup.setEnabled(true);
	}
}

class SqlPanel extends JPanel{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextArea SQLArea = null;
	JScrollPane scrollPane = null;
	JLabel showLabel;
	SqlPanel(){
		setInputArea();
	}

	public void disablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].setEnabled(false);
		}
	}

	public void enablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].setEnabled(true);
		}
	}

	private void setInputArea(){
		setBounds(0, 495,810, 150);
		SQLArea = new JTextArea(6,68);
		SQLArea.setLineWrap(true);
		scrollPane = new JScrollPane(SQLArea);
		this.add(scrollPane);
	}
}

class Frame0 extends JFrame{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtfield;
	JButton btn1;
	String lbltext;
	JLabel label;
	String FriendType[] = { "Regular Friend", "Close Friend", "Family" };
	JComboBox combo;

	Frame0(String text,int mode){
		this.lbltext = text;
		 this.setSize(300, 120);
		 this.setResizable(false);
		setLayout(new FlowLayout());
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width-this.getWidth())/2,(height-this.getHeight())/2);
		label = new JLabel(text);
		add(label);
		txtfield = new JTextField(10);
        add(txtfield);
        combo= new JComboBox(FriendType);
        if(mode==1)
        	add(combo);
        btn1 = new JButton("OK");
        add(btn1);

	}
}

class Frame1 extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtfield;
	JButton btn1;
	JButton btn2;
	String lbltext0;
	String lbltext1;
	JLabel lbl0;
	JLabel lbl1;
	JTextArea textArea = null;

	Frame1(String text0, String text1) {
		this.lbltext0 = text0;
		this.lbltext1 = text1;
		this.setResizable(false);
		setLayout(null);
		 this.setSize(300, 256);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width-this.getWidth())/2,(height-this.getHeight())/2);
		lbl0 = new JLabel(text0);
		add(lbl0);
		lbl0.setBounds(10, 10, 70, 30);

		txtfield = new JTextField(10);
		add(txtfield);
		txtfield.setBounds(85, 10, 150, 30);

		lbl1 = new JLabel(text1);
		add(lbl1);
		lbl1.setBounds(10, 45, 70, 30);

		textArea = new JTextArea(8, 10);
		textArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		this.add(scrollPane);
		scrollPane.setBounds(85,55,180,90);

		btn1 = new JButton("OK");
		btn1.setBounds(90,165,90, 30);
		add(btn1);

	}
}


class Frame2 extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtfield;
	JButton btn1;
	JButton btn2;
	String lbltext0;
	JLabel lbl0;

	Frame2(String text0) {
		this.setResizable(false);
		this.lbltext0 = text0;
        this.setSize(300, 150);
        this.setResizable(false);
		setLayout(null);

		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width-this.getWidth())/2,(height-this.getHeight())/2);
		lbl0 = new JLabel(text0);
		add(lbl0);
		lbl0.setBounds(10, 10, 70, 30);

		txtfield = new JTextField(10);
		add(txtfield);
		txtfield.setBounds(85, 10, 100, 30);

		btn1 = new JButton("Decline");
		btn2 = new JButton("Accept ALL");

		btn1.setBounds(190,10,90, 30);
		btn2.setBounds(70,60,150, 30);
		add(btn1);
		add(btn2);

	}
}


class Frame3 extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextField []txtfield;
	JButton btn1;
	JLabel []lbl;
	Frame3(String text0) {
		this.setResizable(false);
		this.setTitle(text0);
        this.setSize(1000, 70);
        this.setResizable(false);
		setLayout(new GridLayout(1,9));

		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width-this.getWidth())/2,(height-this.getHeight())/2);
		lbl = new JLabel[4];
		for(int i=0;i<4;i++)
			lbl[i] = new JLabel();
		lbl[0].setText("topleft x:");
		lbl[1].setText("topleft y:");
		lbl[2].setText("bottomright x:");
		lbl[3].setText("bottomright y:");

		txtfield = new JTextField[4];
		for(int i=0;i<4;i++)
			txtfield[i] = new JTextField();

		btn1 = new JButton("search");
		for(int i=0;i<4;i++)
		{
			add(lbl[i]);
			add(txtfield[i]);
		}
		add(btn1);
	}
}


class PostandSearchPanel extends JPanel{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextArea textArea = null;
	JScrollPane scrollPane = null;

	JTextField text;
	JLabel showLabel;
	JButton []buttons;

	public void disableButton(){
		for(int i=0;i<buttons.length;i++)
			buttons[i].setEnabled(false);
	}

	public void enableButton(){
		for(int i=0;i<buttons.length;i++)
			buttons[i].setEnabled(true);
	}

	PostandSearchPanel(){
		setLayout(null);
		this.setBounds(0, 10,780, 120);
        setInputArea();

		buttons = new JButton[2];
		buttons[0]= new JButton("Post");
		buttons[1]= new JButton("Search For Friend");

		text  = new JTextField(15);
		text.setLocation(10,3);
		text.setText("");
		text.setBounds(460, 40, 150, 25);
		buttons[0].setBounds(380,40,60,25);
		buttons[1].setBounds(620,40,130,25);

		
		this.add(buttons[0]);
		this.add(text);
		this.add(buttons[1]);

	}
	public void disablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].setEnabled(false);
		}
		disableButton();
	}

	public void clearPanel(){
		text.setText("");
	    textArea.setText("");
	}

	public  void enablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].setEnabled(true);
		}
		enableButton();
	}

	public void setInputArea(){
		textArea = new JTextArea(4,30);
		textArea.setLineWrap(true);
		textArea.setBounds(10, 10, 360, 90);
		this.add(textArea);
	}
 }

class ResultPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea resultArea = null;
	JScrollPane scrollPane = null;
	ResultPanel(){
		setResultArea();
	}

	public void setResultArea(){
		resultArea = new JTextArea(10,30);
		resultArea.setLineWrap(true);
		resultArea.setBounds(10, 140,750, 250);

		scrollPane = new JScrollPane(resultArea);
		add(scrollPane);

	}
}

class ButtonPanel extends JPanel{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextArea textArea = null;
	JScrollPane scrollPane = null;
	JLabel showLabel;
	JButton []buttons;

	ButtonPanel(){
	  this.setBounds(10, 415, 770, 40);
	 	buttons = new JButton[8];
		this.setLayout(new GridLayout(2,4));
        for(int i=0;i<8;i++){
        	buttons[i]= new JButton();
        	this.add(buttons[i]);
        }
        buttons[0].setText("Add Friend");
        buttons[1].setText("List all posts");
        buttons[2].setText("List all comments on a post");
        buttons[3].setText("Comment on A post");
        buttons[4].setText("List all events");
        buttons[5].setText("Friend request");   
        buttons[6].setText("Find nearest friend");
        buttons[7].setText("Range query");

	}

	public void disableButton(){
		for(int i=0;i<buttons.length;i++)
			buttons[i].setEnabled(false);
	}

	public void enableButton(){
		for(int i=0;i<buttons.length;i++)
			buttons[i].setEnabled(true);
	}

	public void disablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
				comps[i].setEnabled(false);
		}
		disableButton();
	}

	public void enablePanel(){
		if(this.getComponentCount()==0)
			return ;
		Component[] comps= new Component[this.getComponentCount()];
		comps = this.getComponents();
		for(int i=0;i<comps.length;i++){
			comps[i].setEnabled(true);
		}
		enableButton();
	}
}


class MainFrame extends JFrame{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JLabel LogoLabel;
	JButton notifyButton;
	LoginPanel loginPanel;
	SignupPanel signUpPanel;
	SqlPanel sqlPanel;
	ButtonPanel buttonPanel;
	PostandSearchPanel postandsearch;
	ResultPanel resultPanel;
	Connection conn=null;
	ArrayList<String> requester = new ArrayList<String>();
	ArrayList<String> Relation= new ArrayList<String>();
	int countrequest=0;
	JTextArea resultArea = null;
	JScrollPane scrollPane = null;
	int trigger = 0;
	JLabel showLabel;
	int hasRequest = 0;
	StringBuffer result;
	StringBuffer SQLOut = new StringBuffer ();
	MainFrame(){
		setResizable(false);
		setLayout(null);
		setSize(1100, 700);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((width-1100)/2,(height-700)/2);
		setTitle("This is GUI for database homework");
//		setNotifyLabel();
		SetLogo();
		setLoginPanel();
		setNotifyLabel();
		setSignupPanel();
		setSqlPanel();
		setButtonPanel();
		setPostandSearchPanel();
		setResultPanel();
		postandsearch.disablePanel();
		buttonPanel.disablePanel();
	}

	public void disableResult(){
    	resultArea.setText("");
    	resultArea.setEditable(false);
    	resultArea.setEnabled(false);
    	scrollPane.setEnabled(false);
	}

	public void setResultPanel(){
//       	resultPanel=new ResultPanel();
//       	this.add(resultPanel);
		resultArea = new JTextArea(10,30);
		resultArea.setLineWrap(true);
		scrollPane = new JScrollPane(resultArea);
		add(scrollPane);
		scrollPane.setBounds(10, 140,770, 250);
	}

	public void SetLogo(){
	Image image;
	try {
		image = ImageIO.read(new File("usc_viterbi_logo.jpg"));
		ImageIcon icon = new ImageIcon(image);
		LogoLabel = new JLabel();
		LogoLabel.setIcon(icon);
		LogoLabel.setBounds(830,480,300,150);

		add(LogoLabel);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  //this generates an image file

	}

	public void setNotifyLabel(){
		Image image;
		try {
			image = ImageIO.read(new File("notify.png"));
//			resultPanel=new ResultPanel();
			ImageIcon icon = new ImageIcon(image);
			notifyButton = new JButton();
			notifyButton.setIcon(icon);
			notifyButton.setBounds(750,3,30,30);

			notifyButton.addActionListener(new ActionListener() {
	           
	            @SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
	            	/*Fill this function*/
	            	/*Press this notification button, you should list all the friend request on the ResultPanel*/
	            	/*the output format is like "... wants to add you as 'friend type'." */
	            	if(!requester.isEmpty()){
	            		Iterator<String> i=requester.iterator();
	            		resultArea.setText(" ");
	            		while(i.hasNext())
	            		{
	            			Object req=i.next();
	            			resultArea.append(req+" wants to add you as a "+Relation.get(requester.indexOf(req)));
	            			resultArea.enable();
	            			
	            		}
	            	}
	            	
	            }
	        });

			add(notifyButton);
			notifyButton.setVisible(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //this generates an image file


	}

	public void setButtonPanel(){
		buttonPanel = new ButtonPanel();
		this.add(buttonPanel);

		buttonPanel.buttons[0].addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
            	final Frame0 frame=new Frame0("User Email",1);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);

                frame.btn1.addActionListener(new ActionListener() {
                    
                    public void actionPerformed(ActionEvent e) {
                    	/*Fill this function*/
    	            	/*Press this add friend button, input user Email information, press OK, you should be able to send friend request*/
    	            	/*After press ok, you should also pop up a standard dialog box to show the request send status <succeed or failed>*/
                    	if(frame.txtfield.getText().isEmpty())
                    	{
                    		JOptionPane.showMessageDialog(frame, "Username cannot be null, Please Enter an Username to add ",
            			    "Add Friend error",
            			    JOptionPane.ERROR_MESSAGE);
                    	}
                    	else
                    		if(requester.contains(frame.txtfield.getText()))
                			{
                				JOptionPane.showMessageDialog(frame, "There is already a friend request from this user, please check",
                        			    "Friend Request exists error",
                        			    JOptionPane.ERROR_MESSAGE);
                			}                    	    	
                    	else
                    	{
                    		Connection c;
                    		if((c=ConnectDB.openConnection())!=null)
                    			{
                    			
                    			String sql="Select m.email from members m where m.email='"+frame.txtfield.getText()+"' and email!='"+loginPanel.getUserName()+"'";
                    			String sql1="select user1,user2 from friendship where (user1='"+frame.txtfield.getText()+"' and user2='"+loginPanel.getUserName()+"') "
                    			+"or (user1='"+loginPanel.getUserName()+"' and user2='"+frame.txtfield.getText()+"')";
                        		ResultSet rs,rs2;
                        		int rs1; 
                        		try {
            						Statement stmt=c.createStatement();
            						Statement stmt1=c.createStatement();
            						sqlPanel.SQLArea.setText(" ");
            						sqlPanel.SQLArea.append(sql);
            						rs=stmt.executeQuery(sql);
            						if(rs.next())
            						{
            						sqlPanel.SQLArea.append("\n\n"+sql1);
            						rs2=stmt1.executeQuery(sql1);
            						
            						
            						if(rs.getString(1).equals(frame.txtfield.getText()))
            						{
            							if(rs2.next())
            							{
            								System.out.println(rs2.getString(1)+"  "+rs2.getString(2));
            							if((rs2.getString(1).equals((frame.txtfield.getText()))||rs2.getString(2).equals(frame.txtfield.getText()))&&(rs2.getString(1).equals(loginPanel.getUserName())||rs2.getString(2).equals(loginPanel.getUserName())))
            							{
            								JOptionPane.showMessageDialog(frame,
                    	            			    "User "+frame.txtfield.getText()+" is already your friend",
                    	            			    "Request Status",
                    	            			    JOptionPane.ERROR_MESSAGE);
            							}
            							}
            							else
            							{
            							sql="insert into friend_request values('"+loginPanel.getUserName()+"','"+frame.txtfield.getText()+"','Pending','"+frame.combo.getSelectedItem().toString()+"')";
            							sqlPanel.SQLArea.append("\n\n"+sql);
            							rs1=stmt.executeUpdate(sql);
                						
                						
                						if(rs1!=0)
                						{
                						JOptionPane.showMessageDialog(frame,
                	            			    "Freind request sent",
                	            			    "Request Status",
                	            			    JOptionPane.PLAIN_MESSAGE);
                						frame.dispose();
                						
                						}
                						else
                						{
                							JOptionPane.showMessageDialog(frame,
                    	            			    "Something went wrong, Please Try Again",
                    	            			    "Request Status",
                    	            			    JOptionPane.ERROR_MESSAGE);
                						}
            							}
            						}
            						else
            						{
            							JOptionPane.showMessageDialog(frame,
                	            			    "No such user, Please check the User Name",
                	            			    "Request Status",
                	            			    JOptionPane.ERROR_MESSAGE);
            						}
            						}
            						else
            						{
            							JOptionPane.showMessageDialog(frame,
                	            			    "Please check the User Name",
                	            			    "Request Status",
                	            			    JOptionPane.ERROR_MESSAGE);
            						}
                        		}
                        		catch (SQLException e1) {
            						// TODO Auto-generated catch block
                        			JOptionPane.showMessageDialog(frame,
            	            			    "Request already exists, please wait for the user's response",
            	            			    "Request Status",
            	            			    JOptionPane.ERROR_MESSAGE);
            						e1.printStackTrace();
            					}
                        		finally
                        		{
                        			ConnectDB.closeConnection(c);
//                        			sqlPanel.SQLArea.setText(" ");
                        		}
                        		
                    			}
                    	}
                    	

                    }
                });

            }
        });
		buttonPanel.buttons[1].addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e) {
            	/*Fill this function*/
            	/*Press this list all post button, you should be able to list all the post which are visible to you*/
            	/*You can define the output format*/
            	Connection c;
            	if((c=ConnectDB.openConnection())!=null)
            	{
            		String sql="(select po.post_id,po.sender, po.note FROM "+
                              "MEMBERS m, post PO " + "WHERE m.email='"
							+ loginPanel.getUserName() + "'"
							+ "and m.email= po.sender)" + "union"
							+ "(select po.post_id,po.sender, po.note FROM " + "post po "
							+ "where po.privacy=2)" + "UNION"
							+ "(select po.post_id,po.sender, po.note FROM "
							+ "post po, friendship f " + "where f.user1='"
							+ loginPanel.getUserName() + "'"
							+ "and po.sender= f.user2 and po.privacy=1)"
							+ "UNION" + "(select po.post_id,po.sender, po.note FROM "
							+ "post po, friendship f " + "where f.user2='"
							+ loginPanel.getUserName() + "'"
							+ "and po.sender= f.user1 and po.privacy=1)";
            		ResultSet rs; 
            		try {
						Statement stmt=c.createStatement();
						sqlPanel.SQLArea.setText(" ");
						sqlPanel.SQLArea.append(sql);
						rs=stmt.executeQuery(sql);
//						ArrayList<String> post_sender=new ArrayList<String>();
//						ArrayList<String> post_note=new ArrayList<String>();
						String sender,note,id;
						int i=1;
						resultArea.setText(" ");
						while(rs.next())
						{
//							post_sender.add(rs.getString(1));
//							post_note.add(rs.getString(2));
							id=rs.getString(1);
							sender=rs.getString(2);
							note=rs.getString(3);
							
							resultArea.append(i+">  POST ID : "+id+"   "+"\nSENDER : "+sender+"\nNOTE : "+note+"\n\n\n");
							i++;

						}
//						String header[]={"Sender","Note"};
//                        JTable table=new JTable();	
//                        table.add("Sender", post_sender);
//		                resultArea.add(table);
//		                table.print();
		
            		}catch (SQLException e1) {
						// TODO Auto-generated catch block
            			
						e1.printStackTrace();
					}
            		finally
            		{
            			ConnectDB.closeConnection(c);
//            			sqlPanel.SQLArea.setText("  ");
            		}
            		
            	
            	}

            }
        });

		buttonPanel.buttons[2].addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e) {
            	final Frame0 frame=new Frame0("Post ID: ",2);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
                frame.btn1.addActionListener(new ActionListener() {
                 
                    public void actionPerformed(ActionEvent e) {
                    	/*Fill this function*/
    	            	/*Press this List Comments Button, input Post ID, press OK, you should be able to list all the comment about this post*/
                    	if(frame.txtfield.getText().isEmpty())
                    
                    	{
                    		JOptionPane.showMessageDialog(frame,"Please enter a post ID ","Null ID",JOptionPane.ERROR_MESSAGE);
                    	}
                    	else
                    	{
                    		int id=Integer.parseInt(frame.txtfield.getText());
                    		Connection c;
                    		if((c=ConnectDB.openConnection())!= null)
                    				{
                    			String sql="(select po.post_id,po.sender, po.note FROM "+
                              "MEMBERS m, post PO " + "WHERE m.email='"
							+ loginPanel.getUserName() + "'"
							+ "and m.email= po.sender and po.post_id="+id+" )" + "union"
							+ "(select po.post_id,po.sender, po.note FROM " + "post po "
							+ "where po.privacy=2 and po.post_id="+id+" )" + "UNION"
							+ "(select po.post_id,po.sender, po.note FROM "
							+ "post po, friendship f " + "where f.user1='"
							+ loginPanel.getUserName() + "'"
							+ "and po.sender= f.user2 and po.privacy=1 and po.post_id="+id+" )"
							+ "UNION" + "(select po.post_id,po.sender, po.note FROM "
							+ "post po, friendship f " + "where f.user2='"
							+ loginPanel.getUserName() + "'"
							+ "and po.sender= f.user1 and po.privacy=1 and po.post_id="+id+" )";
                    			
                    			String sql1="select * from post_comment where pid="+id;
                    			ResultSet rs,rs1;
                        	
                        		try {
            						Statement stmt=c.createStatement();
            						Statement stmt1=c.createStatement();
            						sqlPanel.SQLArea.setText(" ");
            						sqlPanel.SQLArea.append(sql);
            						rs=stmt.executeQuery(sql);
            						if(rs.next())
            						{
            							sqlPanel.SQLArea.append("\n\n"+sql1);
            							rs1=stmt1.executeQuery(sql1);
            							resultArea.setText(" ");
            							while(rs1.next())
            								
            							resultArea.append("SENDER :    "+rs1.getString(3)+"     "+rs1.getString(2)+"\n\n");
            						}
            						else
            						{
            							JOptionPane.showMessageDialog(frame,"Either the id doesnt exist or you are not allowed to view it, please re-enter ","Wrong ID",JOptionPane.ERROR_MESSAGE);
            						}
                        		}catch (SQLException e1) {
            						// TODO Auto-generated catch block
                        			
            						e1.printStackTrace();
            					}
                        		finally
                        		{
                        			ConnectDB.closeConnection(c);
//                        			sqlPanel.SQLArea.setText(" ");
                        			                        		}
                        		
                    			
                    				}
                    	}
                    }
                });
            }
        });
		
		buttonPanel.buttons[3].addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
            	final Frame1 frame=new Frame1("Post ID: ","Content: ");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
                frame.btn1.addActionListener(new ActionListener() {
                    
                    public void actionPerformed(ActionEvent e) {
                    	/*Fill this function*/
    	            	/*Press this Comment Button, input Post ID, and comment, press OK, you should be able to comment on this post*/
                    	/*After press ok, you should also pop up a standard dialog box to show the comment's status <succeed or failed>*/
                    	if(frame.txtfield.getText().isEmpty()||frame.textArea.getText().isEmpty())
                    	{
                    		JOptionPane.showMessageDialog(frame,"Post ID and comment cannot be null, please re-enter ","Null Values",JOptionPane.ERROR_MESSAGE);
                    	}
                    	else
                    	{
                    		int id=Integer.parseInt(frame.txtfield.getText());
                    		String comment=frame.textArea.getText();
                    		Connection c;
                    		if((c=ConnectDB.openConnection())!= null)
                    				{
                    			String sql="(select po.post_id,po.sender, po.note FROM "+
                              "MEMBERS m, post PO " + "WHERE m.email='"
							+ loginPanel.getUserName() + "'"
							+ "and m.email= po.sender and po.post_id="+id+" )" + "union"
							+ "(select po.post_id,po.sender, po.note FROM " + "post po "
							+ "where po.privacy=2 and po.post_id="+id+" )" + "UNION"
							+ "(select po.post_id,po.sender, po.note FROM "
							+ "post po, friendship f " + "where f.user1='"
							+ loginPanel.getUserName() + "'"
							+ "and po.sender= f.user2 and po.privacy=1 and po.post_id="+id+" )"
							+ "UNION" + "(select po.post_id,po.sender, po.note FROM "
							+ "post po, friendship f " + "where f.user2='"
							+ loginPanel.getUserName() + "'"
							+ "and po.sender= f.user1 and po.privacy=1 and po.post_id="+id+" )";
                    			
                    			java.sql.Date d=new java.sql.Date(new java.util.Date().getTime());
                    			
                    			String sql1="insert into post_comment values("+id+",'"+comment+"','"+loginPanel.getUserName()+"',"+"to_timestamp('"+d+"','YYYY-MM-DD'))";
                    			ResultSet rs;
                    			int rs1;
                        	
                        		try {
            						Statement stmt=c.createStatement();
            						Statement stmt1=c.createStatement();
            						sqlPanel.SQLArea.setText(" ");
            						sqlPanel.SQLArea.append(sql);
            						rs=stmt.executeQuery(sql);
            						if(rs.next())
            						{
            							sqlPanel.SQLArea.append("\n\n"+sql1);
            							rs1=stmt1.executeUpdate(sql1);
            							if(rs1>0)
            							{
            								JOptionPane.showMessageDialog(frame,"Comment successfully posted ","Comment Success",JOptionPane.PLAIN_MESSAGE);			
            							}
            							      							
            							     
            						}
            						else
            						{
            							JOptionPane.showMessageDialog(frame,"Either the id doesnt exist or you are not allowed to comment on it, please re-enter ","Wrong ID",JOptionPane.ERROR_MESSAGE);
            						}
                        		}catch (SQLException e1) {
            						// TODO Auto-generated catch block
                        			JOptionPane.showMessageDialog(frame,"Something went wrong, please try again later ","Comment Failed",JOptionPane.ERROR_MESSAGE);
            						e1.printStackTrace();
            						
            					}
                        		finally
                        		{
                        			ConnectDB.closeConnection(c);
//                        			sqlPanel.SQLArea.setText(" ");
                        			                        		
                        		}
                    				}
                    
                    	}

                    }
                });
            }
        });
		
		buttonPanel.buttons[4].addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            	/*Fill this function*/
            	/*Press this List all event Button, you should be able to list all available event*/
            	Connection c;
            	ResultSet rs;
            	if((c=ConnectDB.openConnection())!=null)
            	{
            		String sql="select  title, description, starting_time, EXTRACT(DAY FROM event_duration) ||"+
      "' days, ' || EXTRACT (HOUR FROM event_duration) ||"+
      "' hours, ' || EXTRACT (MINUTE FROM event_duration) ||"+
     "' minutes' Duration from event"
            				+" where systimestamp < (starting_time+event_duration) ";
            		try {
						Statement stmt=c.createStatement();
						sqlPanel.SQLArea.setText(" ");
						sqlPanel.SQLArea.append(sql);
						rs=stmt.executeQuery(sql);
						resultArea.setText(" ");
						while(rs.next())
						{
							resultArea.append("TITLE :  "+rs.getString(1)+"  |  START DATE and  TIME :   "+rs.getString(3)+"  |  DURATION :    "+rs.getString(4)+"\n\n");
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            		finally
            		{
            			ConnectDB.closeConnection(c);
//            			sqlPanel.SQLArea.setText(" ");
            		}
            	}
            	
            }
        });


		buttonPanel.buttons[5].addActionListener(new ActionListener() {
           
        public void actionPerformed(ActionEvent e) {
        	final Frame2 frame=new Frame2("Decline: ");
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);

            frame.btn1.addActionListener(new ActionListener() {
               
                public void actionPerformed(ActionEvent e) {
                	/*Fill this function*/
                	/*Press this decline Button, you should be able to decline friend request*/
                	/*You could decline one at a time, or decline many at a time. e.g. using comma to separate each request*/
                	/*pop up a standard dialog box to show <succeed or failed>*/
                	if(frame.txtfield.getText().isEmpty())
                	{
                		JOptionPane.showMessageDialog(frame,
                			    "Please Enter the Userid to decline the requests ",
                			    "Null Error",
                			    JOptionPane.ERROR_MESSAGE);	
                	}
                	else
                	{
                		String strarr[];
                		strarr=frame.txtfield.getText().split(",");
                		for(int i=0;i<strarr.length;i++)
                		{
                			Connection c;
                			if((c=ConnectDB.openConnection())!=null)
                			{
                				String sql="select user2 from friend_request where user2='"+loginPanel.getUserName()+"' and user1='"+strarr[i]+"' and status='Pending'";
                				String sql1="delete from friend_request where user2='"+loginPanel.getUserName()+"' and user1='"+strarr[i]+"'";
                				
                				ResultSet rs;
                				int rs1;
                				try {
									Statement stmt=c.createStatement();
									sqlPanel.SQLArea.setText(" ");
									sqlPanel.SQLArea.append(sql);
									rs=stmt.executeQuery(sql);
									if(rs.next())
									{
										Statement stmt1=c.createStatement();
										sqlPanel.SQLArea.append("\n\n"+sql1);
												rs1=stmt1.executeUpdate(sql1);
												if(rs1==1)
												{
													JOptionPane.showMessageDialog(frame,
							                			    "Reques of "+strarr[i]+" declined","Success",							                			    
							                			    JOptionPane.PLAIN_MESSAGE);
													if(requester.contains(strarr[i]))
															{
														requester.remove(strarr[i]);
														resultArea.setText(" ");
														if(requester.isEmpty())
														{
															notifyButton.setVisible(false);
														}
															}
												}
												else
												{
													JOptionPane.showMessageDialog(frame,
							                			    "Something went Wrong to decline request of "+strarr[i],
							                			    "Failure",
							                			    JOptionPane.ERROR_MESSAGE);
												}
												
									}
									else
									{
										JOptionPane.showMessageDialog(frame,
				                			    "No Request from "+strarr[i],
				                			    "Failure",
				                			    JOptionPane.ERROR_MESSAGE);
									}
									
									
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
                				finally
                				{
                					ConnectDB.closeConnection(c);
                				}
                			}
                		}

                	}
                	
                }
            });


            frame.btn2.addActionListener(new ActionListener() {
           
                public void actionPerformed(ActionEvent e) {
                	/*Fill this function*/
                	/*Press this accept all Button, you should be able to accept all friend request and add this information into friend relationship table*/
                	/*pop up a standard dialog box to show <succeed or failed>*/
                	Connection c;
        			if((c=ConnectDB.openConnection())!=null)
        			{
        				String sql="select * from friend_request where user2='"+loginPanel.getUserName()+"' and status='Pending'";
        				String sql1="update friend_request set status='Friends' where user2='"+loginPanel.getUserName()+"'";
        				ResultSet rs;
        				int rs1,rs2;
        				try {
							Statement stmt=c.createStatement();
							sqlPanel.SQLArea.setText(" ");
							sqlPanel.SQLArea.append(sql);
							rs=stmt.executeQuery(sql);
							if(!rs.next())
							{
								JOptionPane.showMessageDialog(frame,
		                			    "You have no Friend Requests",
		                			    "Failure",
		                			    JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								Statement stmt1=c.createStatement();
								Statement stmt2=c.createStatement();
								do
								{
								String sql2="insert into friendship values('"+rs.getString(1)+"','"+rs.getString(2)+"','"+rs.getString(4)+"')";
								sqlPanel.SQLArea.append("\n\n"+sql2);
								rs2=stmt2.executeUpdate(sql2);
								}while(rs.next());
								if(rs2>=1)
								{
									sqlPanel.SQLArea.append("\n\n"+sql1);
								rs1=stmt1.executeUpdate(sql1);
								if(rs1>=1)
								{
									JOptionPane.showMessageDialog(frame,
			                			    "All requests accepted","Success",							                			    
			                			    JOptionPane.PLAIN_MESSAGE);
									notifyButton.setVisible(false);
								}
								}
								
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        				finally
        				{
        					ConnectDB.closeConnection(c);
        					
        				}
        						
        			}
                }
            });

        }
		});

		buttonPanel.buttons[6].addActionListener(new ActionListener() {
         
            public void actionPerformed(ActionEvent e) {
            	/*Fill this function*/
            	/*Press this Button, you should be able list the information(including address information) about your friend who live nearest to you*/
            	/*This is a spatial query*/
            	Connection c;
            	
            	if((c=ConnectDB.openConnection())!=null)
            	{
//            	  BufferedReader br;
//            		StringBuilder x=new StringBuilder();
//            		StringBuilder y=new StringBuilder();
            		String query = "begin ? := GET_NEAREST_NEIGHBOR(?); end;";
//            	  int aid;
//            	  String sql="select a.aid,a.coordinate.Get_WKT() from address a,members m where m.email='"+loginPanel.getUserName()+"' and m.aid= a.aid";
            	  ResultSet rs;
//            	  Statement stmt,stmt1;
				try {
//					stmt = c.createStatement();
//					stmt1=c.createStatement();
					CallableStatement stmt = c.prepareCall(query);
					stmt.registerOutParameter(1,oracle.jdbc.OracleTypes.CURSOR);
					
					stmt.setString(2,loginPanel.getUserName());
					rs=stmt.executeQuery();stmt.execute();
					sqlPanel.SQLArea.setText(" ");
					sqlPanel.SQLArea.append(query);
					rs = (ResultSet)stmt.getObject(1);
//					rs=stmt.executeQuery(sql);
//					rs.next();
//					
//					aid=rs.getInt(1);
//					coordinate=new BufferedReader(rs.getNCharacterStream("COORDINATE"));
//					Reader r=rs.getClob(2).getCharacterStream();
//					br=new BufferedReader(r);
//					char []buf=new char[20];
//					int b;
//					br.read(buf);
//					String clob=br.toString();
//					for(int i=0;i<buf.length;i++)
//					{
//					if(clob.matches(regex))	
//					}
//					
//					br.close();
//					coordinate.append(new BufferedReader(rs.getClob(2).getCharacterStream()));
//					  String sql1="select m1.email, m1.fname, m1.lname, a1.street_no, a1.street_address, a1.city, a1.state, a1.country from members m1, address a1"+
//	            			   " where m1.aid= a1.aid" + 
//	            			  " and a1.aid  IN(SELECT  b.aid FROM address b  WHERE SDO_NN(b.coordinate,"+coordinate.toString()+
//	            					  ",null,null),  'sdo_num_res=2') = 'TRUE'"+
//	            					  " and b.aid!="+aid+")";
//					  rs1=stmt1.executeQuery(sql1);
					  resultArea.setText(" ");
					  while(rs.next())
					  {
						  resultArea.append(rs.getString(1)+"   "+rs.getString(2)+"    "+rs.getString(3)+"    "+rs.getString(4)+"     "+rs.getString(5)+"      "+rs.getString(6)+"      "+rs.getString(7)+"      "+rs.getString(8)+"\n\n");
					  }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally
				{
					ConnectDB.closeConnection(c);
//					sqlPanel.SQLArea.setText(" ");
				}
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
            	  
            	
            	}
            }
        });
		buttonPanel.buttons[7].addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
            	final Frame3 frame=new Frame3("Please input coordinate: ");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);

                frame.btn1.addActionListener(new ActionListener() {
                  
                    public void actionPerformed(ActionEvent e) {
                    	/*Fill this function*/
                    	/*Press this Button, input left top corner coordinate and right down corner coordinate*/
                    	/*press ok, you should be able list the information(including address information) about your friend who lives in this area. Close query window*/
                    	/*This is a spatial query*/
                    	Connection c;
                    	
                    	if((c=ConnectDB.openConnection())!=null)
                    	{
               Statement statement;
               String query="select a1.coordinate,m1.email, m1.fname, m1.lname, a1.street_no, a1.street_address, a1.city, a1.state, a1.country from members m1, address a1,friendship f where m1.aid=a1.aid and ((m1.email=f.user1 and f.user2='"+loginPanel.getUserName()+"') or(m1.email=f.user2 and f.user1='"+loginPanel.getUserName()+"'))";
               JGeometry.Point p1=new JGeometry.Point();
               p1.set(Integer.parseInt(frame.txtfield[0].getText()),Integer.parseInt(frame.txtfield[1].getText()));
               JGeometry.Point p2=new JGeometry.Point();
               p2.set(Integer.parseInt(frame.txtfield[2].getText()),Integer.parseInt(frame.txtfield[3].getText()));
               
			try {
				statement = c.createStatement();
				sqlPanel.SQLArea.setText(" ");
				sqlPanel.SQLArea.append(query);
				ResultSet rs = statement.executeQuery(query);
				resultArea.setText(" ");
				while(rs.next())
				{
				STRUCT st = (oracle.sql.STRUCT) rs.getObject(1);
                //convert STRUCT into geometry
                JGeometry j_geom = JGeometry.load(st);
                
                Point2D point=j_geom.getJavaPoint();
                
                if(point.getY()<=p1.getY()&&point.getX()<=p2.getX())
                {
                	resultArea.append(rs.getString(1)+"   "+rs.getString(2)+"    "+rs.getString(3)+"    "+rs.getString(4)+"     "+rs.getString(5)+"      "+rs.getString(6)+"      "+rs.getString(7)+"      "+rs.getString(8)+"\n\n");
                }
                
                
                
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finally
			{
				ConnectDB.closeConnection(c);
//				sqlPanel.SQLArea.setText(" ");
			}
               
                    	}

                    	
                    }
                });
            }
        });
		
	}

	public void setPostandSearchPanel(){
		postandsearch = new PostandSearchPanel();
		this.add(postandsearch);
		 
		postandsearch.setName(postandsearch.text.getText());


		postandsearch.buttons[0].addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) { 
            	/*Fill this function*/
            	/*Press this Button, you should be able post the information written in the textArea*/
            	/*pop up a standard dialog box to show <succeed or failed>*/
//            	postandsearch.textArea.getText();
            	resultArea.setText(" ");
            	if(postandsearch.textArea.getText().isEmpty())
            	{

            		JOptionPane.showMessageDialog(postandsearch,
            			    "Post cannot be null, ",
            			    "Post Null Error",
            			    JOptionPane.ERROR_MESSAGE);	
            	}
            	else
            	{
            		String number=JOptionPane.showInputDialog("Enter the privacy level,0-only you, 1-your friends,2-everyone");
            		int privacy=Integer.parseInt(number);
            		            		Connection c;
                	if((c=ConnectDB.openConnection())!=null)
                	{
                		
                		int rs=0; 
                		try {
    						Statement stmt=c.createStatement();
    						
    						
    							System.out.println((int)(Math.round(Math.random()*20)));
//							SimpleDateFormat dateformat = new SimpleDateFormat("DD-MM-YY");
    						//	java.sql.Timestamp timestamp = new java.sql.Timestamp(new java.util.Date().getDate());
    							java.sql.Date d=new java.sql.Date(new java.util.Date().getTime());
    						    
    							String sql="Insert into post Values("+(int)(Math.round(Math.random()*40))+",'"+postandsearch.textArea.getText()+"','"+loginPanel.getUserName()+"',"+privacy+","+"to_timestamp('"+d+"','YYYY-MM-DD'))";
    							sqlPanel.SQLArea.setText(" ");
    							sqlPanel.SQLArea.append(sql);
    						rs=stmt.executeUpdate(sql);
    						
    						if(rs!=0)
    						{
    						JOptionPane.showMessageDialog(postandsearch,
    	            			    "Posted successfully",
    	            			    "Post Status",
    	            			    JOptionPane.PLAIN_MESSAGE);
    						postandsearch.textArea.setText("");
    						}
    						    							
                	       }
                		catch (SQLException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    						JOptionPane.showMessageDialog(postandsearch,
		            			    "Post Failed, Please Try again ",
		            			    "Post Error",
		            			    JOptionPane.ERROR_MESSAGE);
    					}
                		finally
                		{
                			ConnectDB.closeConnection(c);
//                			sqlPanel.SQLArea.setText(" ");
                		}
                		
                	 }
                	
            	}
            	
            	
            	
            }
        });


		postandsearch.buttons[1].addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {  
            	/*Fill this function*/
            	/*Press this Button, you should be able search user information, list the information on the result panel*/
            	/*The search should based on email, first name or last name*/
            	result= new StringBuffer();
//            	resultPanel=new ResultPanel();
            	postandsearch.setName(postandsearch.text.getText());
            	if(postandsearch.getName().isEmpty())
            	{
            		JOptionPane.showMessageDialog(postandsearch,
            			    "search string cannot be null, please specify an username",
            			    "Search String Error",
            			    JOptionPane.ERROR_MESSAGE);	
            	}
            	else
            	{
            	Connection c;
            	if((c=ConnectDB.openConnection())!=null)
            	{
            		String sql="Select email,fname,lname,birthdate,street_address,street_no,city,state,zip,country from members,address where (REGEXP_LIKE(email,'"+postandsearch.getName()+"','i') or REGEXP_LIKE(fname,'"+postandsearch.getName()+"','i') or REGEXP_LIKE(lname,'"+postandsearch.getName()+"','i')) and address.aid=members.aid";
            		ResultSet rs; 
            		try {
						Statement stmt=c.createStatement();
						sqlPanel.SQLArea.setText(" ");
						sqlPanel.SQLArea.append(sql);
						rs=stmt.executeQuery(sql);
						resultArea.setText(" ");
						while(rs.next())
						{
					
							for(int i=1;i<=10;i++)
							{
								
							result.append(rs.getMetaData().getColumnLabel(i)+" : "+rs.getString(i)+"    ");
//						System.out.println(result);
						    }
							result.append("\n\n");
//							resultPanel.resultArea.append(result.toString());
//							resultPanel.setEnabled(true);
						//	resultArea.append("email     fname     lname    birthdate     street_address     street_no     city     state    zip    country"+"\n");
							
						}
						resultArea.append(result.toString()+"\n\n");
            	       }
            		catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            		finally
            		{
            			ConnectDB.closeConnection(c);
//            			sqlPanel.SQLArea.setText(" ");
            		}
            		
            	 }
            	}
            }
            	
        });
	}
	public void setSQLOutput(StringBuffer sb)
	{
		sqlPanel.SQLArea.setText(sb.toString());
		sqlPanel.SQLArea.setEnabled(true);
	}
	public void setSqlPanel(){
		sqlPanel = new SqlPanel();
		this.add(sqlPanel);
		showLabel = new JLabel("The corresponding SQL :");
		showLabel.setBounds(20, 470, 200, 20);
		this.add(showLabel);
	}

	public void setLoginPanel(){
		loginPanel = new LoginPanel();
		this.add(loginPanel);

		loginPanel.signup.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		        signUpPanel.enablePanel();
			}
        });
        loginPanel.login.addActionListener(new ActionListener() {
           
            @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {  
            	/*Fill this function*/
            	/*Press this Button, you should be able match the user information. If valid, keep the user email information(but can't modified) and clear the password*/
            	/*at the same time, you should scan the friend request table, to determine whether current logged in user has friend request, if has, set notification icon*/
            	/*If invalid, you should pop up a dialog box to notify user, then enable signup panel for user to register*/
            	/*After logged in, you should change this button's function as logout which means disable all the panel, return to the original state*/
            	if(loginPanel.login.getText().contentEquals("Logout"))
				{
            		loginPanel.login.setText("Login");
					loginPanel.enablePanel();
					
					disableResult();
					loginPanel.login.setEnabled(true);
					loginPanel.signup.setEnabled(true);
					postandsearch.disablePanel();
					buttonPanel.disablePanel();
					sqlPanel.SQLArea.setText(" ");
					notifyButton.setVisible(false);
					postandsearch.text.setText(" ");
					return;
					
				}
            	if((loginPanel.username.getText().isEmpty())||(loginPanel.password.getText().isEmpty()))
            			{
            		JOptionPane.showMessageDialog(loginPanel,
            			    "Username and Password cannot be null, Please Re-Enter or click signup to register",
            			    "Login error",
            			    JOptionPane.ERROR_MESSAGE);
            		signUpPanel.enablePanel();
            		
            			}
            	else
            	{
            		loginPanel.setUserName(loginPanel.username.getText());
            		
            	Connection c;
            	if((c=ConnectDB.openConnection())!=null)
            	{
//            		System.out.println("/n my \n ame");
            		String sql="Select m.email,m.passwrd from members m";
            		ResultSet rs,rs1; 
            		try {
						Statement stmt=c.createStatement();
						sqlPanel.SQLArea.setText(" ");
						sqlPanel.SQLArea.append(sql);
						rs=stmt.executeQuery(sql);
						
						while(rs.next())
						{
							String un=rs.getString(1);
							String up=rs.getString(2);
							if((un.equalsIgnoreCase(loginPanel.getUserName()))&&up.equals(loginPanel.password.getText()))
							{
								loginPanel.password.setText("");
								signUpPanel.disablePanel();
								loginPanel.disablePanel();
								
								loginPanel.login.setText("Logout");
								loginPanel.login.setEnabled(true);
								loginPanel.signup.setEnabled(false);
								signUpPanel.signup.setEnabled(false);
								sql="Select user1,user2,rtype from friend_request where user2='"+un+"' and status='Pending'";
								sqlPanel.SQLArea.append("\n\n"+sql);
								rs1=stmt.executeQuery(sql);
								
							
								
								while(rs1.next())
								{
									
									requester.add(rs1.getString(1));
									Relation.add(rs1.getString(3));
									countrequest++;
									notifyButton.setVisible(true);
									notifyButton.setEnabled(true);
									
								}
								postandsearch.enablePanel();
								buttonPanel.enablePanel();
								resultPanel.enable();
								resultArea.enable();
								return;
							}
						}
						
						if(rs.isAfterLast())
						{
							loginPanel.password.setText("");
							JOptionPane.showMessageDialog(loginPanel,
		            			    "Username or  Password Entered is Wrong, Please Re-Enter or click sign up to register",
		            			    "Login error",
		            			    JOptionPane.ERROR_MESSAGE);
							
							signUpPanel.enablePanel();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            		finally
            		{
            			
            			ConnectDB.closeConnection(c);
//            			sqlPanel.SQLArea.setText(" ");
            		}
            		
            		
            	}
            	}
            	
            	
            }

           });
   

	}

	public void setSignupPanel(){

		signUpPanel = new SignupPanel();
		this.add(signUpPanel);
		signUpPanel.signup.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {  
            	/*Fill this function*/
            	/*Press this signup button, you should be able check whether current account is existed. If existed, pop up an error, if not check input validation(You can design this part according to your database table's restriction) create the new account information*/
            	/*pop up a standard dialog box to show <succeed or failed>*/
            	if(signUpPanel.email.getText().isEmpty()||signUpPanel.password.getText().isEmpty()||signUpPanel.password2.getText().isEmpty()||signUpPanel.fname.getText().isEmpty()||signUpPanel.lname.getText().isEmpty()||signUpPanel.birthday.getText().isEmpty()||signUpPanel.str_address.getText().isEmpty()||signUpPanel.str_no.getText().isEmpty()||signUpPanel.zip.getText().isEmpty())
            	{
            		JOptionPane.showMessageDialog(signUpPanel,
            			    "All the fields must be enetred, None of then can be null, Please re-enter",
            			    "SignUp error",
            			    JOptionPane.ERROR_MESSAGE);
            	}
            	else
            	{
            		System.out.println(signUpPanel.email.getText().length());
            		System.out.println(signUpPanel.fname.getText().length());
            		System.out.println(signUpPanel.lname.getText().length());
            		System.out.println(signUpPanel.password.getText()+signUpPanel.password2.getText());
            	        if(signUpPanel.email.getText().length()>30||signUpPanel.fname.getText().length()>20||signUpPanel.lname.getText().length()>20||!StringUtils.isNumeric(signUpPanel.password.getText())||!signUpPanel.password.getText().contentEquals(signUpPanel.password2.getText()))
            			{
            		        JOptionPane.showMessageDialog(signUpPanel,
            			    "email could be maximum of 30 chars, Passwords must match and should be only numbers," +
            			    " and First name and last Name cannot be longer than 20 chars, Please Reenter",
            			    "SignUp error",
            			    JOptionPane.ERROR_MESSAGE);
            		
            			}
            	         else
            	        {
            	        int d=0;
            	        	try
            	        	{
            	        		Date d1;
            	        		d1=Date.valueOf(signUpPanel.birthday.getText().toString());
            	        		d=1;
            	        	}
            	        	catch( Exception e1)
            	        	{
            	        		
            	        		d=0;
            	        	}
            	        	if(d==0)
            	        	{
            	        		JOptionPane.showMessageDialog(signUpPanel,
                          			    "birthday has to be entered in yyyy-mm-dd format",
                          			    "SignUp error",
                          			    JOptionPane.ERROR_MESSAGE);
            	        	}
            	        	else
            	        	{
            	        		Connection c;
            	            	if((c=ConnectDB.openConnection())!=null)
            	            	{
            	            		String sql="Select m.email from members m where m.email='"+signUpPanel.email.getText().toString()+"'";
            	            		ResultSet rs,rs1; 
            	            		try {
            							Statement stmt=c.createStatement();
            							sqlPanel.SQLArea.setText(" ");
            							sqlPanel.SQLArea.append(sql);
            							rs=stmt.executeQuery(sql);
            						    if(rs.next())
            						    {
            						    	JOptionPane.showMessageDialog(signUpPanel,
                                      			    "User already exists",
                                      			    "SignUp error",
                                      			    JOptionPane.ERROR_MESSAGE);
            								
            							}
            						    else
            						    {
            						    	try{
            						    	sql="insert into members values('"+signUpPanel.email.getText()+"','"+signUpPanel.fname.getText()+"',"+Integer.parseInt(signUpPanel.password.getText())+",'"+signUpPanel.lname.getText()+"',to_timestamp('"+Date.valueOf(signUpPanel.birthday.getText())+"','YYYY-MM-DD'),1)";
            						    	sqlPanel.SQLArea.append("\n\n"+sql);
            						    	stmt.executeUpdate(sql);
            						    	JOptionPane.showMessageDialog(signUpPanel,
                                      			    "User Added",
                                      			    "SignUp Successful",
                                      			    JOptionPane.PLAIN_MESSAGE);
            						    	signUpPanel.disablePanel();
//            						    	postandsearch.enablePanel();
//            						    	buttonPanel.enablePanel();
            						    	
            						    	}
            						    	catch(SQLException e1)
            						    	{
            						    		JOptionPane.showMessageDialog(signUpPanel,
                                          			    "Something Went Wrong, Please Try again",
                                          			    "SignUp error",
                                          			    JOptionPane.ERROR_MESSAGE);
            						    	}
            						    	finally
            						    	{
            						    		ConnectDB.closeConnection(c);
//            						    		sqlPanel.SQLArea.setText(" ");
            						    	}
            						    }
            	            		}catch (SQLException e1) {
            							// TODO Auto-generated catch block
            							e1.printStackTrace();
            						}
            	            		finally
            	            		{
            	            			ConnectDB.closeConnection(c);
            	            			signUpPanel.disablePanel();
//            	            			sqlPanel.SQLArea.setText(" ");
            	            		}
            	            	}		
            	        	}
            	        }
            }	
            	
            	
            }
        });

		signUpPanel.disablePanel();

	}


}


class ConnectDB{

	public static Connection openConnection(){
       
		/*Fill this function*/
    	/*implement open  connection */
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String name="test2";
		String pass="oracle";
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
//		String url = "jdbc:oracle:oci:@localhost:1521:orcl";
		try {
			Connection con=DriverManager.getConnection(url,name, pass);
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return null;
				
	}
	public static void closeConnection(Connection conn)
	{
		/*Fill this function*/
    	/*implement close connection */
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class Assignment2 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	MainFrame frame = new MainFrame();
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
