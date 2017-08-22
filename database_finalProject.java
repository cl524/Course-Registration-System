import java.awt.BorderLayout;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.awt.CardLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

//import project.connection;

import javax.lang.*;
import java.awt.GridLayout;
import sun.misc.FloatingDecimal.*;

class connect1
{
	public Statement stmt;
	public Connection conn;    
	
	connect1(){
		String url = "jdbc:mysql://localhost:3307/mydn";
		String ucid = "root";	//your ucid
		String dbpassword = "ichiro51";	//your MySQL password		
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch (Exception e) {
			System.err.println("Unable to load driver.");
			e.printStackTrace();
		}
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/mydn","root","ichiro51");
			
			stmt=conn.createStatement();
			stmt.executeUpdate("DROP TABLE IF EXISTS regi");
			stmt.executeUpdate("CREATE TABLE regi(" +
				"idnum            INT NOT NULL AUTO_INCREMENT," +
				"PRIMARY          KEY(idnum)," +
				"course_num       VARCHAR(100) NOT NULL," +
				"sec_num          VARCHAR(100) NOT NULL," +
				"course_name      VARCHAR(100) NOT NULL," +
				"time             VARCHAR(100) NOT NULL," +
				"place            VARCHAR(100) NOT NULL," +
				"instructor       VARCHAR(100) NOT NULL," +
				"last_name        VARCHAR(100) NOT NULL," +
				"first_name       VARCHAR(100) NOT NULL," +
				"stu_id           INT(100)     NOT NULL," +
				"major            VARCHAR(100) NOT NULL," +
				"year             INT(100) )");
			/*PreparedStatement queryusers = conn.prepareStatement("Select * from regi where userid=?");
			queryusers.setString(1, "theo");
			
			ResultSet rs = queryusers.executeQuery();*/
		}
		catch (SQLException E) {
			System.out.println("SQLException: " + E.getMessage());
			System.out.println("SQLState:     " + E.getSQLState());
			System.out.println("VendorError:  " + E.getErrorCode());
		}
	}
}

public class database_finalProject extends JFrame
{	
	static connect1 conn = new connect1();
	public database_finalProject()
	{
		final JTextArea txtList = new JTextArea();
		
		final CardLayout c1=new CardLayout();
		final JPanel cardpaneL1= new JPanel();
		cardpaneL1.setLayout(c1);

		setTitle("Course Registration System");
		setSize(500,300);

/*login screen*/
		JPanel jpL1=new JPanel();
		JButton b1=new JButton("Registration");
		JButton b2=new JButton("Course List");
		jpL1.add(b1);
		jpL1.add(b2);
		cardpaneL1.add(jpL1,"login");
/*login screen*/
		
/*existing data*/
		try{
			conn.stmt.executeUpdate( 
    			"INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
    			"VALUES( \""+"CS610"+"\", \""+"001"+"\", \""+"DataStructure"+"\", \""+"MON"+"\", \""+"FMH110"+"\","
    			+ "\""+"Nassimi"+"\", \""+"Li"+"\", \""+"Alen"+"\", \""+1111+"\", \""+"CS"+"\", \""+2+"\")"
    		        );
			conn.stmt.executeUpdate( 
	    		"INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
	    		"VALUES( \""+"CS610"+"\", \""+"002"+"\", \""+"DataStructure"+"\", \""+"FRI"+"\", \""+"GITC3100"+"\","
	    		+ "\""+"Obama"+"\", \""+"Kuo"+"\", \""+"William"+"\", \""+2222+"\", \""+"CS"+"\", \""+2+"\")"
	    	        );
			conn.stmt.executeUpdate( 
		    	"INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
		    	"VALUES( \""+"CS630"+"\", \""+"001"+"\", \""+"OperatingSystem"+"\", \""+"MON"+"\", \""+"KUPF104"+"\","
		    	+ "\""+"Hung"+"\", \""+"Yu"+"\", \""+"Kevin"+"\", \""+3333+"\", \""+"CS"+"\", \""+2+"\")"
		        );
			conn.stmt.executeUpdate( 
		    	"INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
		    	"VALUES( \""+"CS630"+"\", \""+"002"+"\", \""+"OperatingSystem"+"\", \""+"WED"+"\", \""+"KUPF208"+"\","
		    	+ "\""+"Ai"+"\", \""+"Yang"+"\", \""+"Frank"+"\", \""+4444+"\", \""+"IS"+"\", \""+2+"\")"
		        );
			conn.stmt.executeUpdate( 
		    	"INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
		    	"VALUES( \""+"CS631"+"\", \""+"001"+"\", \""+"DataBaseManageMent"+"\", \""+"TUE"+"\", \""+"Distance Learning"+"\","
		    	+ "\""+"Oria"+"\", \""+"Lin"+"\", \""+"Penny"+"\", \""+5555+"\", \""+"EE"+"\", \""+3+"\")"
		        );
			conn.stmt.executeUpdate( 
		    	"INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
		    	"VALUES( \""+"CS631"+"\", \""+"002"+"\", \""+"DataBaseManageMent"+"\", \""+"THR"+"\", \""+"KUPF210"+"\","
		    	+ "\""+"Hossein"+"\", \""+"Chen"+"\", \""+"Grant"+"\", \""+7777+"\", \""+"CE"+"\", \""+3+"\")"
		        );
			conn.stmt.executeUpdate( 
		    	"INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
		    	"VALUES( \""+"CS656"+"\", \""+"001"+"\", \""+"InternetProtocol"+"\", \""+"WED"+"\", \""+"CKB220"+"\","
		    	+ "\""+"Blank"+"\", \""+"Lin"+"\", \""+"Mike"+"\", \""+6666+"\", \""+"CHEM"+"\", \""+3+"\")"
		        );
			conn.stmt.executeUpdate( 
		    	"INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
		    	"VALUES( \""+"CS656"+"\", \""+"002"+"\", \""+"InternetProtocol"+"\", \""+"TUE"+"\", \""+"GITC4210"+"\","
		    	+ "\""+"Wang"+"\", \""+"Yang"+"\", \""+"Frank"+"\", \""+4444+"\", \""+"IS"+"\", \""+2+"\")"
		        );
			conn.stmt.executeUpdate( 
		    	"INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
		    	"VALUES( \""+"CS506"+"\", \""+"001"+"\", \""+"DiscreteMath"+"\", \""+"WED"+"\", \""+"TIER114"+"\","
		    	+ "\""+"Leung"+"\", \""+"Yu"+"\", \""+"Kevin"+"\", \""+3333+"\", \""+"CS"+"\", \""+2+"\")"
		        );
			conn.stmt.executeUpdate( 
		    	"INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
		    	"VALUES( \""+"CS506"+"\", \""+"002"+"\", \""+"DiscreteMath"+"\", \""+"MON"+"\", \""+"CMP220"+"\","
		    	+ "\""+"Yang"+"\", \""+"Chen"+"\", \""+"Grant"+"\", \""+7777+"\", \""+"CE"+"\", \""+3+"\")"
		        );
    	        }
		catch (SQLException E) {
			System.out.println("SQLException: " + E.getMessage());
			System.out.println("SQLState:     " + E.getSQLState());
			System.out.println("VendorError:  " + E.getErrorCode());
		}
/*existing data*/		
		
		b1.addActionListener(new ActionListener(){/*registration button*/
                   public void actionPerformed(ActionEvent arg0){
        		c1.show(cardpaneL1, "regi");
                   }
                });

		b2.addActionListener(new ActionListener(){/*course list button*/
                   public void actionPerformed(ActionEvent arg0){
            	      try{            		
            		PreparedStatement queryusers = conn.conn.prepareStatement("Select * from regi where userid=?");
        			queryusers.setString(1, "theo");
            		ResultSet rs = queryusers.executeQuery("Select * from regi order by course_num, sec_num, last_name");
            		System.out.println("course_num section_num     course_name  day            classroom Instructor  stu_Lastname stu_Firstname  stu_id  major year");
               		while (rs.next()){
               			System.out.format("%10s%8s%20s%5s%20s%10s%12s%14s%11s%7s%5s",rs.getString("course_num"),rs.getString("sec_num"),rs.getString("course_name"),
               					rs.getString("time"),rs.getString("place"),rs.getString("instructor"),rs.getString("last_name"),rs.getString("first_name"),
               					rs.getString("stu_id"), rs.getString("major"),rs.getString("year"));
           				System.out.println();
           	        }
            		System.out.println();
            		System.out.println();
            	     }
        		catch (SQLException E) {
        			System.out.println("SQLException: " + E.getMessage());
        			System.out.println("SQLState:     " + E.getSQLState());
        			System.out.println("VendorError:  " + E.getErrorCode());
        		}
            	c1.show(cardpaneL1, "list");
            }
        });


/*Registration Screen*/
		JPanel jpL2=new JPanel();
		jpL2.setLayout(new GridLayout(10,9));

		JLabel jL1=new JLabel("First Name");
		final JTextField firstname=new JTextField();
		JLabel jL2=new JLabel("Last Name");
		final JTextField lastname=new JTextField();
		JLabel jL3=new JLabel("Student_ID");
		final JTextField stuid=new JTextField();
		JLabel jL4=new JLabel("Major");
		final JTextField major=new JTextField();
		JLabel jL5=new JLabel("Year");
		final JTextField year=new JTextField();
		JLabel jL6=new JLabel("Course Number");
		final JTextField course_num=new JTextField();
		JLabel jL7=new JLabel("Course Section Number");
		final JTextField sec_num=new JTextField();
		JLabel jL8=new JLabel("No same course registered!");
		JLabel jL9=new JLabel("Classroom crowded!");
		JLabel jL0=new JLabel("You registered 3 courses already!");

		jpL2.add(jL1);
		jpL2.add(firstname);
		jpL2.add(jL2);
		jpL2.add(lastname);
		jpL2.add(jL3);
		jpL2.add(stuid);
		jpL2.add(jL4);
		jpL2.add(major);
		jpL2.add(jL5);
		jpL2.add(year);
		jpL2.add(jL6);
		jpL2.add(course_num);
		jpL2.add(jL7);
		jpL2.add(sec_num);

		JButton b3=new JButton("Enter");
		jpL2.add(b3);
		JButton b4=new JButton("Cancel");
		jpL2.add(b4);

		cardpaneL1.add(jpL2,"regi");
		
		b3.addActionListener(new ActionListener(){/*registration confirmation button*/
            public void actionPerformed(ActionEvent arg0){
            	String fname=firstname.getText();
            	String lname=lastname.getText();
            	String mj=major.getText();
            	String Stu_id=stuid.getText();
            	int    Year=Integer.parseInt(year.getText());
            	String Course_num=course_num.getText();
            	String Sec_num=sec_num.getText();            	         	
            	int count=0, regi_limit=0, capacity=0;
            	
            	try{
            		PreparedStatement queryusers = conn.conn.prepareStatement("Select * from regi where userid=?");
        			queryusers.setString(1, "theo");
            		ResultSet rs = queryusers.executeQuery("Select * from regi");
            		
            		while (rs.next()){
            			if( fname.equals(rs.getString("first_name")) && lname.equals(rs.getString("last_name")) &&Course_num.equals(rs.getString("course_num")))
        					count++;
            			if( fname.equals(rs.getString("first_name")) && lname.equals(rs.getString("last_name")) &&Stu_id.equals(rs.getString("stu_id")))
        					regi_limit++;
            			if( Course_num.equals(rs.getString("course_num")) && Sec_num.equals(rs.getString("sec_num")))
        					capacity++;
            		}
            		if(count!=0) setTitle("No same course registered!");
            		else if(regi_limit==3) setTitle("You registered 3 courses already!");
            		else if(capacity==3) setTitle("Classroom crowded!");
            		else{
            		   
            		   if(Course_num.equals("CS610")){
             			   if(Sec_num.equals("001")){
             			   	  conn.stmt.executeUpdate( 
                     		  	  "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                      "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"DataStructure"+"\", \""+"MON"+"\", \""+"FMH110"+"\","
                                 	 + "\""+"Nassimi"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                                );setTitle("Registration Successfully!");
             			   }
             			   else if(Sec_num.equals("002")){
             				  conn.stmt.executeUpdate( 
                          	     "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                       "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"DataStructure"+"\", \""+"FRI"+"\", \""+"GITC3100"+"\","
                                        + "\""+"Obama"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                               ); setTitle("Registration Successfully!");
             			   }
             		   }
            		   else if(Course_num.equals("CS630")){
            			   if(Sec_num.equals("001")){
            			   	  conn.stmt.executeUpdate( 
                    		  	  "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                     "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"OperatingSystem"+"\", \""+"MON"+"\", \""+"KUPF104"+"\","
                                	 + "\""+"Hung"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                               );setTitle("Registration Successfully!");
            			   }
            			   else if(Sec_num.equals("002")){
            				  conn.stmt.executeUpdate( 
                         	     "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                      "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"OperatingSystem"+"\", \""+"WED"+"\", \""+"KUPF208"+"\","
                                       + "\""+"Ai"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                              ); setTitle("Registration Successfully!");
            			   }
            		   }
            		   else if(Course_num.equals("CS631")){
            			   if(Sec_num.equals("001")){
            			   	  conn.stmt.executeUpdate( 
                    		  	  "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                     "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"DataBaseManageMent"+"\", \""+"TUE"+"\", \""+"Distance Learning"+"\","
                                	 + "\""+"Oria"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                               );setTitle("Registration Successfully!");
            			   }
            			   else if(Sec_num.equals("002")){
            				  conn.stmt.executeUpdate( 
                         	     "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                      "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"DataBaseManageMent"+"\", \""+"THR"+"\", \""+"KUPF210"+"\","
                                       + "\""+"Hossein"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                              ); setTitle("Registration Successfully!");
            			   }
            		   }
            		   else if(Course_num.equals("CS656")){
            			   if(Sec_num.equals("001")){
            			   	  conn.stmt.executeUpdate( 
                    		  	  "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                     "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"InternetProtocol"+"\", \""+"WED"+"\", \""+"CKB220"+"\","
                                	 + "\""+"Blank"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                               );setTitle("Registration Successfully!");
            			   }
            			   else if(Sec_num.equals("002")){
            				  conn.stmt.executeUpdate( 
                         	     "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                      "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"InternetProtocol"+"\", \""+"TUE"+"\", \""+"GITC4210"+"\","
                                       + "\""+"Wang"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                              ); setTitle("Registration Successfully!");
            			   }
            		   }
            		   else if(Course_num.equals("CS506")){
            			   if(Sec_num.equals("001")){
            			   	  conn.stmt.executeUpdate( 
                    		  	  "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                     "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"DiscreteMath"+"\", \""+"WED"+"\", \""+"TIER114"+"\","
                                	 + "\""+"Leung"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                               );setTitle("Registration Successfully!");
            			   }
            			   else if(Sec_num.equals("002")){
            				  conn.stmt.executeUpdate( 
                         	     "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                      "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"DiscreteMath"+"\", \""+"MON"+"\", \""+"CMP220"+"\","
                                       + "\""+"Yang"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                              ); setTitle("Registration Successfully!");
            			   }
            		   }
            		   else if(Course_num.equals("CS602")){
            			   if(Sec_num.equals("001")){
            			   	  conn.stmt.executeUpdate( 
                    		  	  "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                     "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"JavaProgramming"+"\", \""+"THR"+"\", \""+"TIER104"+"\","
                                	 + "\""+"Hsu"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                               );setTitle("Registration Successfully!");
            			   }
            			   else if(Sec_num.equals("002")){
            				  conn.stmt.executeUpdate( 
                         	     "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                      "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"JavaProgramming"+"\", \""+"WED"+"\", \""+"KUPF210"+"\","
                                       + "\""+"Nick"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                              ); setTitle("Registration Successfully!");
            			   }
            		   }
            		   else if(Course_num.equals("CS635")){
            			   if(Sec_num.equals("001")){
            			   	  conn.stmt.executeUpdate( 
                    		  	  "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                     "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"ComputerLanguage"+"\", \""+"WED"+"\", \""+"CKB217"+"\","
                                	 + "\""+"Donald"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                               );setTitle("Registration Successfully!");
            			   }
            			   else if(Sec_num.equals("002")){
            				  conn.stmt.executeUpdate( 
                         	     "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                      "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"ComputerLanguage"+"\", \""+"MON"+"\", \""+"GITC3010"+"\","
                                       + "\""+"Wallace"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                              ); setTitle("Registration Successfully!");
            			   }
            		   }
            		   else if(Course_num.equals("CS634")){
            			   if(Sec_num.equals("001")){
            			   	  conn.stmt.executeUpdate( 
                    		  	  "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                     "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"DataMining"+"\", \""+"MON"+"\", \""+"KUPF209"+"\","
                                	 + "\""+"Jason"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                               );setTitle("Registration Successfully!");
            			   }
            			   else if(Sec_num.equals("002")){
            				  conn.stmt.executeUpdate( 
                         	     "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                      "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"DataMining"+"\", \""+"TUE"+"\", \""+"KUPF107"+"\","
                                       + "\""+"Roy"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                              ); setTitle("Registration Successfully!");
            			   }
            		   }
            		   else if(Course_num.equals("CS643")){
            			   if(Sec_num.equals("001")){
            			   	  conn.stmt.executeUpdate( 
                    		  	  "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                     "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"CloudComputing"+"\", \""+"MON"+"\", \""+"FMH209"+"\","
                                	 + "\""+"Christina"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                               );setTitle("Registration Successfully!");
            			   }
            			   else if(Sec_num.equals("002")){
            				  conn.stmt.executeUpdate( 
                         	     "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                      "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"CloudComputing"+"\", \""+"Fri"+"\", \""+"DistanceLearning"+"\","
                                       + "\""+"Rose"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                              ); setTitle("Registration Successfully!");
            			   }
            		   }
            		   else if(Course_num.equals("CS645")){
            			   if(Sec_num.equals("001")){
            			   	  conn.stmt.executeUpdate( 
                    		  	  "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                     "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"CyberSecurity"+"\", \""+"TUE"+"\", \""+"CKB330"+"\","
                                	 + "\""+"John"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                               );setTitle("Registration Successfully!");
            			   }
            			   else if(Sec_num.equals("002")){
            				  conn.stmt.executeUpdate( 
                         	     "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                      "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"CyberSecurity"+"\", \""+"Fri"+"\", \""+"KUPF104"+"\","
                                       + "\""+"Frank"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                              ); setTitle("Registration Successfully!");
            			   }
            		   }
            		   else if(Course_num.equals("CS652")){
            			   if(Sec_num.equals("001")){
            			   	  conn.stmt.executeUpdate( 
                    		  	  "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                     "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"NetworkArch"+"\", \""+"THR"+"\", \""+"FMH408"+"\","
                                	 + "\""+"DK"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                               );setTitle("Registration Successfully!");
            			   }
            			   else if(Sec_num.equals("002")){
            				  conn.stmt.executeUpdate( 
                         	     "INSERT INTO regi (course_num, sec_num, course_name, time, place, instructor, last_name, first_name, stu_id, major, year)" +
                                      "VALUES( \""+Course_num+"\", \""+Sec_num+"\", \""+"NetworkArch"+"\", \""+"Sat"+"\", \""+"DistanceLearning"+"\","
                                       + "\""+"DK"+"\", \""+lname+"\", \""+fname+"\", \""+Stu_id+"\", \""+mj+"\", \""+Year+"\")" 
                              ); setTitle("Registration Successfully!");
            			   }
            		   }else setTitle("We don't provide this course!");
            		   //else setTitle("We don't provide this course!");
            		/*rs = queryusers.executeQuery("Select * from regi order by course_num, sec_num, last_name");
               		System.out.println("course_num section_num     course_name  day            classroom Instructor  stu_Lastname stu_Firstname  stu_id  major year");
               		while (rs.next()){
               			System.out.format("%10s%8s%20s%5s%20s%10s%12s%14s%11s%7s%5s",rs.getString("course_num"),rs.getString("sec_num"),rs.getString("course_name"),
               					rs.getString("time"),rs.getString("place"),rs.getString("instructor"),rs.getString("last_name"),rs.getString("first_name"),
               					rs.getString("stu_id"), rs.getString("major"),rs.getString("year"));
           				System.out.println();
           			}
               		System.out.println();
               		System.out.println();*/
            	    }
            	}
        		catch (SQLException E) {
        			System.out.println("SQLException: " + E.getMessage());
        			System.out.println("SQLState:     " + E.getSQLState());
        			System.out.println("VendorError:  " + E.getErrorCode());
        		}
            	
            }
        });
		b4.addActionListener(new ActionListener(){/*back to main menu*/
            public void actionPerformed(ActionEvent arg0){            	
            	c1.show(cardpaneL1, "login");
            }
        });
/*Registration Screen*/
		
/*Course List Screen*/
		JPanel jpL3=new JPanel();
		//jpL3.setLayout(new GridLayout(2,1));
		JScrollPane scroll = new JScrollPane(txtList,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		txtList.setLineWrap(false);
		txtList.setEditable(false);
		jpL3.add(scroll);
		
		JButton b5=new JButton("Exit");
		jpL3.add(b5);
		
		cardpaneL1.add(jpL3,"list");
		
		b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
            	c1.show(cardpaneL1, "login");
            }
        });
/*Course List Screen*/
		
		getContentPane().add(cardpaneL1);
	}	
	

	public static void main(String[] args){
		database_finalProject db1 = new database_finalProject();
        db1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        db1.setVisible(true);       
        
	}
}

