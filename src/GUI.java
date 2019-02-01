import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class GUI {
    private JTextField input;
    private JButton searchDish;
    private JTextField breakfastTextField;
    private JTextField lunchTextField;
    private JTextField dinnerTextField;
    private FoodPanel panel;
    private JPanel newPanel;
    private int breakfastRefreshMealNum = 0;
    private int lunchRefreshMealNum = 0;
    private int dinnerRefreshMealNum = 0;
    private double completeCalCount = 0;



    private JPanel mainPanel;
    private JPanel displayPanel;
    private JScrollPane scrollPanel;
    private JTextArea breakfText;
    private JTextArea breakCalCount;
    private JTextArea lunchText;
    private JTextArea lunchCalCount;
    private JTextArea dinnerText;
    private JTextArea dinnerCalCount;
    private JButton done;
    private JPanel searchingJPanel;
    private JTextArea totalCountField;

    private Reader reader = new Reader();
    private ArrayList<JPanel> panelList = new ArrayList<JPanel>();


    private FoodPanel panel0 = new FoodPanel();
    private FoodPanel panel1 = new FoodPanel();
    private FoodPanel panel2 = new FoodPanel();
    private FoodPanel panel3 = new FoodPanel();
    private FoodPanel panel4 = new FoodPanel();
    private FoodPanel panel5 = new FoodPanel();
    private FoodPanel panel6 = new FoodPanel();
    private FoodPanel panel7 = new FoodPanel();
    private FoodPanel panel8 = new FoodPanel();
    private FoodPanel panel9 = new FoodPanel();

    private Meal breakfast = new Meal();
    private Meal lunch = new Meal();
    private Meal dinner = new Meal();

    public void start() {

        //Basic Set-up of the GUI
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("DietPlanner");
        frame.setVisible(true);
        displayPanel.setLayout(new GridLayout(10, 1)); //layout for FoodPanels

        //initializing all the FoodPanels
        panel0 = new FoodPanel();
        panel0.setLayout(new BorderLayout());
        panel0.initialize();
        panel0.setVisible(false);

        panel1 = new FoodPanel();
        panel1.setLayout(new BorderLayout());
        panel1.initialize();
        panel1.setVisible(false);

        panel2 = new FoodPanel();
        panel2.setLayout(new BorderLayout());
        panel2.initialize();
        panel2.setVisible(false);

        panel3 = new FoodPanel();
        panel3.setLayout(new BorderLayout());
        panel3.initialize();
        panel3.setVisible(false);

        panel4 = new FoodPanel();
        panel4.setLayout(new BorderLayout());
        panel4.initialize();
        panel4.setVisible(false);

        panel5 = new FoodPanel();
        panel5.setLayout(new BorderLayout());
        panel5.initialize();
        panel5.setVisible(false);

        panel6 = new FoodPanel();
        panel6.setLayout(new BorderLayout());
        panel6.initialize();
        panel6.setVisible(false);

        panel7 = new FoodPanel();
        panel7.setLayout(new BorderLayout());
        panel7.initialize();
        panel7.setVisible(false);

        panel8 = new FoodPanel();
        panel8.setLayout(new BorderLayout());
        panel8.initialize();
        panel8.setVisible(false);

        panel9 = new FoodPanel();
        panel9.setLayout(new BorderLayout());
        panel9.initialize();
        panel9.setVisible(false);


        //Changing text size
        input.setFont(input.getFont().deriveFont(20f));
        breakCalCount.setFont(breakCalCount.getFont().deriveFont(20f));
        lunchCalCount.setFont(lunchCalCount.getFont().deriveFont(20f));
        dinnerCalCount.setFont(dinnerCalCount.getFont().deriveFont(20f));
        breakfText.setFont(breakfText.getFont().deriveFont(15f));
        lunchText.setFont(lunchText.getFont().deriveFont(15f));
        dinnerText.setFont(dinnerText.getFont().deriveFont(15f));
        breakfastTextField.setFont(breakfastTextField.getFont().deriveFont(15f));
        lunchTextField.setFont(lunchTextField.getFont().deriveFont(15f));
        dinnerTextField.setFont(dinnerTextField.getFont().deriveFont(15f));
        totalCountField.setFont(totalCountField.getFont().deriveFont(25f));

        scrollPanel.getVerticalScrollBar().setValue(0);

    }

    public GUI() {
        searchDish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startSearch();

            }
        });
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshButton();
            }
        });
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startSearch();


            }
        });
    }

    //Clearing the FoodPanels, searching for new dish, inserting new information into FoodPanels
    private void startSearch(){
        refreshButton();
        panel = null;
        newPanel = null;
        panelList.clear();
        displayPanel.removeAll();
        reader.getFoodList().clear();
        displayPanel.revalidate();


        String in = input.getText();
        reader.findDish(in);
        panelAdd();
        comboBoxRestart();
    }

    private void panelAdd() {

        int i = 0;

        DecimalFormat df = new DecimalFormat("#.##");

        panel0.getBasicInformation().setText("  " + reader.getFoodList().get(i).getLabel());
        panel0.getCaloriesWeight().setText(" Calories: " + df.format(reader.getFoodList().get(i).getInitialCalories()) + " Weight: " + df.format(reader.getFoodList().get(i).getWeight()) + "g");
        panel0.getDetailedInformation().setText("  C: " + df.format(reader.getFoodList().get(i).getCarb()) + "g   P: " + df.format(reader.getFoodList().get(i).getProtein()) + "g   F: " + df.format(reader.getFoodList().get(i).getFat()) + "g");
        panelList.add(panel0);
        displayPanel.add(panel0.getActualPanel());
        displayPanel.revalidate();
        displayPanel.repaint();
        displayPanel.revalidate();
        panel0.setVisible(true);

        i++;


        panel1.getBasicInformation().setText("  " + reader.getFoodList().get(i).getLabel());
        panel1.getCaloriesWeight().setText(" Calories: " + df.format(reader.getFoodList().get(i).getInitialCalories()) + " Weight: " + df.format(reader.getFoodList().get(i).getWeight()) + "g");
        panel1.getDetailedInformation().setText("  C: " + df.format(reader.getFoodList().get(i).getCarb()) + "g   P: " + df.format(reader.getFoodList().get(i).getProtein()) + "g   F: " + df.format(reader.getFoodList().get(i).getFat()) + "g");
        panelList.add(panel1);
        displayPanel.add(panel1.getActualPanel());
        displayPanel.revalidate();
        displayPanel.repaint();
        displayPanel.revalidate();
        panel1.setVisible(true);

        i++;


        panel2.getBasicInformation().setText("  " + reader.getFoodList().get(i).getLabel());
        panel2.getCaloriesWeight().setText(" Calories: " + df.format(reader.getFoodList().get(i).getInitialCalories()) + " Weight: " + df.format(reader.getFoodList().get(i).getWeight()) + "g");
        panel2.getDetailedInformation().setText("  C: " + df.format(reader.getFoodList().get(i).getCarb()) + "g   P: " + df.format(reader.getFoodList().get(i).getProtein()) + "g   F: " + df.format(reader.getFoodList().get(i).getFat()) + "g");
        panelList.add(panel2);
        displayPanel.add(panel2.getActualPanel());
        displayPanel.revalidate();
        displayPanel.repaint();
        displayPanel.revalidate();
        panel2.setVisible(true);

        i++;


        panel3.getBasicInformation().setText("  " + reader.getFoodList().get(i).getLabel());
        panel3.getCaloriesWeight().setText(" Calories: " + df.format(reader.getFoodList().get(i).getInitialCalories()) + " Weight: " + df.format(reader.getFoodList().get(i).getWeight()) + "g");
        panel3.getDetailedInformation().setText("  C: " + df.format(reader.getFoodList().get(i).getCarb()) + "g   P: " + df.format(reader.getFoodList().get(i).getProtein()) + "g   F: " + df.format(reader.getFoodList().get(i).getFat()) + "g");
        panelList.add(panel3);
        displayPanel.add(panel3.getActualPanel());
        displayPanel.revalidate();
        displayPanel.repaint();
        displayPanel.revalidate();
        panel3.setVisible(true);

        i++;


        panel4.getBasicInformation().setText("  " + reader.getFoodList().get(i).getLabel());
        panel4.getCaloriesWeight().setText(" Calories: " + df.format(reader.getFoodList().get(i).getInitialCalories()) + " Weight: " + df.format(reader.getFoodList().get(i).getWeight()) + "g");
        panel4.getDetailedInformation().setText("  C: " + df.format(reader.getFoodList().get(i).getCarb()) + "g   P: " + df.format(reader.getFoodList().get(i).getProtein()) + "g   F: " + df.format(reader.getFoodList().get(i).getFat()) + "g");
        panelList.add(panel4);
        displayPanel.add(panel4.getActualPanel());
        displayPanel.revalidate();
        displayPanel.repaint();
        displayPanel.revalidate();
        panel4.setVisible(false);

        i++;


        panel5.getBasicInformation().setText("  " + reader.getFoodList().get(i).getLabel());
        panel5.getCaloriesWeight().setText(" Calories: " + df.format(reader.getFoodList().get(i).getInitialCalories()) + " Weight: " + df.format(reader.getFoodList().get(i).getWeight()) + "g");
        panel5.getDetailedInformation().setText("  C: " + df.format(reader.getFoodList().get(i).getCarb()) + "g   P: " + df.format(reader.getFoodList().get(i).getProtein()) + "g   F: " + df.format(reader.getFoodList().get(i).getFat()) + "g");
        panelList.add(panel5);
        displayPanel.add(panel5.getActualPanel());
        displayPanel.revalidate();
        displayPanel.repaint();
        displayPanel.revalidate();
        panel5.setVisible(true);

        i++;


        panel6.getBasicInformation().setText("  " + reader.getFoodList().get(i).getLabel());
        panel6.getCaloriesWeight().setText(" Calories: " + df.format(reader.getFoodList().get(i).getInitialCalories()) + " Weight: " + df.format(reader.getFoodList().get(i).getWeight()) + "g");
        panel6.getDetailedInformation().setText("  C: " + df.format(reader.getFoodList().get(i).getCarb()) + "g   P: " + df.format(reader.getFoodList().get(i).getProtein()) + "g   F: " + df.format(reader.getFoodList().get(i).getFat()) + "g");
        panelList.add(panel6);
        displayPanel.add(panel6.getActualPanel());
        displayPanel.revalidate();
        displayPanel.repaint();
        displayPanel.revalidate();
        panel6.setVisible(true);

        i++;


        panel7.getBasicInformation().setText("  " + reader.getFoodList().get(i).getLabel());
        panel7.getCaloriesWeight().setText(" Calories: " + df.format(reader.getFoodList().get(i).getInitialCalories()) + " Weight: " + df.format(reader.getFoodList().get(i).getWeight()) + "g");
        panel7.getDetailedInformation().setText("  C: " + df.format(reader.getFoodList().get(i).getCarb()) + "g   P: " + df.format(reader.getFoodList().get(i).getProtein()) + "g   F: " + df.format(reader.getFoodList().get(i).getFat()) + "g");
        panelList.add(panel7);
        displayPanel.add(panel7.getActualPanel());
        displayPanel.revalidate();
        displayPanel.repaint();
        displayPanel.revalidate();
        panel7.setVisible(true);

        i++;


        panel8.getBasicInformation().setText("  " + reader.getFoodList().get(i).getLabel());
        panel8.getCaloriesWeight().setText(" Calories: " + df.format(reader.getFoodList().get(i).getInitialCalories()) + " Weight: " + df.format(reader.getFoodList().get(i).getWeight()) + "g");
        panel8.getDetailedInformation().setText("  C: " + df.format(reader.getFoodList().get(i).getCarb()) + "g   P: " + df.format(reader.getFoodList().get(i).getProtein()) + "g   F: " + df.format(reader.getFoodList().get(i).getFat()) + "g");
        panelList.add(panel8);
        displayPanel.add(panel8.getActualPanel());
        displayPanel.revalidate();
        displayPanel.repaint();
        displayPanel.revalidate();
        panel8.setVisible(true);

        i++;


        panel9.getBasicInformation().setText("  " + reader.getFoodList().get(i).getLabel());
        panel9.getCaloriesWeight().setText(" Calories: " + df.format(reader.getFoodList().get(i).getInitialCalories()) + " Weight: " + df.format(reader.getFoodList().get(i).getWeight()) + "g");
        panel9.getDetailedInformation().setText("  C: " + df.format(reader.getFoodList().get(i).getCarb()) + "g   P: " + df.format(reader.getFoodList().get(i).getProtein()) + "g   F: " + df.format(reader.getFoodList().get(i).getFat()) + "g");
        panelList.add(panel9);
        displayPanel.add(panel9.getActualPanel());
        displayPanel.revalidate();
        displayPanel.repaint();
        displayPanel.revalidate();
        panel9.setVisible(true);

        i++;
    }

    //Resetting the ComboBoxes for all FoodPanels
    private void comboBoxRestart() {
        panel0.NullComboBox();
        panel1.NullComboBox();
        panel2.NullComboBox();
        panel3.NullComboBox();
        panel4.NullComboBox();
        panel5.NullComboBox();
        panel6.NullComboBox();
        panel7.NullComboBox();
        panel8.NullComboBox();
        panel9.NullComboBox();


        panel0.getNumberOfServings().setText(null);
        panel1.getNumberOfServings().setText(null);
        panel2.getNumberOfServings().setText(null);
        panel3.getNumberOfServings().setText(null);
        panel4.getNumberOfServings().setText(null);
        panel5.getNumberOfServings().setText(null);
        panel6.getNumberOfServings().setText(null);
        panel7.getNumberOfServings().setText(null);
        panel8.getNumberOfServings().setText(null);
        panel9.getNumberOfServings().setText(null);
    }

    //Adds new meal to Breakfast and re-calculates Total Calories
    private void refreshMealBreakfast() {
        float count = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        float tempNum = breakfast.getTotalCalories();

        if (breakfastRefreshMealNum == 0) {
            breakfast.setToprint(breakfast.getFood().get(breakfastRefreshMealNum).getLabel() + " Number of servings: " + breakfast.getFood().get(breakfastRefreshMealNum).getMultiplierCalories() + " Calories: " + df.format(breakfast.getFood().get(breakfastRefreshMealNum).getMultiplierCalories() * breakfast.getFood().get(breakfastRefreshMealNum).getInitialCalories()));
            breakfText.setText(breakfast.getToprint());

            breakfastRefreshMealNum++;
        } else {
            breakfast.setToprint(breakfast.getToprint() + "\n" + breakfast.getFood().get(breakfastRefreshMealNum).getLabel() + " Number of servings: " + breakfast.getFood().get(breakfastRefreshMealNum).getMultiplierCalories() + " Calories: " + df.format(breakfast.getFood().get(breakfastRefreshMealNum).getMultiplierCalories() * breakfast.getFood().get(breakfastRefreshMealNum).getInitialCalories()) );
            breakfText.setText(breakfast.getToprint());

            breakfastRefreshMealNum++;
        }

        breakfast.calculateTotalCal();
        completeCalCount = completeCalCount + breakfast.getTotalCalories() - tempNum;
        breakCalCount.setText("Calories: " + df.format(breakfast.getTotalCalories()));
        totalCountField.setText("Calories: " + df.format(completeCalCount));

    }

    //Adds new meal to Lunch and re-calculates Total Calories
    private void refreshMealLunch() {
        float count = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        float tempNum = lunch.getTotalCalories();

        if (lunchRefreshMealNum == 0) {
            lunch.setToprint(lunch.getFood().get(lunchRefreshMealNum).getLabel() + " Number of servings: " + lunch.getFood().get(lunchRefreshMealNum).getMultiplierCalories() + " Calories: " + df.format(lunch.getFood().get(lunchRefreshMealNum).getMultiplierCalories() * lunch.getFood().get(lunchRefreshMealNum).getInitialCalories()));
            lunchText.setText(lunch.getToprint());

            lunchRefreshMealNum++;

        } else {
            lunch.setToprint(lunch.getToprint() + "\n" + lunch.getFood().get(lunchRefreshMealNum).getLabel() + " Number of servings: " + lunch.getFood().get(lunchRefreshMealNum).getMultiplierCalories() + " Calories: " + df.format(lunch.getFood().get(lunchRefreshMealNum).getMultiplierCalories() * lunch.getFood().get(lunchRefreshMealNum).getInitialCalories()));
            lunchText.setText(lunch.getToprint());

            lunchRefreshMealNum++;
        }
            lunch.calculateTotalCal();
            completeCalCount = completeCalCount + lunch.getTotalCalories() - tempNum;
            lunchCalCount.setText("Calories: " + df.format(lunch.getTotalCalories()));
            totalCountField.setText("Calories: " + df.format(completeCalCount));


    }

    //Adds new meal to Dinner and re-calculates Total Calories
    private void refreshMealDinner() {
        float count = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        float tempNum = dinner.getTotalCalories();

        if (dinnerRefreshMealNum == 0) {
            dinner.setToprint(dinner.getFood().get(dinnerRefreshMealNum).getLabel() + " Number of servings: " + dinner.getFood().get(dinnerRefreshMealNum).getMultiplierCalories() + " Calories: " + df.format(dinner.getFood().get(dinnerRefreshMealNum).getMultiplierCalories() * dinner.getFood().get(dinnerRefreshMealNum).getInitialCalories()));
            dinnerText.setText(dinner.getToprint());

            dinnerRefreshMealNum++;

        } else {
            dinner.setToprint(dinner.getToprint() + "\n" + dinner.getFood().get(dinnerRefreshMealNum).getLabel() + " Number of servings: " + dinner.getFood().get(dinnerRefreshMealNum).getMultiplierCalories() + " Calories: " + df.format(dinner.getFood().get(dinnerRefreshMealNum).getMultiplierCalories() * dinner.getFood().get(dinnerRefreshMealNum).getInitialCalories()));
            dinnerText.setText(dinner.getToprint());

            dinnerRefreshMealNum++;
        }

        dinner.calculateTotalCal();
        completeCalCount = completeCalCount + dinner.getTotalCalories() - tempNum;
        dinnerCalCount.setText("Calories: " + df.format(dinner.getTotalCalories()));
        totalCountField.setText("Calories: " + df.format(completeCalCount));

    }

    //Activated when pressing the "Done" button  or searching for new dish
    //Detects if there was a new meal added and takes appropriate actions
    private void refreshButton() {
        if (panel0.isChosen()) {

            if (panel0.isBreakfastChosen() == true) {
                breakfast.getFood().add(reader.getFoodList().get(0));
                breakfast.getFood().get(breakfastRefreshMealNum).setMultiplierCalories(panel0.getServings());
                refreshMealBreakfast();
                panel0.setBreakfastChosen(false);
            }

            if (panel0.isLunchChosen() == true) {
                lunch.getFood().add(reader.getFoodList().get(0));
                lunch.getFood().get(lunchRefreshMealNum).setMultiplierCalories(panel0.getServings());
                refreshMealLunch();
                panel0.setLunchChosen(false);
            }

            if (panel0.isDinnerChosen() == true) {
                dinner.getFood().add(reader.getFoodList().get(0));
                dinner.getFood().get(dinnerRefreshMealNum).setMultiplierCalories(panel0.getServings());
                refreshMealDinner();
                panel0.setDinnerChosen(false);
            }
        }

        if (panel1.isChosen()) {
            if (panel1.isBreakfastChosen() == true) {
                breakfast.getFood().add(reader.getFoodList().get(1));
                breakfast.getFood().get(breakfastRefreshMealNum).setMultiplierCalories(panel1.getServings());
                refreshMealBreakfast();
                panel1.setBreakfastChosen(false);
            }

            if (panel1.isLunchChosen() == true) {
                lunch.getFood().add(reader.getFoodList().get(1));
                lunch.getFood().get(lunchRefreshMealNum).setMultiplierCalories(panel1.getServings());
                refreshMealLunch();
                panel1.setLunchChosen(false);
            }

            if (panel1.isDinnerChosen() == true) {
                dinner.getFood().add(reader.getFoodList().get(1));
                dinner.getFood().get(dinnerRefreshMealNum).setMultiplierCalories(panel1.getServings());
                refreshMealDinner();
                panel1.setDinnerChosen(false);
            }

        }

        if (panel2.isChosen()) {
            if (panel2.isBreakfastChosen() == true) {
                breakfast.getFood().add(reader.getFoodList().get(2));
                breakfast.getFood().get(breakfastRefreshMealNum).setMultiplierCalories(panel2.getServings());
                refreshMealBreakfast();
                panel2.setBreakfastChosen(false);
            }

            if (panel2.isLunchChosen() == true) {
                lunch.getFood().add(reader.getFoodList().get(2));
                lunch.getFood().get(lunchRefreshMealNum).setMultiplierCalories(panel2.getServings());
                refreshMealLunch();
                panel2.setLunchChosen(false);
            }

            if (panel2.isDinnerChosen() == true) {
                dinner.getFood().add(reader.getFoodList().get(2));
                dinner.getFood().get(dinnerRefreshMealNum).setMultiplierCalories(panel2.getServings());
                refreshMealDinner();
                panel2.setDinnerChosen(false);
            }

        }

        if (panel3.isChosen()) {
            if (panel3.isBreakfastChosen() == true) {
                breakfast.getFood().add(reader.getFoodList().get(3));
                breakfast.getFood().get(breakfastRefreshMealNum).setMultiplierCalories(panel3.getServings());
                refreshMealBreakfast();
                panel3.setBreakfastChosen(false);
            }

            if (panel3.isLunchChosen() == true) {
                lunch.getFood().add(reader.getFoodList().get(3));
                lunch.getFood().get(lunchRefreshMealNum).setMultiplierCalories(panel3.getServings());
                refreshMealLunch();
                panel3.setLunchChosen(false);
            }

            if (panel3.isDinnerChosen() == true) {
                dinner.getFood().add(reader.getFoodList().get(3));
                dinner.getFood().get(dinnerRefreshMealNum).setMultiplierCalories(panel3.getServings());
                refreshMealDinner();
                panel3.setDinnerChosen(false);
            }

        }

        if (panel4.isChosen()) {
            if (panel4.isBreakfastChosen() == true) {
                breakfast.getFood().add(reader.getFoodList().get(4));
                breakfast.getFood().get(breakfastRefreshMealNum).setMultiplierCalories(panel4.getServings());
                refreshMealBreakfast();
                panel4.setBreakfastChosen(false);
            }

            if (panel4.isLunchChosen() == true) {
                lunch.getFood().add(reader.getFoodList().get(4));
                lunch.getFood().get(lunchRefreshMealNum).setMultiplierCalories(panel4.getServings());
                refreshMealLunch();
                panel4.setLunchChosen(false);
            }

            if (panel4.isDinnerChosen() == true) {
                dinner.getFood().add(reader.getFoodList().get(4));
                dinner.getFood().get(dinnerRefreshMealNum).setMultiplierCalories(panel4.getServings());
                refreshMealDinner();
                panel4.setDinnerChosen(false);
            }

        }

        if (panel5.isChosen()) {
            if (panel5.isBreakfastChosen() == true) {
                breakfast.getFood().add(reader.getFoodList().get(5));
                breakfast.getFood().get(breakfastRefreshMealNum).setMultiplierCalories(panel5.getServings());
                refreshMealBreakfast();
                panel5.setBreakfastChosen(false);
            }

            if (panel5.isLunchChosen() == true) {
                lunch.getFood().add(reader.getFoodList().get(5));
                lunch.getFood().get(lunchRefreshMealNum).setMultiplierCalories(panel5.getServings());
                refreshMealLunch();
                panel5.setLunchChosen(false);
            }

            if (panel5.isDinnerChosen() == true) {
                dinner.getFood().add(reader.getFoodList().get(5));
                dinner.getFood().get(dinnerRefreshMealNum).setMultiplierCalories(panel5.getServings());
                refreshMealDinner();
                panel5.setDinnerChosen(false);
            }

        }

        if (panel6.isChosen()) {
            if (panel6.isBreakfastChosen() == true) {
                breakfast.getFood().add(reader.getFoodList().get(6));
                breakfast.getFood().get(breakfastRefreshMealNum).setMultiplierCalories(panel6.getServings());
                refreshMealBreakfast();
                panel6.setBreakfastChosen(false);
            }

            if (panel6.isLunchChosen() == true) {
                lunch.getFood().add(reader.getFoodList().get(6));
                lunch.getFood().get(lunchRefreshMealNum).setMultiplierCalories(panel6.getServings());
                refreshMealLunch();
                panel6.setLunchChosen(false);
            }

            if (panel6.isDinnerChosen() == true) {
                dinner.getFood().add(reader.getFoodList().get(6));
                dinner.getFood().get(dinnerRefreshMealNum).setMultiplierCalories(panel6.getServings());
                refreshMealDinner();
                panel6.setDinnerChosen(false);
            }

        }

        if (panel7.isChosen()) {
            if (panel7.isBreakfastChosen() == true) {
                breakfast.getFood().add(reader.getFoodList().get(7));
                breakfast.getFood().get(breakfastRefreshMealNum).setMultiplierCalories(panel7.getServings());
                refreshMealBreakfast();
                panel7.setBreakfastChosen(false);
            }

            if (panel7.isLunchChosen() == true) {
                lunch.getFood().add(reader.getFoodList().get(7));
                lunch.getFood().get(lunchRefreshMealNum).setMultiplierCalories(panel7.getServings());
                refreshMealLunch();
                panel7.setLunchChosen(false);
            }

            if (panel7.isDinnerChosen() == true) {
                dinner.getFood().add(reader.getFoodList().get(7));
                dinner.getFood().get(dinnerRefreshMealNum).setMultiplierCalories(panel7.getServings());
                refreshMealDinner();
                panel7.setDinnerChosen(false);
            }

        }

        if (panel8.isChosen()) {
            if (panel8.isBreakfastChosen() == true) {
                breakfast.getFood().add(reader.getFoodList().get(8));
                breakfast.getFood().get(breakfastRefreshMealNum).setMultiplierCalories(panel8.getServings());
                refreshMealBreakfast();
                panel8.setBreakfastChosen(false);
            }

            if (panel8.isLunchChosen() == true) {
                lunch.getFood().add(reader.getFoodList().get(8));
                lunch.getFood().get(lunchRefreshMealNum).setMultiplierCalories(panel8.getServings());
                refreshMealLunch();
                panel8.setLunchChosen(false);
            }

            if (panel8.isDinnerChosen() == true) {
                dinner.getFood().add(reader.getFoodList().get(8));
                dinner.getFood().get(dinnerRefreshMealNum).setMultiplierCalories(panel8.getServings());
                refreshMealDinner();
                panel8.setDinnerChosen(false);
            }
        }

        if (panel9.isChosen()) {
            if (panel9.isBreakfastChosen() == true) {
                breakfast.getFood().add(reader.getFoodList().get(9));
                breakfast.getFood().get(breakfastRefreshMealNum).setMultiplierCalories(panel9.getServings());
                refreshMealBreakfast();
                panel9.setBreakfastChosen(false);
            }

            if (panel9.isLunchChosen() == true) {
                lunch.getFood().add(reader.getFoodList().get(9));
                lunch.getFood().get(lunchRefreshMealNum).setMultiplierCalories(panel9.getServings());
                refreshMealLunch();
                panel9.setLunchChosen(false);
            }

            if (panel9.isDinnerChosen() == true) {
                dinner.getFood().add(reader.getFoodList().get(9));
                dinner.getFood().get(dinnerRefreshMealNum).setMultiplierCalories(panel9.getServings());
                refreshMealDinner();
                panel9.setDinnerChosen(false);
            }
        }

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
