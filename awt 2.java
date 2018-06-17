import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

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

class Frame2 extends Frame implements ActionListener
{
    TextField f1,f2;
    Label l3;
    static int cnt = 3;
        public Frame2(){
        
         this.setLayout(null);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent w)
            {
                System.exit(0);
            }
		});
        Label l1 = new Label("UserName");
        Label l2 = new Label("Password");
        l3 = new Label("attempt 3");
        Button b1 = new Button("Enter");
        Button b2 = new Button("Cancel");

        f1 = new TextField();
        f2 = new TextField();
        l1.setBounds(100,100,70,40);
        l2.setBounds(100,160,70,40);
        b1.setBounds(100,200,70,40);
        f1.setBounds(200,100,70,40);
        f2.setBounds(200,160,70,40);
        f2.setEchoChar('*');
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

class Frame3 implements ActionListener
{
    int icnt=1;
    Label l2;
        public Frame3(){

        Frame fobj = new Frame("Marvellous Frame 3");
        
        fobj.setSize(400,400);
        fobj.setLayout(null);
         fobj.addWindowListener(new WindowAdapter()
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
        fobj.add(l1);
        fobj.add(b1);
        fobj.add(b2);
        fobj.add(l2);
        b1.addActionListener(this);
        b1.addActionListener(this);
        fobj.setVisible(true);
     } 

    int sec=0;
    Timer mytimer = new Timer();
    TimerTask task = new TimerTask(){
        public void run(){
            sec++;
            l2.setText(""+sec);
        }
    };
    void start(){
    mytimer.scheduleAtFixedRate(task,1000,1000);
    }

         public void actionPerformed(ActionEvent e){
             
         }  
}







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
    }

}
