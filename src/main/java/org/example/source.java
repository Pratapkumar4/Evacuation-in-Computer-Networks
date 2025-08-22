package org.example;
import java.lang.String;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Vector;
import java.sql.*;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class source extends JFrame {
    int cs = 1, emp;
    Vector vec = new Vector();
    int load = 0, ico = 0, userfound;
    Toolkit toolkit;
    Timer timer;
    Vector ft = new Vector();
    int numWarningBeeps = 3;
    boolean sss;
    private JLabel jLabel1;
    private JLabel jLabel2;
    InetAddress in1, inet;
    JTextField tf = new JTextField(25);
    JTextField des = new JTextField(25);
    private JList jList1;
    // 1private JTextField jTextField1;
    private JTextArea jTextArea1, jTextArea2;
    private JScrollPane jScrollPane1, jScrollPane2;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JPanel contentPane;
    JTextField jTextField1;
    // JButton jButton3;
    // private JScrollPane jScrollPane1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private String ServerSystemName = "localhost";
    FileDialog fd;
    int ww, portno;
    String filename, choice, ack, send, msg, desti, host;
    int ps, pactot, rr, len, length, port, start, end;
    JComboBox jComboBox1;
    Socket soc, s, s1, s2;
    ButtonGroup bg;
    ObjectOutputStream out1, out2, oos, oos1, oos2;
    ObjectInputStream oin1, oin2, ois1, ois2, ois3;
    Vector data;
    public source() {
        data = new Vector();
        fd = new FileDialog(this, " Select the File", FileDialog.LOAD);
        fd.setFile("*.txt");
        setResizable(false);
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel(" Connected Destinations ...");
        jLabel6 = new JLabel(" ( or )");
        jLabel7 = new JLabel(new ImageIcon("OCGRR.jpg"));
        jList1 = new JList();
        // jTextField1 = new JTextField("localhost");
        jComboBox1 = new JComboBox();
        jTextField1 = new JTextField();
        jTextArea1 = new JTextArea();
        jScrollPane1 = new JScrollPane();
        jTextArea2 = new JTextArea();
        jScrollPane2 = new JScrollPane();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        contentPane = (JPanel) this.getContentPane();
        // JCheckBoxGroup cg=new JCheckBoxGroup();
        jLabel3 = new JLabel();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jRadioButton3 = new JRadioButton();
        jRadioButton1.setActionCommand("HIGH");
        jRadioButton2.setActionCommand("NORMAL");
        jRadioButton3.setActionCommand("LOW");
        bg = new ButtonGroup();
        bg.add(jRadioButton1);
        bg.add(jRadioButton2);
        bg.add(jRadioButton3);
        // jLabel1
        jLabel1.setText("Destination System Name :");
        // jLabel2
        jLabel2.setText("Enter The Text :");
        jLabel3.setText("Select The File:");
        jLabel4.setText("    Traffic Class Type :");
        jList1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                // jList1_valueChanged(e);
                System.out.println(" Hai ...");
            }
        });
        // jTextArea1
        jTextArea1.setText("");
        // jScrollPane1
        jList1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                jList1_valueChanged(e);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);
        jScrollPane2.setViewportView(jList1);
        jButton3.setText("Browse");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fd.setVisible(true);
                String filename = fd.getDirectory() + fd.getFile();
                if (filename.equals("nullnullnull")) {
                    jTextField1.setText("");
                } else if (filename.equals("nullnull")) {
                    jTextField1.setText("");
                } else if (filename.equals("null")) {
                    jTextField1.setText("");
                } else {
                    jTextField1.setText(filename);
                }
                System.out.println(" file : " + filename);
                // send();
            }
        });
        // jButton1
        jButton1.setText("Send");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int uy = jTextField1.getText().length();
                if (uy == 0) {
                    send();
                    System.out.println("innnttttttttttttttttttttttttttttt..");
                } else {
                    jTextArea1.setText("");
                    String filen = jTextField1.getText();
                    try {
                        BufferedReader in = new BufferedReader(new FileReader(filen));
                        String s, s1 = new String();
                        if (jTextArea1.getText().length() == 0) {
                            emp = 1;
                        }
                        while ((s = in.readLine()) != null) {
                            if (emp == 0) {
                                jTextArea1.setText(jTextArea1.getText() + "\n" + s);
                                // emp=1;
                            } else {
                                jTextArea1.setText(s);
                                emp = 0;
                            }
                        }
                        send();
                        // jTextField1.setText("");
                    } catch (Exception er) {
                        System.out.println(er);
                    }
                    // System.out.println("Nooooooooooooooooooooooo..");
                }
            }
        });
        // jButton2
        jButton2.setText("Clear");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                des.setText("");
                jTextField1.setText("");
                jTextArea1.setText("");
                // des.setFocus();
                jRadioButton1.setSelected(true);
                // oos2=new ObjectOutputStream(s1.getOutputStream());
                // oos2.writeObject("");
            }
        });
        // contentPane
        jRadioButton1.setText("HIGH");
        jRadioButton1.setSelected(true);
        jRadioButton1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                // jRadioButton1_itemStateChanged(e);
            }
        });
        // jRadioButton2
        jRadioButton2.setText("NORMAL");
        jRadioButton2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                // jRadioButton2_itemStateChanged(e);
            }
        });
        // jRadioButton3
        jRadioButton3.setText("LOW");
        jRadioButton3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                // jRadioButton3_itemStateChanged(e);
            }
        });
        jRadioButton1.setText("HIGH");
        jRadioButton1.setSelected(true);
        jRadioButton1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                // jRadioButton1_itemStateChanged(e);
            }
        });
        // jRadioButton2
        jRadioButton2.setText("NORMAL");
        jRadioButton2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                // jRadioButton2_itemStateChanged(e);
            }
        });
        // jRadioButton3
        jRadioButton3.setText("LOW");
        jRadioButton3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                // jRadioButton3_itemStateChanged(e);
            }
        });
        // jComboBox1.addItem("LocalHost");
        contentPane.setLayout(null);
        addComponent(contentPane, jLabel7, 0, 0, 550, 100);
        addComponent(contentPane, jLabel1, 32, 128, 152, 35);
        addComponent(contentPane, jLabel5, 352, 108, 142, 35);
        addComponent(contentPane, jLabel2, 75, 192, 151, 29);
        addComponent(contentPane, jLabel6, 232, 238, 142, 35);
        addComponent(contentPane, jLabel3, 75, 270, 150, 20);
        addComponent(contentPane, jTextField1, 183, 268, 167, 22);
        addComponent(contentPane, des, 187, 135, 100, 22);
        addComponent(contentPane, jScrollPane1, 188, 176, 159, 71);
        addComponent(contentPane, jButton3, 363, 265, 83, 28);
        addComponent(contentPane, jScrollPane2, 359, 140, 120, 120);
        addComponent(contentPane, jLabel4, 58, 325, 157, 18);
        addComponent(contentPane, jRadioButton1, 186, 325, 60, 24);
        addComponent(contentPane, jRadioButton2, 261, 325, 80, 24);
        addComponent(contentPane, jRadioButton3, 341, 325, 60, 24);
        addComponent(contentPane, jButton1, 190, 370, 83, 28);
        addComponent(contentPane, jButton2, 290, 370, 83, 28);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    String ccd = "You are Exiting....";
                    JOptionPane.showMessageDialog(source.this, ccd, "Message ...", JOptionPane.INFORMATION_MESSAGE);
                    Thread.sleep(1000);
                    System.exit(0);
                } catch (Exception eryt) {
                    String ccd = "Your Request is not Processed. Non Blocked is occur. ....";
                    JOptionPane.showMessageDialog(source.this, ccd, "Message ...", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        // c1
        System.out.println("--------------------------Window Loading Time----------------");
        try {
            inet = InetAddress.getLocalHost();
            host = inet.getHostName().toUpperCase();
            choice = bg.getSelection().getActionCommand();
            if (choice.equals("HIGH")) {
                portno = 8888;
            } else if (choice.equals("NORMAL")) {
                portno = 7777;
            } else if (choice.equals("LOW")) {
                portno = 2255;
            }
            System.out.println("  -> Choice : " + choice + " POrt No  :" + portno);
            s1 = new Socket(ServerSystemName, portno);
            s = new Socket(ServerSystemName, portno);
            s2 = new Socket(ServerSystemName, portno);
            // username stored to the server
            oos1 = new ObjectOutputStream(s1.getOutputStream());
            oos1.writeObject((host.toUpperCase()));
            // msg sending to server
            // Ack receiving from server for allow or not accepting the msg
            ois1 = new ObjectInputStream(s1.getInputStream());
            String ack = (String) ois1.readObject();
            System.out.println(" General ack  rev : " + ack);
            oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject((host.toUpperCase()) + ":SERVER:SERVER:SERVER:LOGINnull");
            // update user login status
            oos2 = new ObjectOutputStream(s2.getOutputStream());
            oos2.writeObject((host.toUpperCase()));
            Thread.sleep(1000);
        } catch (Exception eryt) {
            // ww=1;
                         System.out.println(" Server is not started..."+eryt);
            String ccd = "Server is not started. ....";
            JOptionPane.showMessageDialog(source.this, ccd, "Message ...", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        // userupdate();
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                JList jList1 = (JList) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2) {
                    int index = jList1.locationToIndex(mouseEvent.getPoint());
                    if (index >= 0) {
                        Object o = jList1.getModel().getElementAt(index);
                        // System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected.");
                        // String tatext=jTextArea1.getText();
                        des.setText(o.toString());
                        // view v1=new view(o.toString());
                        // System.out.println("Double-clicked on: " + o.toString());
                    }
                }
            }
        };
        jList1.addMouseListener(mouseListener);
        this.setTitle(" OCGRR : Source...");
        this.setLocation(new Point(50, 50));
        this.setSize(new Dimension(560, 450));
        this.setVisible(true);
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(), 0, // initial delay
                1 * 1000); // subsequent rate
    }
    private void jList1_valueChanged(ListSelectionEvent e) {
        System.out.println("\njList1_valueChanged(ListSelectionEvent e) called.");
        if (!e.getValueIsAdjusting()) {
            Object o = jList1.getSelectedValue();
            System.out.println(">>" + ((o == null) ? "null" : o.toString()) + " is selected.");
        }
    }
    private void addComponent(Container container, Component c, int x, int y, int width, int height) {
        c.setBounds(x, y, width, height);
        container.add(c);
    }
    private void jButton1_actionPerformed(ActionEvent e) {
    }
    private void jButton2_actionPerformed(ActionEvent e) {
    }
    private void jButton3_actionPerformed(ActionEvent e) {
    }
    private void jButton4_actionPerformed(ActionEvent e) {
    }
    class RemindTask extends TimerTask {
        public void run() {
            while (true) {
                sss = true;
                while (sss) {
                    if (numWarningBeeps > 0) {
                        long time = System.currentTimeMillis();
                        if (time - scheduledExecutionTime() > 5) {
                            return;
                        }
//                        System.out.println(" Updating the source Details !" + numWarningBeeps);
                        userupdate();
                        numWarningBeeps--;
                    } else {
                        // toolkit.beep();
//                        System.out.println("Time's up!");
                        sss = false;
                        numWarningBeeps = 2;
                        userupdate();
                        break;
                        // timer.cancel(); //Not necessary because we call System.exit
                        // System.exit(0); //Stops the AWT thread (and everything else)
                    }
                } // if closed
            } // run() closed
        }
    }
    public void userupdate() {
        Vector ft = new Vector();
        try {
//            System.out.println(" Inside the user update .....");
            Connection con1 = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection
            String url = "jdbc:mysql://localhost:3307/maintable";
            String username = "root";
            String password = "root";
            con1 = DriverManager.getConnection(url, username, password);
//            System.out.println("database connected");
            Statement st1 = con1.createStatement();
            String app = "SELECT * FROM userlist";
            ResultSet rs = st1.executeQuery(app);
            while (rs.next()) {
//                System.out.println(" Inside the TABLE.....");
                String name = rs.getString(1);
                ft.add(name);
//                System.out.println(ft);
            }
        } catch (Exception eee) {
            System.out.println(" Could not get The table values...." + eee);
        }
        jList1.setListData(ft);
    }
    public void send()
	{
		ww=0;
		System.out.println("--------------------------Inside send() function----------------");
		//JOptionPane optionPane = new JOptionPane("JRadio Button Selected....",  JOptionPane.WARNING_MESSAGE);
		try
		{
				String nam=des.getText();
				nam=nam.trim();
				System.out.println(" Inside the user update .....");
				Connection con1=null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection
            String url = "jdbc:mysql://localhost:3307/maintable";
            String username = "root";
            String password = "root";
            con1 = DriverManager.getConnection(url, username, password);
            System.out.println("database connected");	Statement st1=con1.createStatement();
				String app="SELECT * FROM userlist";
				ResultSet rs=st1.executeQuery(app);
				userfound=0;
				while(rs.next())
				{
                  if(nam.equals(rs.getString(1).trim()))
					{
					  userfound=1;
					}
				}
			if(des.getText().length()==0)
			{
				ww=3;
			}
			else if(userfound==0)
			{
				ww=4;
			}
			else if(jTextArea1.getText().length()==0)
			{
				ww=5;
			}
			else
			{
				msg=jTextArea1.getText();
				len=msg.length();
				length=len;
				 System.out.println(" Total len : "+len );
				 try
				 {
                     in1 = InetAddress.getLocalHost(); // to get the localhost
                     desti = des.getText();
                     portno = 8888;
                     inet = InetAddress.getLocalHost();
                     host = inet.getHostName().toUpperCase();
                     System.out.println(" host name :" + host);
                     String ServerSystemName = "localhost"; // or "127.0.0.1"
				 }
				 catch (Exception ee)
				 {
					 System.out.println(" After length :"+ee);
				 }
				 if(desti.equals("LocalHost"))
				{
					desti=in1.getHostName().toUpperCase();
				}
			System.out.println("_");
			 if(desti.equals("Select the Host Name..."))
				{
					 System.out.println("inner select host");
					// JOptionPane.showMessageDialog(source.this,"Select the Destinstion System...", "Message ...",JOptionPane.INFORMATION_MESSAGE);
					// sf.source();
				}
			 start=0;
			 end=0;
           	 ps=0;
			 pactot=0;
				 if(len<=50)
				 {
					ps=50;
				 }
				 else if((len>50)&&(len<100))     //66
				 {
					ps=33;
				 }
				else if((len>99)&&(len<=200))
				{
					ps=50;
				}
				else if((len>200)&&(len<=300))
				{
					ps=100;
				}
				else if((len>300)&&(len<=500))
				{
					ps=150;
				}
				else
				{
					ps=300;
				}
		   String conc=(in1.getHostName().toUpperCase())+" : "+desti+" : "+len+" : ";
			pactot=(len/ps);
			pactot++;
			JOptionPane.showMessageDialog(this," No of Packets : "+pactot," Length : "+len+ " Packet Size  ..."+ps,JOptionPane.INFORMATION_MESSAGE);
					start=0;
					rr=0;
					if(ps>len)
					{
						end=len; //rr=1;
					}
					else
					{
						end=ps; //rr=0;
					}
					int kk=0;
					inet=InetAddress.getLocalHost();
					host=inet.getHostName().toUpperCase();
				    choice = bg.getSelection().getActionCommand();
					  if(choice.equals("HIGH"))
						{
						  portno=8888;
						}
						else if(choice.equals("NORMAL"))
						{
							portno=7777;
						}
						else if(choice.equals("LOW"))
						{
							portno=2255;
						}
						System.out.println("  -> Choice : "+choice+" Port No  :"+portno);
                   while(kk<pactot)
				   {
					   try
					   {
							s1=new Socket(ServerSystemName,portno);
							s=new Socket(ServerSystemName,portno); // purpose of msg sending
							s2=new Socket(ServerSystemName,portno);
							// SEND    //------------------------ 1 -------------------------------------
							Thread.sleep(1000);
							oos1=new ObjectOutputStream(s1.getOutputStream());
							oos1.writeObject(host.toUpperCase());
							System.out.println(host.toUpperCase());
							Thread.sleep(1000);
					   }
					   catch (Exception ert1)
					   {
						   System.out.println("@@@@@---------> Send () Exception :"+ert1);
					   }
                  //------------------------ 2 ---------------------------------------
        //RECEIVE // Ack receiving from server for allow or not accepting the msg]
								System.out.println(" Inner send(function) ack  rev : ");
								ois1=new ObjectInputStream(s1.getInputStream());
								ack=(String)ois1.readObject();
								System.out.println(" Inner send() ack  rev : "+ack);
   //SEND MSG TO SCHEDULER
						oos=new ObjectOutputStream(s.getOutputStream());
						send=msg.substring(start,end);
						System.out.println(start+" / "+end+"/ Msg : "+send+"\n" );
						//Thread.sleep(1000);
						//----------------------------------------------------
						//long time = System.currentTimeMillis();
						long time=System.nanoTime();
						//-----------------------------------------------------
						if(kk==(pactot-1)) // We include the null word in the last packet Last packet
					   {
							//Thread.sleep(1000);
							if(ack.equals("allow"))
							{
								try
								{
									oos.writeObject(conc+time+" : "+send+"null");
								}
								catch (Exception ty)
								{
									System.out.println(" Allow loop : "+ty);
								}
							}
							else
							{
								oos.writeObject(conc+time+" : notall");
							}
							System.out.println("true");
					   }
					   else
					   {
								if(ack.equals("allow"))
								{
								 	oos.writeObject(conc+time+" : "+send);
								}
								else
								{
									oos.writeObject(conc+time+" : notall");
								}
								System.out.println("false");
						}
						System.out.println("Out side of the allow");
							start=end;  //ss
							end=start+ps;
							if(end>len)
							{
								end=len;
								rr=1;

							}

								System.out.println("At last packet -1 loop");
								kk++;


						oos2=new ObjectOutputStream(s2.getOutputStream());
						if(ack.equals("allow"))
						   {
								oos2.writeObject("nosys");
						   }
						   else
							{
							     oos2.writeObject("allsys");

							   ww=2;

							}
	   }

					 System.out.println("Total outside in allow");

					//-----------------------------------------------------------------------

					 int yu=data.size();
					 System.out.println(" vec size :"+yu+" / and cleared the elements ");
					 data.removeAllElements();
					 yu=data.size();
					 System.out.println(" vec size :"+yu+" / and cleared the elements ");


		}try{
            Socket socket = new Socket(ServerSystemName, portno);
            System.out.println("Connected to server: " + ServerSystemName + " on port " + portno);

            try (ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

                oos.writeObject("Hello from client!");
                System.out.println("Sent message to server");

                String ack = (String) ois.readObject();
                System.out.println("Received ack from server: " + ack);

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error during communication with server: " + e);
            }
        }
			catch(Exception e)
			  {
				ww=1;
			  }
			  	if(ww==1)
				{
						System.out.println("Your Request is not Processed. Non Blocked is occur. ....");
						String ccd="Your Request is not Processed. Non Blocked is occur. ....";
						JOptionPane.showMessageDialog(source.this,ccd, "Message ...",JOptionPane.INFORMATION_MESSAGE);
						ww=0;
				}else if(ww==2)
				{

						String ccd="Server is in Blocked Stage.So Ur msg is Not send....";
						JOptionPane.showMessageDialog(source.this,ccd, "Message ...",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(ww==0)
				{
			 			String res=" Your data Successfully Transmit to the Destination....";
						JOptionPane.showMessageDialog(source.this,res, " Acknowledgement ...",JOptionPane.INFORMATION_MESSAGE);
						ww=0;

				}
				else if(ww==3)
				{
						String res=" Select The Destination System Name....";
						JOptionPane.showMessageDialog(this,res, " Error ...",JOptionPane.INFORMATION_MESSAGE);
						ww=0;
				}
				else if(ww==4)
				{
						String res=" Destination System Not available....";
						JOptionPane.showMessageDialog(this,res, " Error ...",JOptionPane.INFORMATION_MESSAGE);
						ww=0;
				}
				else if(ww==5)
				{
						String res=" Msg  Length is < 0....";
						JOptionPane.showMessageDialog(this,res, " Error ...",JOptionPane.INFORMATION_MESSAGE);
						ww=0;
				}
				else
				{
						JOptionPane.showMessageDialog(source.this," Destination System is Currently not available ....", " Acknowledgement ...",JOptionPane.INFORMATION_MESSAGE);
						ww=0;
				}
	  } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        class my1 implements Runnable
	{
		ObjectOutputStream out1;
		ObjectInputStream obj;
		String host;
		my1(ObjectOutputStream out1,String host)
		{
			this.out1=out1;
			this.host=host;
		}
		public void run()
		{
			try
			{
				out1.writeObject(host);
			}
			catch (Exception e)
			{
                System.out.println(e);
            }
			}
		}
	}
    public static void main(String args[]) throws IOException {
        try {
            new Login();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        source sf = new source();
        sf.userupdate();
    }
}