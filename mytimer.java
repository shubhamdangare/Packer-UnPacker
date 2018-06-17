import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

class tim{

    
    int icnt=1;
    Label l2;
    public tim(){
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
}

class demo{
    public static void main(String arg[]){
        tim t = new tim();
        t.start();
    }
}