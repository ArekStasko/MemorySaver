package Views;

import javax.swing.*;
import java.awt.*;

public class MemoriesTable {
    JTable table;

    public void DisplayMemoriesTable(JPanel panel)
    {
        panel.removeAll();
        String[][] MockData = {
                {"2024-10-11", "Test321"},
                {"2024-10-12", "Test123"}
        };

        String[] columnNames = {"Date", "Text"};
        table = new JTable(MockData, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        panel.revalidate();
        panel.repaint();
    }

    public void HideMemoriesTable(JPanel panel)
    {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
    }
}
