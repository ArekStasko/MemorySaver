package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NewMemoryForm {
    private JFrame frame;
    private JLabel descriptionLabel;
    private JLabel dateLabel;
    private JTextField descriptionField;
    private JTextField dayField;
    private JTextField monthField;
    private JTextField yearField;
    private JButton confirmationButton;

    public NewMemoryForm(ActionListener onCloseHandler) {
        frame = new JFrame("New Memory");
        frame.setSize(400, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;

        descriptionLabel = new JLabel("Description:");
        descriptionField = new JTextField(200);

        dateLabel = new JLabel("Date:");
        dayField = new JTextField(10);
        monthField = new JTextField(10);
        yearField = new JTextField(10);
        confirmationButton = new JButton("Confirm");

        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(descriptionLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(descriptionField, c);

        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(dateLabel, c);

        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        datePanel.add(dayField);
        datePanel.add(new JLabel("/"));
        datePanel.add(monthField);
        datePanel.add(new JLabel("/"));
        datePanel.add(yearField);

        c.gridx = 1;
        c.gridy = 1;
        mainPanel.add(datePanel, c);

        confirmationButton = new JButton("Confirm");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(confirmationButton);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        frame,
                        "You sure you want to cancel ?",
                        "Cancel",
                        JOptionPane.YES_NO_OPTION
                );

                if (result == JOptionPane.YES_OPTION) {
                    onCloseHandler.actionPerformed(null);
                    frame.dispose();
                }
            }
        });
    }
}
