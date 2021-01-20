package Day1;

import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;

public class TextCounter extends JFrame {

    public TextCounter() {
        this.setLayout(new FlowLayout());

        JTextArea wordsTextArea = new JTextArea(20, 40);

        JScrollPane scrollPane = new JScrollPane(wordsTextArea);
        JButton countWordsButton = new JButton("Words");
        JButton countCharsButton = new JButton("Character");

        countWordsButton.addActionListener(actionEvent -> {
            String text = wordsTextArea.getText();
            JOptionPane.showMessageDialog(null, "Total words: " + new StringTokenizer(text).countTokens());
        });

        countCharsButton.addActionListener(actionEvent -> {
            String text = wordsTextArea.getText();

            JOptionPane.showMessageDialog(null, "Total chars: " + text.replaceAll("\n","").length());
        });

        add(scrollPane, BorderLayout.CENTER);
        add(wordsTextArea, BorderLayout.CENTER);
        add(countWordsButton, BorderLayout.SOUTH);
        add(countCharsButton, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        TextCounter ui = new TextCounter();
        ui.setSize(600, 400);
        ui.setTitle("Text Counter");
        ui.setResizable(true);
        ui.setVisible(true);
        ui.setLocationRelativeTo(null);
    }
}
