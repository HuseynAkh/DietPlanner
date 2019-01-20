import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class GUI {
    private JTextField input;
    private JButton searchFood;
    private JButton searchDish;
    private JTextField breakfastTextField;
    private JTextField lunchTextField;
    private JTextField dinnerTextField;
    private FoodPanel panel;
    private JPanel newPanel;

    Meal breakfast = new Meal();
    Meal lunch = new Meal();
    Meal dinner = new Meal();


    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    private JPanel mainPanel;
    private JPanel displayPanel;
    private JScrollPane scrollPanel;
    private JTextArea breakfText;
    private JTextArea breakCalCount;
    private JTextArea lunchText;
    private JTextArea lunchCalCount;
    private JTextArea dinnerText;
    private JTextArea dinnerCalCount;
    private boolean done = false;

    private Reader reader = new Reader();
    private ArrayList<JPanel> panelList = new ArrayList<JPanel>();


    private FoodPanel panel1 = new FoodPanel();
    private FoodPanel panel2 = new FoodPanel();
    private FoodPanel panel3 = new FoodPanel();
    private FoodPanel panel4 = new FoodPanel();
    private FoodPanel panel5 = new FoodPanel();
    private FoodPanel panel6 = new FoodPanel();
    private FoodPanel panel7 = new FoodPanel();
    private FoodPanel panel8 = new FoodPanel();
    private FoodPanel panel9 = new FoodPanel();
    private FoodPanel panel10 = new FoodPanel();


    public void start(){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setTitle("DietPlanner");
        frame.setVisible(true);
        displayPanel.setLayout(new GridLayout(10,1));
    }

    public GUI() {
        searchDish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Clear Display
                done = false;

                panel = null;
                newPanel = null;
                panelList.clear();
                displayPanel.removeAll();
                reader.foodList.clear();
                displayPanel.revalidate();



                String in = input.getText();
                reader.findDish(in);


                for (int i = 0; i <= reader.foodList.size(); i++) {
                    panel = new FoodPanel();
                    panel.setLayout(new BorderLayout());
                    panel.initialize();
                    DecimalFormat df = new DecimalFormat("#.##");
                    panel.getBasicInformation().setText("  " + reader.getFoodList().get(i).getLabel());
                    panel.getCaloriesWeight().setText(" Calories: " + df.format(reader.getFoodList().get(i).getCalories()) + " Weight: " + df.format(reader.getFoodList().get(i).getWeight()));
                    panel.getDetailedInformation().setText("  C: " + df.format(reader.getFoodList().get(i).getCarb()) + "g   P: " + df.format(reader.getFoodList().get(i).getProtein()) + "g   F: " + df.format(reader.getFoodList().get(i).getFat()));
                    newPanel = panel.getActualPanel();
                    panelList.add(newPanel);
                    displayPanel.add(panel.getActualPanel());
                    displayPanel.revalidate();
                    displayPanel.repaint();
                    displayPanel.revalidate();
                }
                done = true;


            }
        });
    }

//    public void panelSetting(){
//        while (done == true) {
//
//        }
//    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}