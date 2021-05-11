
import java.awt.*;
import java.awt.event.*;

public class App extends Frame implements WindowListener, ActionListener {
        TextField text = new TextField(20);
        Button b;
        private int numClicks = 0;

        public static void main(String[] args) {
                App myWindow = new App("My first window");
                myWindow.setSize(350,100);
                myWindow.setVisible(true);
        }

        public App(String title) {

                super(title);
                setLayout(new FlowLayout());
                addWindowListener(this);
                b = new Button("Click me");
                
                add(b);
                add(text);
                b.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
                numClicks++;
                text.setText("Button Clicked " + numClicks + " times");
        }

        public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
        }

        public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}

}

/*import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App extends JFrame implements ActionListener {
 
    // JFrame
    static JFrame f;
 
    // JButton
    static JButton b1, b2, b3;
 
    // label to display text
    static JLabel l;
    int numClicks = 0;

    // main class
    public static void main(String[] args) 
    {
        // create a new frame to store text field and button
        f = new JFrame("Gilman Analysis");
 
        // create a label to display text
        l = new JLabel("ayo go team");
 
        // create a new buttons
        b1 = new JButton("button1");
        b2 = new JButton("button2");
        b3 = new JButton("button3");
        
        // create a panel to add buttons
        JPanel p = new JPanel();
 
        // add buttons and textfield to panel
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(l);
 
        // setbackground of panel
        Color backg = Color.cyan;
        p.setBackground(backg);

        // add panel to frame
        f.add(p);
 
        // set the size of frame
        f.setSize(300, 300);
        
        f.show();
    }
}

*/