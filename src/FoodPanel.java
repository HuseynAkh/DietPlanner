import javax.swing.*;

public class FoodPanel extends JPanel {

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
    private JTextPane information;

    public void foodPanelStart() {
        information.setText("Hello");
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
