//main

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private final JTextArea fortuneArea;
    private final ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // sizing
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width * 3 / 4;
        int height = screenSize.height * 3 / 4;
        setSize(width, height);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // top of the panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setBackground(Color.BLACK); // Set background color

        // loading image
        ImageIcon originalIcon = new ImageIcon("images/fortune_teller.jpg"); // Use .png if needed
        Image image = originalIcon.getImage().getScaledInstance(1000, 750, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);

        JLabel titleLabel = new JLabel("Your Fortune Awaits...", icon, JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 55));
        titleLabel.setForeground(Color.WHITE); // Make title text white
        titleLabel.setHorizontalTextPosition(JLabel.CENTER); // Text below image
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);

        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        // text area
        fortuneArea = new JTextArea(10, 40);
        fortuneArea.setFont(new Font("SansSerif", Font.BOLD, 38));  // Bigger font size
        fortuneArea.setForeground(Color.WHITE);  // White text
        fortuneArea.setBackground(Color.BLACK);  // Black background
        fortuneArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(fortuneArea);
        add(scrollPane, BorderLayout.CENTER);

        // buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBackground(Color.BLACK); // Set background color

        JButton fortuneButton = new JButton("Read My Fortune!");
        fortuneButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        fortuneButton.setBackground(Color.BLACK);
        fortuneButton.setForeground(Color.WHITE);

        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        quitButton.setBackground(Color.BLACK);
        quitButton.setForeground(Color.WHITE);

        bottomPanel.add(fortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        //fortune list
        fortunes = new ArrayList<>();
        fortunes.add("You will have a great day today!");
        fortunes.add("A surprise gift is on its way to you.");
        fortunes.add("Your hard work will soon pay off.");
        fortunes.add("Expect good news from a friend.");
        fortunes.add("Something you lost will soon be found.");
        fortunes.add("An exciting opportunity is coming your way.");
        fortunes.add("Trust your instincts—they will lead you right.");
        fortunes.add("You will soon meet someone who will change your life.");
        fortunes.add("A great adventure awaits you!");
        fortunes.add("Happiness is closer than you think.");
        fortunes.add("The answer you seek is within you.");
        fortunes.add("Your creativity will bring you success.");
        fortunes.add("Your efforts will soon be recognized and rewarded.");
        fortunes.add("An old friend will reach out with exciting news.");
        fortunes.add("A fresh start is coming your way—embrace it.");
        fortunes.add("The universe is aligning in your favor.");
        fortunes.add("An unexpected encounter will bring happiness.");
        fortunes.add("Your confidence will open new doors.");
        fortunes.add("Big changes are ahead, but they will lead to growth.");
        fortunes.add("You will soon be surrounded by positive energy.");
        fortunes.add("A long-awaited answer will finally arrive.");
        fortunes.add("Your generosity will return to you in unexpected ways.");
        fortunes.add("A fun adventure awaits—say yes to new experiences.");
        fortunes.add("Believe in yourself, and others will too.");
        fortunes.add("You will accomplish something you once thought impossible.");
        fortunes.add("Good fortune is heading your way—be ready!");
        fortunes.add("The path you choose will lead to great success.");
        fortunes.add("You are about to make a meaningful connection.");
        fortunes.add("Happiness is not far—it’s already within you.");
        fortunes.add("A secret admirer will reveal their feelings.");
        fortunes.add("Your determination will bring you closer to your dreams.");
        fortunes.add("You will discover a hidden talent within yourself.");
        fortunes.add("Exciting changes in your career are on the horizon.");
        fortunes.add("You are about to experience a period of great joy.");
        fortunes.add("A financial opportunity will present itself soon.");
        fortunes.add("A heartfelt conversation will bring clarity.");
        fortunes.add("Your positive energy will attract wonderful experiences.");
        fortunes.add("Something you’ve been waiting for is just around the corner.");
        fortunes.add("A small risk will lead to a big reward.");
        fortunes.add("You will gain wisdom from an unexpected source.");
        fortunes.add("The next chapter of your life will be your best yet.");
        fortunes.add("A simple act of kindness will change your day.");
        fortunes.add("You will soon cross paths with someone inspiring.");
        fortunes.add("The support you need will come when you least expect it.");
        fortunes.add("A long-standing question will finally be answered.");
        fortunes.add("Your intuition is guiding you toward something wonderful.");
        fortunes.add("You will soon celebrate a big achievement.");
        fortunes.add("A lucky break is coming your way.");
        fortunes.add("A peaceful and fulfilling moment is on the horizon.");
        fortunes.add("Your resilience will lead to something great.");
        fortunes.add("The effort you put in now will bring lasting rewards.");
        fortunes.add("You will soon be part of something truly special.");
        fortunes.add("A new perspective will change everything for the better.");

        // java 8 expressions ---
        fortuneButton.addActionListener(e -> displayNewFortune());
        quitButton.addActionListener(e -> System.exit(0));
    }

    private void displayNewFortune() {
        Random rand = new Random();
        int newIndex;
        do {
            newIndex = rand.nextInt(fortunes.size());
        } while (newIndex == lastFortuneIndex);

        lastFortuneIndex = newIndex;
        fortuneArea.append(fortunes.get(newIndex) + "\n");
    }
}
