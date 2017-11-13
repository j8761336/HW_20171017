/**
 * Created by 20160117 on 2017/11/14.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MainFrame extends JFrame {
    private LoginFrame logframe = new LoginFrame();
    private JTextField jtf = new JTextField();
    private JButton jbtn[] = new JButton[12];
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = 300, height = 300, Scrwidth = dim.width, Scrheight = dim.height;
    private JPanel jpl = new JPanel(new GridLayout(4, 3, 3, 3));
    private Container cp;

    public MainFrame(LoginFrame log) {
        logframe = log;
        init();
    }

    private void init() {
        this.setBounds(Scrwidth / 2 - width / 2, Scrheight / 2 - height / 2, 300, 300);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainFrame.this.setVisible(false);
                logframe.setVisible(true);
            }
        });

        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(5, 5));
        cp.add(jtf, BorderLayout.NORTH);
        cp.add(jpl, BorderLayout.CENTER);
        jtf.setEditable(false);

        for (int i = 0; i < 10; i++) {
            jbtn[i] = new JButton();
            jpl.add(jbtn[i]);
            jbtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton jb = (JButton) e.getSource();
                    jtf.setText(jtf.getText() + jb.getText());
                }
            });
        }

        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            jbtn[i].setText(String.valueOf(rnd.nextInt(10)));

            boolean bl = false;
            for (int j = 0; j < i; j++) {
                if (jbtn[j].getText().equals(jbtn[i].getText())) {
                    bl = true;
                    break;
                }
            }
            if (bl == true) {
                i--;
                continue;
            }
        }

        jbtn[10] = new JButton(".");
        jbtn[11] = new JButton("Clear");
        jpl.add(jbtn[10]);
        jpl.add(jbtn[11]);

        jbtn[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText(jtf.getText() + ".");
            }
        });

        jbtn[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText("");
            }
        });
    }
}