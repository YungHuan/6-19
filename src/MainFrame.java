import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JTextArea ta1 =new JTextArea();
    private JTextArea ta2 =new JTextArea();
    private ScrollPane scp1 =new ScrollPane();
    private ScrollPane scp2 =new ScrollPane();
    private Container cp;
    private JPanel jp2 =new JPanel(new GridLayout(4,1,1,1));
    private JLabel jl1 =new JLabel("");
    private JButton jb1 =new JButton("Change");
    private JButton jb2 =new JButton("Exit");
    private JPasswordField jpw =new JPasswordField();
    public MainFrame(){
        init();
    }
    public void init(){
        this.setBounds(500,500,500,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        cp =this.getContentPane();
        cp.add(scp1, BorderLayout.WEST);
        cp.add(jp2, BorderLayout.CENTER);
        cp.add(scp2, BorderLayout.EAST);
        jp2.add(jl1);
        jp2.add(jpw);
        jp2.add(jb1);
        jp2.add(jb2);
        scp1.add(ta1);
        scp2.add(ta2);

//        char v1='a' ,key='k';
//        String str =ta1.getText();
//        String password =jpw.getPassword().toString();
//        int l =str.length();

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldstr =ta1.getText();
                String key =new String(jpw.getPassword());
                String newstr ="";
                char []c =oldstr.toCharArray();
                char []p =key.toCharArray();
                for (int i=0;i<oldstr.length();i++){
                    int j =i%key.length();

                    int r =(int) c[j]^(int)p[j];
                    newstr =newstr+r;
                    ta2.setText(newstr);
                }
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
