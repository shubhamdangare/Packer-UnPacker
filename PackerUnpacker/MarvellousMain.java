import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.io.Serializable;
import java.awt.Dimension;
import javax.swing.JLabel;

class MarvellousLogin extends Template implements ActionListener,Serializable,Runnable{


    JLabel label1,label2,label3,TopLabel;
    JButton SUBMIT;
    final JTextField text1,text2;

        MarvellousLogin(){

            TopLabel = new JLabel();
            TopLabel.setHorizontalAlignment(SwingConstants.CENTER);

            TopLabel.setText("Marvellous Packer And UnPacker : Login");
            TopLabel.setForeground(Color.BLUE);
             
            Dimension topsize = TopLabel.getPreferredSize();
            TopLabel.setBounds(50,40,topsize.width,topsize.height);
          _header.add(TopLabel);


            label1 = new JLabel();
            label1.setText("UserName");
            label1.setForeground(Color.white);


            Dimension size = label1.getPreferredSize();
            label1.setBounds(50,135,size.width,size.height);
            label1.setHorizontalAlignment(SwingConstants.CENTER);
          
            text1 = new JTextField(15);
            Dimension tsize = text1.getPreferredSize();
            text1.setBounds(200,135,tsize.width,tsize.height);
            text1.setToolTipText("Enetr Username");

            label2 = new JLabel();
            label2.setText("Password");
            label2.setForeground(Color.white);
            label1.setBounds(50,175,size.width,size.height);
            label1.setHorizontalAlignment(SwingConstants.CENTER);
          
            text2 = new JPasswordField(15);
            text2.setBounds(200,175,tsize.width,tsize.height);
            text2.setToolTipText("Enetr Password");
            text2.addFocusListener(new FocusAdapter(){
                public void focusedGained(FocusEvent ef){}
                public void focusLost(FocusEvent e){
                    label3.setText("");
                }
            });


            SUBMIT = new JButton("SUBMIT");
            SUBMIT.setHorizontalAlignment(SwingConstants.CENTER);

            Dimension ssize = SUBMIT.getPreferredSize();
            SUBMIT.setBounds(50,220,ssize.width,ssize.height);

                label3 = new JLabel();
                label3.setText("");
                Dimension l3size = label3.getPreferredSize();
                label3.setForeground(Color.RED);
                label3.setBounds(50,250,l3size.width,l3size.height);

                Thread t = new Thread(this);
                t.start();

                _content.add(label1);
                _content.add(text1);
                _content.add(label2);
                _content.add(text2);
                _content.add(SUBMIT);
                pack();
                validate();
                ClockHome();

                setSize(500,500);
                //this.setResizable(false);
                this.setVisible(true);
                setLocationRelativeTo(null);

            SUBMIT.addActionListener(this);

        }


        public void actionPerformed(ActionEvent ae){
        
        String value1 = text1.getText();
        String value2 = text2.getText();

            if(ae.getSource()==exit){
                this.setVisible(false);
                System.exit(0);
            }
            if(ae.getSource() == minimize){
                setState(JFrame.ICONIFIED);
            }


            if(ae.getSource() == SUBMIT){
                    //if(value1.equals("q") && value2.equals("q")){
                        NextPage page = new NextPage(value1);
                        this.setVisible(false);
                        page.pack();
                        page.setVisible(true);
                        page.setSize(500,500);
                   // }
                   // else{
                       // JOptionPane.showMessageDialog(this,"Inncorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
                    //}
                
            }
           
         }


        public void run(){
            for(;;){
                if(text2.isFocusOwner()){
                    if(Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)){
                        text2.setToolTipText("Warning:Caps Lock is On");
                    }
                    else{
                        text2.setToolTipText("");
                    }
        
                }
            }
        }

}

class MarvellousMain{
    public static void main(String arg[]){
        try{
            MarvellousLogin fname = new MarvellousLogin();
            fname.setVisible(true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}
