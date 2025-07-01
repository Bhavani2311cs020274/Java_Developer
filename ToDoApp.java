import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoApp {
    // GUI Components
    private JFrame frame;
    private JTextField taskField;
    private JButton addButton;
    private JButton deleteButton;
    private DefaultListModel<String> listModel;
    private JList<String> taskList;

    public ToDoApp() {
        // Step 1: Create Frame
        frame = new JFrame("To-Do List App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Step 2: Top Panel for input
        JPanel topPanel = new JPanel();
        taskField = new JTextField(20);
        addButton = new JButton("Add Task");
        topPanel.add(taskField);
        topPanel.add(addButton);

        // Step 3: Center - Task List
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Step 4: Bottom Panel for delete button
        JPanel bottomPanel = new JPanel();
        deleteButton = new JButton("Delete Task");
        bottomPanel.add(deleteButton);

        // Add panels to frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Step 5: Add Button Action
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    taskField.setText("");
                }
            }
        });

        // Step 6: Delete Button Action
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });

        // Final step: Set visible
        frame.setVisible(true);
    }

    // Main method
    public static void main(String[] args) {
        new ToDoApp();
    }
}
