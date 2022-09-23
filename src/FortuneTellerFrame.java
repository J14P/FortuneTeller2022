import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    JFrame frame;

    JPanel mainPnl;

    JPanel topPnl;
    JPanel midPnl;
    JPanel botPnl;

    JLabel label;

    JTextArea textArea;

    JScrollPane scrollPane;

    JButton readBtn;
    JButton quitBtn;

    ImageIcon icon;

    int index = 0;
    int lastIndex = 0;
    int count = 0;

    ArrayList list;

    Random random;

    public FortuneTellerFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        mainPnl.setBorder(new TitledBorder(new EtchedBorder(), ""));

        createTopPnl();
        createMidPnl();
        createBotPnl();

        mainPnl.add(topPnl, BorderLayout.NORTH);
        mainPnl.add(midPnl, BorderLayout.CENTER);
        mainPnl.add(botPnl, BorderLayout.SOUTH);

        add(mainPnl);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(screenWidth / 4, screenHeight / 4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void createTopPnl()
    {
        topPnl = new JPanel();
        topPnl.setPreferredSize(new Dimension(100,300));
        label = new JLabel("Fortune Teller");
        icon = new ImageIcon("src/fortune teller.jpg", null);

        label.setIcon(icon);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.NORTH);
        label.setFont(new Font("Times New Roman", Font.PLAIN, 50));

        topPnl.add(label);
    }

    private void createMidPnl()
    {
        midPnl = new JPanel();
        midPnl.setLayout(new GridLayout(1,1));
        midPnl.setBorder(new TitledBorder(new EtchedBorder(), ""));
        textArea = new JTextArea(10, 50);
        textArea.setFont(new Font("Courier", Font.ITALIC, 20));
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        midPnl.add(scrollPane);

    }

    private void createBotPnl()
    {
        botPnl = new JPanel();
        botPnl.setLayout(new GridLayout(1,2));
        botPnl.setBorder(new TitledBorder(new EtchedBorder(), ""));
        botPnl.setPreferredSize(new Dimension(50,50));
        readBtn = new JButton("Read my Fortune!");
        readBtn.setFont(new Font("Arial", Font.BOLD, 36));
        quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font("Arial", Font.BOLD, 36));

        quitBtn.addActionListener((ActionEvent e) -> {System.exit(0);});
        readBtn.addActionListener((ActionEvent e) -> {getFortune();});

        botPnl.add(readBtn);
        botPnl.add(quitBtn);
    }

    private void getFortune()
    {
        list = new ArrayList<String>(12);
        random = new Random();

        list.add("You will win ONE MILLION DOLLARS!");
        list.add("You will pass all of your classes!");
        list.add("Your crush will ask you out!");
        list.add("Your grandpa will beat cancer!");
        list.add("You will end world hunger!");
        list.add("You will get a raise!");
        list.add("You will win a brand new car!");
        list.add("You will find ONE HUNDRED DOLLARS on the ground!");
        list.add("You will become invincible!");
        list.add("You will meet the president!");
        list.add("Your car will have brand new tires!");
        list.add("Your grandma will make you cookies!");

        while (index == lastIndex)
        {
            index = random.nextInt(0 + (list.size()-1)+0);
        }
        lastIndex = index;
        count++;
        textArea.append("Your Fortune is: " + list.get(index) + "\n");

    }
}
