import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MarvellousUnPackFront extends Template  implements ActionListener{



    JLabel label1,label2,title;
    JButton SUBMIT,PREVIOUS;
    final JTextField text1;


        public MarvellousUnPackFront(){

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            
            title = new JLabel("UnPacking-Portal ");
            Dimension size = title.getPreferredSize();
            title.setBounds(40,50,size.width+60,size.height);
            title.setFont(new Font("Century",Font.BOLD,17));
            title.setForeground(Color.blue);



            label1 = new JLabel();
            label1.setText("File name");
            label1.setBounds(350,50,size.width+60,size.height);
            label1.setForeground(Color.white);


            text1 = new JTextField(15);
            Dimension tsize = text1.getPreferredSize();
            text1.setBounds(500,50,tsize.width,tsize.height);
            text1.setToolTipText("Enter name of Directory");
                

            SUBMIT = new JButton("Extract Here");
            Dimension bsize = SUBMIT.getPreferredSize();
            SUBMIT.setBounds(350,200,bsize.width,bsize.height);
            SUBMIT.addActionListener(this);


            PREVIOUS = new JButton("PREVIOUS");
            Dimension b2size = PREVIOUS.getPreferredSize();
            PREVIOUS.setBounds(500,200,b2size.width,b2size.height);
            PREVIOUS.addActionListener(this);


            _header.add(title);
            _content.add(label1);
            _content.add(text1);
            _content.add(SUBMIT);
            _content.add(PREVIOUS);

                this.setSize(1000,400);
                this.setResizable(false);
                this.setVisible(true);
                text1.requestFocusInWindow();

    }


            public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==exit){
                this.setVisible(false);
                System.exit(0);
            }
            if(ae.getSource() == minimize){
                setState(JFrame.ICONIFIED);
            }


            if(ae.getSource() == SUBMIT){

        
                try{
                    MarvellousUnpack obj = new MarvellousUnpack(text1.getText());
                    this.dispose();
                 NextPage t = new NextPage("Admin");
                }
                catch(Exception e){

                }
            }
            if(ae.getSource() == PREVIOUS){
                this.setVisible(false);
                this.dispose();
                NextPage t = new NextPage("Admin");
                    
            }
        }


}