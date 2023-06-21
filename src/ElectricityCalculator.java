import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.NumberFormat;
public class ElectricityCalculator {
    private JFrame frame;
    private JTextField currentField, previousField;
    private JLabel resultLabel, wellltLabel;
    private JRadioButton moscowRadio, spbRadio, belgorodRadio, voronezhRadio;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ElectricityCalculator window = new ElectricityCalculator();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ElectricityCalculator() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(475, 275, 450, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel currentLabel = new JLabel("Текущие показатели:");
        currentLabel.setBounds(10, 11, 126, 14);
        frame.getContentPane().add(currentLabel);

        currentField = new JTextField();
        currentField.setBounds(146, 8, 150, 20);
        frame.getContentPane().add(currentField);
        currentField.setColumns(10);

        JLabel previousLabel = new JLabel("Прошлые показатели:");
        previousLabel.setBounds(10, 36, 126, 14);
        frame.getContentPane().add(previousLabel);

        previousField = new JTextField();
        previousField.setBounds(146, 33, 150, 20);
        frame.getContentPane().add(previousField);
        previousField.setColumns(10);

        ButtonGroup citiesGroup = new ButtonGroup();

        moscowRadio = new JRadioButton("Москва");
        moscowRadio.setBounds(10, 68, 109, 23);
        moscowRadio.setSelected(true);
        frame.getContentPane().add(moscowRadio);
        citiesGroup.add(moscowRadio);

        spbRadio = new JRadioButton("Питер");
        spbRadio.setBounds(121, 68, 109, 23);
        frame.getContentPane().add(spbRadio);
        citiesGroup.add(spbRadio);

        belgorodRadio = new JRadioButton("Белгород");
        belgorodRadio.setBounds(232, 68, 109, 23);
        frame.getContentPane().add(belgorodRadio);
        citiesGroup.add(belgorodRadio);

        voronezhRadio = new JRadioButton("Воронеж");
        voronezhRadio.setBounds(343, 68, 109, 23);
        frame.getContentPane().add(voronezhRadio);
        citiesGroup.add(voronezhRadio);

        JButton calculateButton = new JButton("Рассчитать");
        calculateButton.setBounds(150, 100, 150, 25);
        frame.getContentPane().add(calculateButton);
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int current = Integer.parseInt(currentField.getText());
                int previous = Integer.parseInt(previousField.getText());
                int difference = current - previous;
                double multiplier = 0;
                if (moscowRadio.isSelected()) {
                    multiplier = 4.33;

                } else if (spbRadio.isSelected()) {
                    multiplier = 6.51;
                } else if (belgorodRadio.isSelected()) {
                    multiplier = 3.43;
                } else if (voronezhRadio.isSelected()) {
                    multiplier = 4.85;
                }
                double result = difference * multiplier;
                NumberFormat nf = NumberFormat.getInstance();
                nf.setMaximumFractionDigits(2);
                String formattedResult = nf.format(result);
                resultLabel.setText(formattedResult);
            }
        });
        resultLabel = new JLabel("");
        resultLabel.setBounds(10, 141, 414, 14);
        frame.getContentPane().add(resultLabel);
    }
}