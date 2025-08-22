package org.example;//this is pgm_2 - server
// eg pgm for start the Server Socket and continue the Listening  ...............
// page 456 start

								// Request and Response and
								//Send Acknoledgement from server to client

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Timer;
import java.util.*;

                                class forward extends JFrame
                                {
                                     Toolkit toolkit;
                                     Timer timer;
                                     static 	int i=0,st1,counter;
                                     int sto;
                                     String mesg;
                                     //ServerSocket ss=new ServerSocket(6666);
                                     Connection con;
                                     Statement st;
                                     DefaultListModel model1;
                                     private JLabel jLabel1;
                                      private JLabel jLabel2;
                                      private JLabel jLabel3;
                                      private JLabel jLabel4;
                                      private JList jList1;
                                      private JScrollPane jScrollPane1;
                                      private JTextArea jTextArea1;
                                      private JScrollPane jScrollPane2;
                                      private JButton jButton1;
                                      private JButton jButton2;
                                     private JButton jButton3;
                                      private JButton jButton4;
                                      private JPanel contentPane;
                                     Vector data=new Vector();
                                     ArrayList a1=new ArrayList();
                                     ArrayList a2=new ArrayList();
                                     ArrayList allname=new ArrayList();
                                     String logsys,log,sname,all,desname,smesg;
                                     Thread t1;
                                     String source,destination,state,smsg,srcname,msgtime;
                                     FileOutputStream output,op1;
                                     String fd;
                                     boolean sta=true,stak;
                                     int end;

                                //	 ServerSocket ss1=new ServerSocket(4442);
                                     Socket  cs,cs1,cs2;
                                     ObjectInputStream in,in1,in2;
                                     ObjectOutputStream ois1,ois2,ois3;

                                     String res1;
                                      int  staa=0,che;
                                     String hh;
                                     Vector v1,v2;
                                     String name[]=new String[100];
                                     String allsta;
                                     int portno;
                                     int numWarningBeeps=1 ;
                                     boolean sss;

                                        forward()throws Exception
                                        {
                                            portno=6666;
                                            v1=new Vector();

                                            allsta="allow";
                                            jLabel1 = new JLabel();
                                             jLabel2 = new JLabel();
                                            jLabel3=new JLabel(new ImageIcon("OCGRR.jpg"));
                                             jLabel4 = new JLabel();
                                            model1=new DefaultListModel();
                                             jList1 = new JList();
                                             jScrollPane1 = new JScrollPane();
                                             jTextArea1 = new JTextArea();
                                             jScrollPane2 = new JScrollPane();
                                             jButton1 = new JButton();
                                             jButton2 = new JButton();
                                             jButton3 = new JButton();
                                             jButton4 = new JButton();
                                             contentPane = (JPanel)this.getContentPane();
                                            setResizable(false);
                                            op1=new FileOutputStream("msgbackup.txt");
                                            output=new FileOutputStream("msgbackup.txt",true);

                                            jTextArea1.setText("Server Started ....");
                                             jLabel1.setText("Currently Connected System ...");
                                             jLabel2.setText("Message Details ...");
                                             jLabel3.setText("jLabel3");
                                             jLabel4.setText("jLabel4");

                                            jList1.addListSelectionListener(new ListSelectionListener() {

                                            public void valueChanged(ListSelectionEvent e)
                                             {
                                                 jList1_valueChanged(e);
                                             } });

                                             jScrollPane1.setViewportView(jList1);
                                             jScrollPane2.setViewportView(jTextArea1);
                                             jButton1.setText("VIEW");
                                             jButton1.addActionListener(new ActionListener() {

                                            public void actionPerformed(ActionEvent e)
                                             {
                                                 jButton1_actionPerformed(e);
                                                Object o = jList1.getSelectedValue();
                                                 System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected.");
                                                view v1=new view(o.toString());
                                             } });
                                            jButton2.setText("Allow");
                                             jButton2.addActionListener(new ActionListener() {

                                            public void actionPerformed(ActionEvent e)
                                             {
                                                 allsta="allow";
//                                                jButton3.setEnabled(true);
                                                jButton2.setEnabled(false);
                                                System.out.println(" b1 clicked ....");
                                            } });

//                                            jButton3.setText("Send View");
//                                             jButton3.addActionListener(new ActionListener() {
//
//                                            public void actionPerformed(ActionEvent e)
//                                             {
//                                                 new sendmsg();
//
//                                             } });

                                            jButton4.setText("EXIT");
                                             jButton4.addActionListener(new ActionListener() {

                                            public void actionPerformed(ActionEvent e)
                                             {
                                                 jButton4_actionPerformed(e);
                                                System.exit(0);
                                             } });

                                            addWindowListener(new WindowAdapter()
                                            {
                                                public void windowClosing(WindowEvent e)
                                                {
                                                    System.exit(0);
                                                }
                                            });

                                            String rew="";

                                            op1.write(rew.getBytes());

                                             contentPane.setLayout(null);
                                            addComponent(contentPane, jLabel3, 0,0,560,100);
                                             addComponent(contentPane, jLabel1, 351,110,183,18);
                                             addComponent(contentPane, jLabel2, 24,112,210,18);
                                             //addComponent(contentPane, jLabel3, 9,4,99,38);
                                             //addComponent(contentPane, jLabel4, 121,8,392,35);
                                             addComponent(contentPane, jScrollPane1, 359,135,151,209);
                                             addComponent(contentPane, jScrollPane2, 12,136,333,373);
                                             //addComponent(contentPane, jButton1, 377,289,83,28);
                                             //addComponent(contentPane, jButton2, 377,323,83,28);
//                                             addComponent(contentPane, jButton3, 377,410,103,28);
                                             addComponent(contentPane, jButton4, 377,463,103,28);

                                            // ********************************************************************

                                            /*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                            con=DriverManager.getConnection("jdbc:odbc:maintable");
                                            st=con.createStatement();
                                            */

                                            //************************************************************************

                                                 MouseListener mouseListener = new MouseAdapter() {
                                                 public void mouseClicked(MouseEvent mouseEvent) {
                                                 JList jList1 = (JList) mouseEvent.getSource();
                                                if (mouseEvent.getClickCount() == 2) {
                                                  int index = jList1.locationToIndex(mouseEvent.getPoint());
                                                if (index >= 0) {
                                                Object o = jList1.getModel().getElementAt(index);
                                                //System.out.println(">>" + ((o==null)? "null" : o.toString()) + " is selected.");

                                                String tatext=jTextArea1.getText();
                                                view v1=new view(o.toString());
                                                //System.out.println("Double-clicked on: " + o.toString());
                                                }
                                                }
                                                }
                                             };
                                                jList1.addMouseListener(mouseListener);
//                                                jButton2.setEnabled(false);
                                                this.setTitle(" OCGRR : Scheduler  ...");
                                                this.setLocation(new Point(100, 100));
                                                this.setSize(new Dimension(560, 550));
                                                this.setVisible(true);

                                                 toolkit = Toolkit.getDefaultToolkit();
                                                 timer = new Timer();
                                                 timer.scheduleAtFixedRate(new RemindTask(), 0, //initial delay
                                                 1 * 1000); //subsequent rate


                                        } // Constructor class closed ..........

//                                    public void startServer() {
//                                        try {
//                                            // Use localhost or 127.0.0.1 for testing
//                                            int portno = 8888;
//
//                                            ServerSocket ss = new ServerSocket(portno);
//                                            System.out.println("Server started...");
//
//                                            while (true) {
//                                                Socket s = ss.accept();
//                                                System.out.println("Client connected...");
//
//                                                // Handle the client connection in a separate thread
//                                                new Thread(new ClientHandler(s)).start();
//                                            }
//                                        } catch (IOException e) {
//                                            System.out.println("Server not started: " + e);
//                                        }
//                                    }

                                    public void startServer() {
                                        int portno = 8888;

                                        try (ServerSocket serverSocket = new ServerSocket(portno)) {
                                            System.out.println("Server started on port " + portno);

                                            while (true) {
                                                try {
                                                    Socket clientSocket = serverSocket.accept();
                                                    System.out.println("Client connected: " + clientSocket.getInetAddress());

                                                    // Handle the client connection in a separate thread
                                                    new Thread(new ClientHandler(clientSocket)).start();
                                                } catch (IOException e) {
                                                    System.out.println("Error accepting client connection: " + e);
                                                }
                                            }
                                        } catch (IOException e) {
                                            System.out.println("Server failed to start: " + e);
                                        }
                                    }

                                    private void addComponent(Container container,Component c,int x,int y,int width,int height)
                                                {
                                                    c.setBounds(x,y,width,height);
                                                    container.add(c);
                                                }

                                                    private void jList1_valueChanged(ListSelectionEvent e)
                                                    {
                                                    }

                                                    private void jButton1_actionPerformed(ActionEvent e)
                                                    {

                                                    }

                                                    private void jButton2_actionPerformed(ActionEvent e)
                                                    {
                                                        //System.out.println("\njButton2_actionPerformed(ActionEvent e) called.");
                                                        // TODO: Add any handling code here

                                                    }

                                                    private void jButton3_actionPerformed(ActionEvent e)
                                                    {
                                                        //System.out.println("\njButton3_actionPerformed(ActionEvent e) called.");
                                                        // TODO: Add any handling code here

                                                    }

                                                    private void jButton4_actionPerformed(ActionEvent e)
                                                    {
                                                        //System.out.println("\njButton4_actionPerformed(ActionEvent e) called.");
                                                        // TODO: Add any handling code here

                                                    }


                                class RemindTask extends TimerTask
                                  {
                                    public void run()
                                    {
                                       while (true)
                                      {

                                          sss=true;
                                          while (sss)
                                          {
                                             if (numWarningBeeps > 0)
                                             {
                                                long time = System.currentTimeMillis();
                                                if (time - scheduledExecutionTime() > 5)
                                                {
                                                  return;
                                                }
                                                //If it's not too late, beep.
                                              //  toolkit.beep();

                                                System.out.println("Beep!"+numWarningBeeps);

                                                numWarningBeeps--;
                                                userupdate();
                                              }
                                              else
                                              {
                                                // toolkit.beep();
                                                 System.out.println("Time's up!");
                                                  sss=false;
                                                  numWarningBeeps = 1;
                                                  schedule();
                                                  forward(v1);
                                                  userupdate();
                                                  break;
                                                //timer.cancel(); //Not necessary because we call System.exit
                                                //System.exit(0); //Stops the AWT thread (and everything else)
                                              }

                                            }// if closed
                                        } // run() closed

                                 }
                                 }
                                 public void userupdate()
                                     {
                                    Vector ft=new Vector();

                                        try
                                        {
                                            System.out.println(" Inside the user update .....");
                                            Connection con1=null;
                                            Class.forName("com.mysql.cj.jdbc.Driver");

                                            // Establish a connection
                                            String url = "jdbc:mysql://localhost:3307/maintable";
                                            String username = "root";
                                            String password = "root";
                                             con1 = DriverManager.getConnection(url, username, password);
                                            System.out.println("database connected");



                                            Statement st1=con1.createStatement();
                                            String app="SELECT * FROM userlist";
                                            ResultSet rs=st1.executeQuery(app);

                                            while(rs.next())
                                            {
//                                                System.out.println(" Inside the TABLE .....");
                                                String name=rs.getString(1);
                                                ft.add(name);
//                                                System.out.println(ft);
                                            }

                                                    //Thread.sleep(10000);



                                        }
                                        catch (Exception eee)
                                        {
                                            System.out.println(" Could not get The table values...."+eee);
                                        }


                                        jList1.setListData(ft);
                                                            //


                                     }

                                public void forward(Vector v2)
                                {
                                    try
                                    {
                                    int tr;
                                    String v2e;
                                     System.out.println(" Inside the forward function ...\n\n");
                                     int v2size=v2.size();
                                     //System.out.println(" Total vector size : "+v2size);
                                     Socket sock;
                                     for(tr=0;tr<v2size;tr++)
                                     {
                                        v2e=(String)v2.elementAt(tr);
                                        //System.out.println(" v2 Vector : "+tr+" : "+v2e);

                                        StringTokenizer tokens = new StringTokenizer(v2e,"#");


                                                    while(tokens.hasMoreTokens())
                                                    {
                                                        //System.out.println(tokens.nextToken());
                                                        srcname=tokens.nextToken();
                                                        desname=tokens.nextToken();
                                                        msgtime=tokens.nextToken();
                                                        smesg=tokens.nextToken();
                                                        state=tokens.nextToken();

                                                        //System.out.println(" Total vector elements"+srcname+"/"+desname+"/"+msgtime+"/"+smesg+"/"+state);
                                                        //System.out.println("******************** Enter in loop**********************************************************");


                                                        //-------------------------------send to destination on here ---------------
                                                            try
                                                            {

                                                                sock=new Socket((desname.trim()),1234);//socket pgm for data transfer from router to destination
                                                                   ObjectOutputStream oost=new ObjectOutputStream(sock.getOutputStream());
                                                                all=srcname+" : "+smesg;
                                                                System.out.println(" All :"+all);
                                                                //Thread.sleep(1000);
                                                                System.out.println("FORWARD MSG :"+all);
                                                                if(state.equals("active"))
                                                                {
                                                                oost.writeObject(all);
                                                                }
                                                                else
                                                                {
                                                                }
                                                            }
                                                            catch (Exception e2)
                                                            {
                                                                System.out.println(e2);
                                                            }


                                                        //-------------------------------------------------------------------------

                                                        //Thread.sleep(1000);





                                                        //System.out.println(" Delete Query : "+tr +" :  "+app);
                                                    }

                                     }
                                    v1.removeAllElements();
                                    v2.removeAllElements();
                                    }
                                    catch (Exception eeeqw)
                                    {
                                        System.out.println(eeeqw);
                                    }

                                    v1.removeAllElements();
                                    v2.removeAllElements();

                                }

                                public void schedule()
                                {
                                    try
                                    {
                                        Class.forName("com.mysql.cj.jdbc.Driver");

                                        // Establish a connection
                                        String url = "jdbc:mysql://localhost:3307/maintable";
                                        String username = "root";
                                        String password = "root";
                                       Connection con1 = DriverManager.getConnection(url, username, password);
                                        System.out.println("database connected");
                                        Statement st1=con1.createStatement();
                                        /*String app="SELECT * FROM userlist";
                                        ResultSet rs=st1.executeQuery(app);*/

//                                        System.out.println(" Schedule table is opening.**********..");

                                        Thread.sleep(2000);

                                        //-----------Table datas are placed on here Before Sorting-----------------------------

                                        //-----------After sorting the order-----------------------------
                                        //v1.removeAllElements();
                                        //v2.removeAllElements();

                                            String hh="HIGH";
                                            String app="SELECT * FROM maintable where type like '"+hh+"' order by design";
                                            ResultSet rs=st1.executeQuery(app);
                                            //System.out.println(" Query : "+app);

                                            while(rs.next())
                                            {
                                                System.out.println(" <- Inside the High loop ->  ");
                                                String src = rs.getString(1);
                                                String dest = rs.getString(2);
                                                String time = rs.getString(3);
                                                String msg =rs.getString(4);
                                                String stt =rs.getString(5);
                                                String info = src+"#"+dest+"#"+time+"#"+msg+"#"+stt;
                                                System.out.println(" <- Schedule Performing HIGH ->  "+info);
                                                if(stt.equals("active"))
                                                {
                                                  v1.addElement(info);
                                                  jTextArea1.setText(jTextArea1.getText()+"\n"+info);
                                                  app="delete FROM maintable where stime like '"+time+"' and sourcename like '"+src+"' ";
                                                  st1.executeUpdate(app);
                                                }


                                            }



                                             hh="MEDIUM";
                                              app="SELECT * FROM maintable where type like '"+hh+"' order by design";

                                        //System.out.println(app);
                                         rs=st1.executeQuery(app);

                                            while(rs.next())
                                            {
                                                String src = rs.getString(1);
                                                String dest = rs.getString(2);
                                                String time = rs.getString(3);
                                                String msg =rs.getString(4);
                                                String stt =rs.getString(5);
                                                String info = src+"#"+dest+"#"+time+"#"+msg+"#"+stt;
                                                System.out.println(" <- Schedule Performing NORMAL ->  "+info);
                                                if(stt.equals("active"))
                                                {
                                                  v1.addElement(info);
                                                  jTextArea1.setText(jTextArea1.getText()+"\n"+info);
                                                  app="delete FROM maintable where stime like '"+time+"' and sourcename like '"+src+"' ";
                                                  st1.executeUpdate(app);
                                                }
                                            }

                                            //--------------------------------------------------------------------
                                             //-----------After sorting the order-----------------------------
                                             hh="LOW";
                                              app="SELECT * FROM maintable where type like '"+hh+"' order by design";

                                        //System.out.println(app);
                                         rs=st1.executeQuery(app);

                                            while(rs.next())
                                            {
                                                String src = rs.getString(1);
                                                String dest = rs.getString(2);
                                                String time = rs.getString(3);
                                                String msg =rs.getString(4);
                                                String stt =rs.getString(5);
                                                String info = src+"#"+dest+"#"+time+"#"+msg+"#"+stt;
                                                System.out.println(" <- Schedule Performing LOW ->  "+info);
                                                if(stt.equals("active"))
                                                {
                                                  v1.addElement(info);
                                                  jTextArea1.setText(jTextArea1.getText()+"\n"+info);
                                                  app="delete FROM maintable where stime like '"+time+"' and sourcename like '"+src+"' ";
                                                  st1.executeUpdate(app);
                                                }
                                            }


                                    }
                                    catch (Exception e)
                                    {
                                        System.out.println(e);
                                    }
                                }
                                 public void deluser(String sname)
                                    {
                                        for(int uu=0;uu<i;uu++)
                                                {
                                                    if(name[uu].equals(sname))
                                                    {
                                                        //i--;
                                                        data.removeElementAt(uu);
                                                        i--;  //one user remove then automatically total user capacity reduced by 1 from the list
                                                        jList1.setListData(data);
                                                        //t1.start();
                                                        adduser("update");
                                                        //data.add(name);


                                                        break;

                                                    }
                                                }
                                    }

                                     public void adduser(String sname)
                                    {
                                         if(sname.equals("update"))
                                        {
                                             try
                                             {
                                                jList1.setListData(data);
                                                ois1=new ObjectOutputStream(cs1.getOutputStream());
                                                ois1.writeObject(data);

                                             }
                                             catch (Exception erw)
                                             {
                                                 System.out.println(" Inside Add User update : "+erw);
                                             }

                                        }
                                        else
                                        {
                                         if(i==0)
                                                {
                                                        name[i]=sname;
                                                        allname.add(sname);
                                                        System.out.println(" 	st=1;  name="+name[i]);
                                                        data.add(name[i]);
//                                                        data.add(sname);


                                                        i++;
                                                }
                                                else
                                                {
                                                    st1=0;
                                                        for(int y=0;y<i;y++)
                                                        {
                                                            if(((name[y].trim()).equals(sname.trim())))           //a   0   1  b    2  a
                                                            {
                                                                st1=0;
                                                                break;
                                                            }
                                                            else
                                                            {

                                                                System.out.println(" 	st="+st+"  name= "+name[y]+" res1= "+res1+" y= "+y+ " i= "+i);
                                                                st1=1;
                                                            }

                                                        }
                                                        if(st1==1)
                                                        {

                                                        name[i]=sname;
                                                        System.out.println(" 	st=1;  name="+name[i]);
                                                            data.add(name[i]);
                                                            allname.add(res1);
                                                        i++;
                                                        st1=0;
                                                        }
                                                }

                                        }// update else closed.........

                                                for(int r=0;r<i;r++)
                                                {
                                                    System.out.println(" Sys name : "+ r+"/"+i+" : "+ name[r]+"\n");
                                                }
                                                System.out.println("@"+data);
                                        //	}// if string is logout then not added in the userlist list.............
                                                jList1.setListData(data);
                                                model1.addElement(allname);
                                                        //}			System.out.println("--------------------------------------------- \n");
                                    }
                                    public static void main(String[] args) throws Exception
                                    {
//                                        JFrame.setDefaultLookAndFeelDecorated(true);
//                                         JDialog.setDefaultLookAndFeelDecorated(true);
                                         try
                                         {
//                                             UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                                         }
                                         catch (Exception ex)
                                         {
//                                             System.out.println("Failed loading L&F: ");
                                             System.out.println(ex);
                                         }

                                        //timer t=new timer(10);
                                         //  new dest();
                                        forward se=new forward();
//                                         se.adduser("s1");
                                        se.userupdate();
//                                        se.msg();
//                                         System.out.println(" Dest class called on here...\n\n");
//                                        forward server = new forward();
                                        se.startServer();
                                    }
                                }

