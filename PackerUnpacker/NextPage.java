import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class NextPage extends Template  implements ActionListener{
    JLabel label;
    JButton pack,unpack;


        public NextPage(String value){

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            label = new JLabel("Welocme : "+value);
            Dimension size = label.getPreferredSize();
            label.setBounds(40,50,size.width+60,size.height);
            label.setFont(new Font("Century",Font.BOLD,17));
            label.setForeground(Color.blue);

            pack = new JButton("PACK");
            Dimension bsize = pack.getPreferredSize();
            pack.setBounds(100,100,bsize.width,bsize.height);
            pack.addActionListener(this);


            unpack = new JButton("UNPACK");
            Dimension b2size = pack.getPreferredSize();
            unpack.setBounds(300,100,b2size.width,b2size.height);
            unpack.addActionListener(this);


            _header.add(label);
            _content.add(pack);
            _content.add(unpack);
        
                ClockHome();
                this.setSize(500,450);
                this.setResizable(false);
                this.setVisible(true);

        }

        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==exit){
                this.setVisible(false);
                System.exit(0);
            }
            if(ae.getSource() == minimize){
                setState(JFrame.ICONIFIED);
            }


            if(ae.getSource() == pack){

                this.setVisible(false);
                try{
                    MarvellousPackFront obj = new MarvellousPackFront();
                }
                catch(Exception e){

                }
            }
            if(ae.getSource() == unpack){
                this.setVisible(false);
                try{
                    MarvellousUnPackFront obj = new MarvellousUnPackFront();
                }
                catch(Exception ef){

                }
            }
        }

}