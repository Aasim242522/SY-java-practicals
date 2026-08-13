import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentResumeForm extends JFrame implements ActionListener {

    JTextField nameField, emailField, phoneField, dobField;
    JTextArea addressArea, summaryArea;
    JRadioButton male, female, other;
    JComboBox<String> educationBox;
    JCheckBox java, python, cpp, html;
    JButton submitButton, clearButton;
    ButtonGroup genderGroup;

    public StudentResumeForm() {
        setTitle("Student Resume Form");
        setSize(550, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main Panel with green background
        JPanel mainPanel = new JPanel(new GridLayout(13, 2, 10, 10));
        mainPanel.setBackground(new Color(204, 255, 204)); // Light green
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title Label
        JLabel title = new JLabel("My Resume (S071)", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(new Color(0, 100, 0)); // Dark green

        // Add title to top panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(153, 255, 153)); // Light green
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);
        add(mainPanel);

        // Name
        mainPanel.add(new JLabel("Full Name:"));
        nameField = new JTextField();
        mainPanel.add(nameField);

        // Gender
        mainPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.setBackground(new Color(204, 255, 204));
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(other);
        mainPanel.add(genderPanel);

        // DOB
        mainPanel.add(new JLabel("Date of Birth (dd/mm/yyyy):"));
        dobField = new JTextField();
        mainPanel.add(dobField);

        // Email
        mainPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        mainPanel.add(emailField);

        // Phone
        mainPanel.add(new JLabel("Phone Number:"));
        phoneField = new JTextField();
        mainPanel.add(phoneField);

        // Address
        mainPanel.add(new JLabel("Address:"));
        addressArea = new JTextArea(3, 20);
        JScrollPane scroll1 = new JScrollPane(addressArea);
        mainPanel.add(scroll1);

        // Education
        mainPanel.add(new JLabel("Education:"));
        String[] degrees = {"Select", "High School", "Diploma", "BSc", "BCA", "B.Com", "MSc", "MCA"};
        educationBox = new JComboBox<>(degrees);
        mainPanel.add(educationBox);

        // Skills
        mainPanel.add(new JLabel("Skills:"));
        JPanel skillPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        skillPanel.setBackground(new Color(204, 255, 204));
        java = new JCheckBox("Java");
        python = new JCheckBox("Python");
        cpp = new JCheckBox("C++");
        html = new JCheckBox("HTML/CSS");
        skillPanel.add(java);
        skillPanel.add(python);
        skillPanel.add(cpp);
        skillPanel.add(html);
        mainPanel.add(skillPanel);

        // Summary
        mainPanel.add(new JLabel("Resume Summary:"));
        summaryArea = new JTextArea(4, 20);
        JScrollPane scroll2 = new JScrollPane(summaryArea);
        mainPanel.add(scroll2);

        // Buttons
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        submitButton.setBackground(new Color(102, 204, 102)); // Green
        clearButton.setBackground(new Color(255, 153, 153)); // Light red
        mainPanel.add(submitButton);
        mainPanel.add(clearButton);

        submitButton.addActionListener(this);
        clearButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String dob = dobField.getText();
            String gender = male.isSelected() ? "Male" :
                    female.isSelected() ? "Female" :
                    other.isSelected() ? "Other" : "Not Selected";
            String email = emailField.getText();
            String phone = phoneField.getText();
            String address = addressArea.getText();
            String education = (String) educationBox.getSelectedItem();
            String skills = "";
            if (java.isSelected()) skills += "Java ";
            if (python.isSelected()) skills += "Python ";
            if (cpp.isSelected()) skills += "C++ ";
            if (html.isSelected()) skills += "HTML/CSS ";

            String summary = summaryArea.getText();

            String message = "Resume Submitted Successfully!\n\n"
                    + "Name: " + name + "\n"
                    + "DOB: " + dob + "\n"
                    + "Gender: " + gender + "\n"
                    + "Email: " + email + "\n"
                    + "Phone: " + phone + "\n"
                    + "Address: " + address + "\n"
                    + "Education: " + education + "\n"
                    + "Skills: " + skills + "\n"
                    + "Summary: " + summary;

            JOptionPane.showMessageDialog(this, message, "Resume Submitted", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == clearButton) {
            nameField.setText("");
            dobField.setText("");
            emailField.setText("");
            phoneField.setText("");
            addressArea.setText("");
            summaryArea.setText("");
            genderGroup.clearSelection();
            educationBox.setSelectedIndex(0);
            java.setSelected(false);
            python.setSelected(false);
            cpp.setSelected(false);
            html.setSelected(false);
        }
    }

    public static void main(String[] args) {
        StudentResumeForm studentResumeForm = new StudentResumeForm();
    }
}