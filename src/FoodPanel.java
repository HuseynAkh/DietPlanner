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

    public float getServings() {
        return servings;
    }

    public void setServings(float servings) {
        this.servings = servings;
    }

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


    public JPanel getActualPanel() {
        return actualPanel;
    }

    public void setActualPanel(JPanel actualPanel) {
        this.actualPanel = actualPanel;
    }

    public JComboBox getAddTo() {
        return addTo;
    }

    public void setAddTo(JComboBox addTo) {
        this.addTo = addTo;
    }


    private JPanel actualPanel;

    private JComboBox addTo;



    public JTextArea getBasicInformation() {
        return basicInformation;
    }

    public void setBasicInformation(JTextArea basicInformation) {
        this.basicInformation = basicInformation;
    }

    private JTextArea basicInformation;

    public JTextArea getDetailedInformation() {
        return detailedInformation;
    }

    public void setDetailedInformation(JTextArea detailedInformation) {
        this.detailedInformation = detailedInformation;
    }

    private JTextArea detailedInformation;
    private JPanel upPanel;
    private JPanel downPanel;

    public JTextPane getCaloriesWeight() {
        return caloriesWeight;
    }

    public void setCaloriesWeight(JTextPane caloriesWeight) {
        this.caloriesWeight = caloriesWeight;
    }

    private JTextPane caloriesWeight;
    private JTextField numberOfServings;
    private JButton addButton;

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getNumberOfServings() {
        return numberOfServings;
    }

    public void foodPanelStart() {
        basicInformation.setText("Hello");
    }

    private void createUIComponents() {

    }

    public void NullComboBox(){
        addTo.setSelectedItem(null);
    }

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

