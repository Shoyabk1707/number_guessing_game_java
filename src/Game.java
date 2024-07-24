import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game{
    
    public static String n;
    
    // Chances of player
    public static int count = 5;
    
    // Generate random number
    public  int comp = (int)(Math.random() * 10);

    Game() {

        
        JFrame f0 = new JFrame();
        f0.setBounds(500, 250, 200, 150);
        f0.setLayout(null);
        f0.setResizable(false);
        f0.setDefaultCloseOperation(f0.EXIT_ON_CLOSE);

        JFrame f = new JFrame();
        f.setBounds(500, 80, 415, 600);
        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

        // FRAME for name
        JLabel name = new JLabel("Enter your name");
        name.setBounds(40, 10, 100, 20);
        f0.add(name);

        JTextField namet = new JTextField();
        namet.setBounds(40, 40, 100, 20);
        f0.add(namet);

        JButton submit = new JButton("submit");
        submit.setBounds(50, 70, 80, 20);
        f0.add(submit);

        f0.setVisible(true);

        // Main Frame Coponents
        JLabel wel = new JLabel();
        wel.setBounds(10, 10, 150, 20);
        wel.setForeground(Color.WHITE);
        wel.setFont(new Font("ARIAL", Font.BOLD, 15));
        f.add(wel);

        // It displays how many chances left to the player
        JLabel C_label = new JLabel("Chance Left : ");
        C_label.setBounds(260, 10, 150, 20);
        C_label.setForeground(Color.WHITE);
        C_label.setFont(new Font("ARIAL", Font.BOLD, 15));
        f.add(C_label);

        JLabel c_left = new JLabel("");
        c_left.setBounds(370, 10, 40, 20);
        c_left.setForeground(Color.WHITE);
        c_left.setFont(new Font("ARIAL", Font.BOLD, 15));
        c_left.setText(String.valueOf(count));
        f.add(c_left);

        // You can edit if according to you
        JLabel desc = new JLabel("<HTML>Choose a number between 1 to 10 </HTML>");
        desc.setBounds(50, 130, 300, 200);
        desc.setForeground(Color.WHITE);
        desc.setFont(new Font("ARIAL", Font.BOLD, 35));
        f.add(desc);

        // User input textfield
        JTextField user_t = new JTextField();
        user_t.setBounds(100, 450, 200, 30);
        user_t.setFont(new Font("ARIAL", Font.BOLD, 20));
        f.add(user_t);

        // Enter Button
        ImageIcon enter_img = new ImageIcon("Images/enter.png");
        JButton enter = new JButton(enter_img);
        enter.setBounds(150, 500, 100, 30);
        enter.setBorderPainted(false);
        enter.setOpaque(false);
        enter.setContentAreaFilled(false);
        f.add(enter);

        // Background  : Background code should be at last so that all the other components wil be vsible
        ImageIcon bg = new ImageIcon("Images/bg.jpg");
        JLabel bgl = new JLabel(bg);
        bgl.setBounds(0, 0, 400, 600);
        f.add(bgl);


        // ACTION LISTENER

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                f0.setVisible(false);
                wel.setText("Welcome , " + namet.getText());
                f.setVisible(true);

            }
        });

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int user = Integer.parseInt(user_t.getText());

                if (user == comp) {
                    int result = JOptionPane.showConfirmDialog(f, "Hurray You win\n Restart", "Restart", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        count = 6;
                        user_t.setText(null);
                        f.setVisible(false);
                        Game g = new Game();
                    }
                    if (result == JOptionPane.NO_OPTION) {
                        f.setVisible(false);
                    }
                }

                if (user > comp) {
                    JOptionPane.showMessageDialog(f, "Too High ! Please Choose a Low Number");
                    user_t.setText(null);
                }
                if (user < comp) {
                    JOptionPane.showMessageDialog(f, "Too Low ! Please Choose a High Number");
                    user_t.setText(null);
                }

                count--;

                c_left.setText(String.valueOf(count));

                if (count == 0) {
                    JOptionPane.showMessageDialog(f, "OOPS ! You loose.");
                    f.setVisible(false);
                    f0.setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {

       Game g = new Game();
    }
}
