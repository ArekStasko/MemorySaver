package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Dashboard {
    JFrame frame;
    JPanel sidebar;
    JPanel mainPanel;
    JButton showMemoriesButton;
    JButton displayNewMemoryFormButton;
    MemoriesTable memoriesTable;

    boolean IsMemoriesTableActive = false;
    boolean IsNewMemoryFormActive = false;

    public Dashboard()
    {
        frame = new JFrame();
        frame.setTitle("Memory Saver");
        frame.setSize(800, 600);

        sidebar = new JPanel();

        showMemoriesButton = new JButton("Show Memories");
        showMemoriesButton.setSize(140, 80);
        showMemoriesButton.addActionListener(e -> ShowMemories());
        showMemoriesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        showMemoriesButton.setAlignmentY(Component.TOP_ALIGNMENT);

        displayNewMemoryFormButton = new JButton("New Memory");
        displayNewMemoryFormButton.setSize(140, 80);
        displayNewMemoryFormButton.addActionListener(e -> DisplayNewMemoryForm());
        displayNewMemoryFormButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayNewMemoryFormButton.setAlignmentY(Component.TOP_ALIGNMENT);

        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(showMemoriesButton.getWidth() + 20, frame.getHeight()));
        sidebar.add(showMemoriesButton);
        sidebar.add(displayNewMemoryFormButton);
        sidebar.setBackground(Color.DARK_GRAY);

        frame.add(sidebar, BorderLayout.WEST);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        memoriesTable = new MemoriesTable();
    }

    public void ShowMemories()
    {
        if(IsMemoriesTableActive)
        {
            memoriesTable.HideMemoriesTable(mainPanel);
            IsMemoriesTableActive = false;
            showMemoriesButton.setText("Show \n Memories");
            return;
        }
        memoriesTable.DisplayMemoriesTable(mainPanel);
        IsMemoriesTableActive = true;
        showMemoriesButton.setText("Hide \n Memories");
    }

    public void onNewMemoryFormHandler()
    {
        displayNewMemoryFormButton.setEnabled(true);
        IsMemoriesTableActive = false;
    }

    public void DisplayNewMemoryForm()
    {
        if(!IsNewMemoryFormActive) displayNewMemoryFormButton.setEnabled(false);
        ActionListener onCloseHandler = (e) -> onNewMemoryFormHandler();
        var form = new NewMemoryForm(onCloseHandler);
    }
}
