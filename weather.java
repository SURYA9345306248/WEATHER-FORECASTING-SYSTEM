import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class CityWeatherForecastingSystem extends JFrame {
private static final long serialVersionUID = 1L;
private JTextField cityInput;
private JTextArea displayArea;
private JButton generateButton;
public CityWeatherForecastingSystem() {
setTitle("City Weather Forecasting System");
setSize(500, 400);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE;
setLocationRelativeTo(null);
cityInput = new JTextField(20);
displayArea = new JTextArea();
displayArea.setEditable(false);
displayArea.setLineWrap(true);
displayArea.setWrapStyleWord(true);
JScrollPane scrollPane = new JScrollPane(displayArea);
generateButton = new JButton("Generate Weather for City");
generateButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
generateWeatherDataForCity();
}
});
JPanel inputPanel = new JPanel();
inputPanel.add(new JLabel("Enter City Name:"));
inputPanel.add(cityInput);
inputPanel.add(generateButton);
setLayout(new BorderLayout());
add(inputPanel, BorderLayout.NORTH);
add(scrollPane, BorderLayout.CENTER);
}
private void generateWeatherDataForCity() {
String city = cityInput.getText().trim();
if (city.isEmpty()) {
JOptionPane.showMessageDialog(this, "Please enter a city
name.", "Error", JOptionPane.ERROR_MESSAGE);
return;
}
Random random = new Random();
String[] conditions = {"Sunny", "Rainy", "Cloudy", "Stormy",
"Windy"};
String condition =
conditions[random.nextInt(conditions.length)];
int temperature = random.nextInt(41) - 10;
String data = "City: " + city + "\nCondition: " + condition +
"\nTemperature: " + temperature + "°C\n";
displayArea.append(data + "\n");
}

public static void main(String[] args) {

SwingUtilities.invokeLater(new Runnable() {

@Override
public void run() {
CityWeatherForecastingSystem frame = new
CityWeatherForecastingSystem();
frame.setVisible(true);
}
});
}
}
