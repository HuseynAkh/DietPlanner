import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodPanel extends JPanel {

    private boolean breakfastChosen = false;
    private boolean lunchChosen = false;
    private boolean dinnerChosen = false;
    private float servings;
    private boolean chosen = false;
    private JTextPane caloriesWeight;
    private JTextField numberOfServings;
    private JButton addButton;
    private JPanel actualPanel;
    private JComboBox addTo;
    private JTextArea detailedInformation;
    private JPanel upPanel;
    private JPanel downPanel;
    private JTextArea basicInformation;

    public boolean isChosen() {
        return chosen;
    }
    public void setBreakfastChosen(boolean breakfastChosen) {
        this.breakfastChosen = breakfastChosen;
    }
    public void setLunchChosen(boolean lunchChosen) {
        this.lunchChosen = lunchChosen;
    }
    public void setDinnerChosen(boolean dinnerChosen) {
        this.dinnerChosen = dinnerChosen;
    }
    public boolean isBreakfastChosen() {
        return breakfastChosen;
    }
    public boolean isLunchChosen() {
        return lunchChosen;
    }
    public boolean isDinnerChosen() {
        return dinnerChosen;
    }
    public float getServings() {
        return servings;
    }
    public JPanel getActualPanel() {
        return actualPanel;
    }
    public JTextArea getBasicInformation() {
        return basicInformation;
    }
    public JTextArea getDetailedInformation() {
        return detailedInformation;
    }
    public JTextPane getCaloriesWeight() {
        return caloriesWeight;
    }
    public JTextField getNumberOfServings() {
        return numberOfServings;
    }

    //Once AddButton is pressed
    //Detects which meal has been chosen and tracks the desired number of servings
    public FoodPanel() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chosenSetting = (String) addTo.getSelectedItem();
                if (chosenSetting.equals("Breakfast")){
                breakfastChosen = true;

                }
                if (chosenSetting.equals("Lunch")){
                lunchChosen = true;
                }

                if (chosenSetting.equals("Dinner")){
                dinnerChosen = true;
                }
                servings = Float.parseFloat(numberOfServings.getText());
        };
    });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chosen = true;
            }
        });
    }




    private void createUIComponents() {

    }

    public void NullComboBox(){
        addTo.setSelectedItem(null);
    }

    //Adding meals to ComboBox and changing appearance
    public void initialize(){
        addTo.addItem("Breakfast");
        addTo.addItem("Lunch");
        addTo.addItem("Dinner");
        addTo.setSelectedItem(null);

        upPanel.setOpaque(true);
        downPanel.setOpaque(true);

        upPanel.setBackground(Color.BLACK);
        downPanel.setBackground(Color.BLACK);
    }

}

