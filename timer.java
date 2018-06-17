import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;


class TestPane  {
  Label label;
  int sec=0;
  Timer mytimer = new Timer();
  int count;
  TimerTask task = new TimerTask(){
        public void run(){
            sec++;
            System.out.println(sec);
        }
    };


    public TestPane(){
    Frame fobj = new Frame();
    fobj.setSize(400,400);
    fobj.add(label);
    fobj.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent w)
            {
                System.exit(0);
            }
            public void windowActivated(WindowEvent w)
            {
                
                start();
                label.setText("time"+sec);
            }
		});
    fobj.setVisible(true);
    }

    void start(){
    mytimer.scheduleAtFixedRate(task,1000,1000);
    }
} 

class Main {

  public static void main(String[] args) {
    TestPane t = new TestPane();
  }
}