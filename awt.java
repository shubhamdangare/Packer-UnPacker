import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
//  combine /home/shubham/Desktop/packer2/test

 // target  /home/shubham/Desktop/javap/demosssss

class writeobj implements Serializable
{
	
	public String name;
	public long size;
}

////////////////////////////////////////////////////////////////////////////////////////////////////


class Images extends Frame implements Runnable{
    static Image img;
    Images(){
        // load image into image object
        img = Toolkit.getDefaultToolkit().getImage("/home/shubham/Desktop/javap/demo.jpeg");
        // wait till image load intoo img objext for that use MediaTracker
        MediaTracker track = new MediaTracker(this);
        track.addImage(img,0);
        try{
            // let jvm wait till image isloaded completely
            track.waitForID(0);
        }
        catch(Exception e){
            System.out.println("Image not loaded");
        }
    }

    public void paint(Graphics g){
        // display image in 50 50 pixels
        g.drawImage(img,50,50,100,100,null);
        run();
    }


    public void run(){
            /// create Frame object
       // Frame fobj = new Frame("Marvellous");
       // fobj.setSize(400,400);
       /* 
        Images i = new Images();
        i.setSize(400,400);
        i.setVisible(true);
        */
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent w)
            {
                System.exit(0);
            }
		});
        //fobj.setVisible(true);
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            System.out.println("Error in  1 window");
        }
       // i.setVisible(false);
        setVisible(false);
     }  
}


////////////////////////////////////////////////////////////////////////////////////////////////////


class Frame1 extends Thread
{
        // start the thread
        public void run(){
            /// create Frame object
        Frame fobj = new Frame("Marvellous");
        fobj.setSize(400,400);
       /* 
        Images i = new Images();
        i.setSize(400,400);
        i.setVisible(true);
        */
         fobj.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent w)
            {
                System.exit(0);
            }
		});
        fobj.setVisible(true);
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            System.out.println("Error in  1 window");
        }
       // i.setVisible(false);
        fobj.setVisible(false);
     }   
}


////////////////////////////////////////////////////////////////////////////////////////////////////


class Frame2 extends JFrame implements ActionListener
{
    JTextField f1,f2;
    JLabel l3;
    static int cnt = 3;
        public Frame2(){
        
         this.setLayout(null);
         this.setContentPane(new JLabel(new ImageIcon("/home/shubham/Desktop/javap/demo.jpeg")));
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent w)
            {
                System.exit(0);
            }
		});
        JLabel l1 = new JLabel("UserName");
        JLabel l2 = new JLabel("Password");
        l3 = new JLabel("attempt 3");
        JButton b1 = new JButton("Enter");
        JButton b2 = new JButton("Cancel");

        f1 = new JTextField();
        f2 = new JTextField();
        l1.setBounds(100,100,70,40);
        l2.setBounds(100,160,70,40);
        b1.setBounds(100,200,70,40);
        f1.setBounds(200,100,70,40);
        f2.setBounds(200,160,70,40);
       // f2.setEchoChar('*');
        l3.setBounds(250,250,100,40);

        b2.setBounds(200,200,70,40);        
        this.add(l1);
        this.add(l3);
        this.add(l2);
        this.add(f1);
        this.add(f2);
        this.add(b1);
        this.add(b2);
        b1.addActionListener(this);
        //fobj.setVisible(true);
     } 
         public void actionPerformed(ActionEvent e){
            
            
           // Graphics g = this.getGraphics();
           // g.drawString("attempts remaing are :"+cnt,200,350);
            
            if(f1.getText().equals("admin") && f2.getText().equals("admin")){    
            Frame3 fobj = new Frame3();
            fobj.start();
            }
            else{
                cnt--;
                l3.setText("attempt"+cnt);
            }

            if(cnt==0){
                System.exit(0);
            }   
           
            
         }
      
}


////////////////////////////////////////////////////////////////////////////////////////////////////


class Frame3 extends Frame implements ActionListener
{
    int icnt=1;
    Label l2;
        public Frame3(){

        
        
        this.setSize(400,400);
        this.setLayout(null);
         addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent w)
            {
                System.exit(0);
            }
		});
        Label l1 = new Label("Packer and UnPacker",Label.CENTER);
        Button b1 = new Button("Packer");
        Button b2 = new Button("UnPacker");
        l2 = new Label();
        l1.setSize(100,100);
        l1.setBounds(50,70,130,130);
        l2.setBounds(250,50,60,60);
        b1.setBounds(100,200,70,40);
        b2.setBounds(200,200,70,40);  
        this.add(l1);
        this.add(b1);
        this.add(b2);
        this.add(l2);
       b1.setActionCommand("Packer");
       b2.setActionCommand("UnPacker");
       
       b1.addActionListener(this);
       b2.addActionListener(this);
       
        this.setVisible(true);
     } 

    int sec=0;
    Timer mytimer = new Timer();
    TimerTask task = new TimerTask(){
        public void run(){
            sec++;
            l2.setText("Timer"+sec);
        }
    };
    void start(){
    mytimer.scheduleAtFixedRate(task,1000,1000);
    }

    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if(command.equals("Packer")){
             Frame4 fobj = new Frame4();
            fobj.setSize(400,400);
             fobj.setVisible(true);
        }
        else if(command.equals("UnPacker")){

             Frame5 fobj = new Frame5();
            fobj.setSize(400,400);
             fobj.setVisible(true);


        }
         }  
}



////////////////////////////////////////////////////////////////////////////////////////////////////


class Frame5 extends Frame implements ActionListener
{
    TextField f1,f2;
        public Frame5(){
        
         this.setLayout(null);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent w)
            {
                System.exit(0);
            }
		});
        Label l1 = new Label("FileName");
        Label l2 = new Label("Directory TO");

        Button b1 = new Button("Unpack");

        f1 = new TextField();
        f2 = new TextField();
        l1.setBounds(100,100,70,40);
        l2.setBounds(100,160,70,40);
        b1.setBounds(100,200,70,40);
        f1.setBounds(200,100,70,40);
        f2.setBounds(200,160,70,40);        
        this.add(l1);
        this.add(l2);
        this.add(f1);
        this.add(f2);
        this.add(b1);
        b1.addActionListener(this);

     } 
         public void actionPerformed(ActionEvent e){
            
            String filename = f1.getText();
            //System.out.println(name);
            String dire = f2.getText();

    try
    {

	    //Scanner sc = new Scanner(System.in);
	   
        //System.out.println("enter file name");
         //String str=sc.nextLine();
        File fil=new File(filename);
        String filecontain;
        int length;
		int ch;
               if(fil.isFile())
                 {
                 
                   FileReader fread=new FileReader(filename);
                   BufferedReader  bread=new BufferedReader(fread);     
                    //System.out.println("enter the folder name to unzip");
                    //String folder=sc.next();
                    File dir=new File(dire);
                        if(dir.mkdir()==true)
                            {
			                        System.out.println("creadeted");			
			                      }
			                  else{
			                        System.out.println("not creadeted");			
			                      }
                    length=0;
                    filecontain="";
                   
                        while((ch=bread.read())>0)
                          {
                            length++;    
                            filecontain=filecontain+(char)ch;                         
                              if(length==50)
                                 {
                                     String[] Header=filecontain.split(" ");
                                                   
                                      filecontain="";
                                      String name=dire+"/"+Header[0];      
                                      FileWriter fwrite=new FileWriter(name);
                                      BufferedWriter bwrite=new BufferedWriter(fwrite);
                                                  
                                      int j=Integer.parseInt(Header[1].trim());

			                          //byte[] buffer = new byte[1024];
                                      for(int i=0;i<j;i++)
                                      {
                                          filecontain=filecontain+(char)(bread.read());
                                       }
    
                                       bwrite.write(filecontain);
                                       bwrite.close();
                                       fwrite.close();
                                       length=0;
                                       filecontain="";
                                  }                               
                          }
               }      
       }

        catch(Exception exf){
            System.out.println("error while unzip"+exf);
            }
           
    }
      
}


////////////////////////////////////////////////////////////////////////////////////////////////////

class Frame4 extends Frame implements ActionListener
{
    TextField f1,f2;
        public Frame4(){
        
         this.setLayout(null);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent w)
            {
                System.exit(0);
            }
		});
        Label l1 = new Label("Directory");
        Label l2 = new Label("TargetFile");

        Button b1 = new Button("Pack");

        f1 = new TextField();
        f2 = new TextField();
        l1.setBounds(100,100,70,40);
        l2.setBounds(100,160,70,40);
        b1.setBounds(100,200,70,40);
        f1.setBounds(200,100,70,40);
        f2.setBounds(200,160,70,40);        
        this.add(l1);
        this.add(l2);
        this.add(f1);
        this.add(f2);
        this.add(b1);
        b1.addActionListener(this);

     } 
         public void actionPerformed(ActionEvent e){
            
            String fnname = f1.getText();
            //System.out.println(name);
            String fname = f2.getText();

                   
        try{

        	
             File folder = new File(fnname);
         
             File[] files = folder.listFiles();
             FileOutputStream fobj = new FileOutputStream(fname);

        //BufferedOutputStream bwr = new BufferedOutputStream(new FileOutputStream("/home/shubham/Desktop/packer2/demo.txt"));
 	    
       //  BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("/home/shubham/Desktop/packer2/demo.txt")));
 	    
          	 int ch;
		
		
		     for (File file : files) 
        	  {
			
            	StringBuffer sb = new StringBuffer(50);
				//sb.ensureCapacity(50);
	    		if (file.isFile())
            	{  
				
                   String str = file.getName();
		           long i =file.length();		
		            sb.append(str);
                    sb.append(" ");
                    sb.append(i);
		
		            int len = sb.length();
		            for(int z=0;z<(50-len);z++)
		            {
                      sb.append(" ");
	            	}
				
                	System.out.println(len);
				    str = sb.toString();
				    fobj.write(str.getBytes());
				
			    	String name = file.getAbsolutePath();

				    byte[] buffer = new byte[1024];

				    FileInputStream fre = new FileInputStream(name);;
				    while((ch = fre.read(buffer))!=-1){
					//System.out.print((char)ch);
					    fobj.write(buffer,0,ch);
				    }
			    
				}
			
              }
            
	        }
	            catch(Exception ex)
	            {
		            System.out.println(ex);
	            }	                   
            finally{
                Frame3 f3 = new Frame3();

            }
            
         }
      
}



////////////////////////////////////////////////////////////////////////////////////////////////////


class MainWindow
{
    public static void main(String args[]) throws Exception{
        Frame1 f1 = new Frame1();

        Images i = new Images();
        i.setSize(400,400);
        i.setVisible(true);

        //Thread tobj = new Thread(i);
        //tobj.start();
        
            Thread.sleep(1000);
        
        
        //tobj.join();
        Frame2 f2 = new Frame2();
        f2.setSize(400,400);
        f2.setVisible(true);
        //Frame3  f3 = new Frame3();
        //f3.start();
    }

}
