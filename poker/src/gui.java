import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gui extends JFrame{
    private JFrame frame;
    private JPanel mainPanel;

    private JPanel leftPanel;
    private JPanel middlePanel;
    private JPanel rightPanel;
    private JPanel bank;
    private JPanel bankHand;
    private JPanel userHand;

    private JLabel moneyLabel;
    private JLabel bankCard1;
    private JLabel bankCard2;
    private JLabel bankCard3;
    private JLabel bankCard4;
    private JLabel bankCard5;
    private JLabel test6;
    private JLabel test7;
    private JLabel test8;
    private JLabel test9;

    private Color backgroundColor = new Color(30, 100, 0);
    private Color buttonColor = new Color(0, 50, 0);
    private Color warningColor = new Color(200, 40, 0);
    private Color textColor = new Color(255, 255, 180);

    private ImageIcon icon = new ImageIcon("shell.jpg");

    private final int width;
    private final int height;

    public gui (int width, int height){
        frame = new JFrame("GUI Demo");
        mainPanel = new JPanel(new GridLayout(1, 3));

        leftPanel = new JPanel(new GridLayout(3, 1));
        leftPanel.setBackground(backgroundColor);
        middlePanel = new JPanel(new GridLayout(2, 1));
        middlePanel.setSize(900, height);
        rightPanel = new JPanel(new GridLayout(3, 1));
        rightPanel.setSize(280, height);

        bank = new JPanel(new BorderLayout());
        bankHand = new JPanel(new GridLayout(1, 5));
        userHand = new JPanel(new GridLayout(1, 2));

        moneyLabel = new JLabel(Integer.toString(Main.money));

        bankCard1 = new JLabel("bank first card");
        bankCard2 = new JLabel("bank second card");
        bankCard3 = new JLabel("bank third card");
        bankCard4 = new JLabel("bank fourth card");
        bankCard5 = new JLabel("bank fifth card");
        test6 = new JLabel("test6");
        test7 = new JLabel("test7");
        test8 = new JLabel("test8");
        test9 = new JLabel("test9");

        this.width = width;
        this.height = height;
    }

    public void setUpGUI(){
        frame.setSize(width, height);
        frame.add(mainPanel);
        frame.setResizable(false);
        frame.setIconImage(icon.getImage());

        leftPanel.add(test8);
        leftPanel.add(test8);
        leftPanel.add(test9);

        bankHand.add(bankCard1);
        bankHand.add(bankCard2);
        bankHand.add(bankCard3);
        bankHand.add(bankCard4);
        bankHand.add(bankCard5);

        bank.add(bankHand, BorderLayout.CENTER);

        middlePanel.add(bank);
        middlePanel.add(userHand);

        rightPanel.add(test9);
        rightPanel.add(test6);
        rightPanel.add(test7);

        mainPanel.add(leftPanel);
        mainPanel.add(middlePanel);
        mainPanel.add(rightPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setUpButtonListener(JButton button, Runnable outting){
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                outting.run();
            }
        };

        button.addActionListener(buttonListener);
    }

    public void out1(){
        System.out.println("oha");
    }
}
