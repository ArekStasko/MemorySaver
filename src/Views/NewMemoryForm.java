package Views;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NewMemoryForm {
    JFrame frame;

    public NewMemoryForm(ActionListener onCloseHandler) {
        frame = new JFrame("New Memory");
        frame.setSize(400, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Wyłącz domyślne zamykanie

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
