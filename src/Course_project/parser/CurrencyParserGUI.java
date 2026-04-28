package Course_project.parser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyParserGUI {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Парсер курсов валют");
            frame.setSize(800,600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JTextField currencyField = new JTextField(10);
            JButton parseButton = new JButton("Получить курсы");
            parseButton.setPreferredSize(new Dimension(150, 40));
            //parseButton.setMargin(new Insets(10, 20, 10, 20));
            JTextArea resultArea = new JTextArea(15,40);
            resultArea.setEditable(false);
            resultArea.setFont(new Font("Menlo", Font.PLAIN, 16));
            JScrollPane scrollPane = new JScrollPane(resultArea);

            JPanel topPanel = new JPanel();
            topPanel.add(new JLabel("Код валюты (USD, EUR, all):"));
            topPanel.add(currencyField);
            topPanel.add(parseButton);

            frame.add(topPanel, BorderLayout.NORTH);
            frame.add(scrollPane, BorderLayout.CENTER);

            parseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String userInput = currencyField.getText().trim();
                    if (userInput.isEmpty()) {
                        resultArea.setText("Введите код валюты или all");
                        return;
                    }

                    String result = CurrencyParser.parseAndCompare(userInput);

                    resultArea.setText("Вы ввели: " + result);
                }
            });

            frame.setVisible(true);
        });

    }
}
