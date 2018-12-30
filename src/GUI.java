import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    private JTextField input;
    private JButton searchFood;
    private JButton searchDish;
    private JTextField breakfastTextField;
    private JTextField lunchTextField;
    private JTextField dinnerTextField;


    public void setDisplayPanel(JPanel displayPanel) {
        this.displayPanel = displayPanel;
    }

    private JPanel displayPanel;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    private JPanel mainPanel;

    Reader reader = new Reader();
    ArrayList<JPanel> panelList = new ArrayList<JPanel>();

    public void start(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public GUI() {
        searchDish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String in = input.getText();
                reader.findDish(in);
                displayPanel.setLayout(new GridLayout(10,1));

                for (int i = 0; i <= reader.foodList.size(); i++) {
                    FoodPanel panel = new FoodPanel();
                    panel.setLayout(new BorderLayout());
                    JPanel newPanel = panel.getActualPanel();
                    panelList.add(newPanel);
                    displayPanel.add(panelList.get(i), BorderLayout.CENTER);
                    displayPanel.revalidate();
                    displayPanel.repaint();


                }
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}

