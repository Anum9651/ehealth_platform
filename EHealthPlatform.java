import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EHealthCareApp {

    private JFrame mainFrame;
    private JPanel patientRegistrationPanel, appointmentPanel, doctorPanel;
    private JTextField nameField, dobField, genderField, contactField, medicalHistoryField, appointmentDateField, appointmentTimeField;
    private JButton registerButton, scheduleAppointmentButton, viewAppointmentsButton, viewMedicalRecordsButton;

    private List<Patient> patients;
    private List<Appointment> appointments;
    private List<Doctor> doctors;
    private MedicalRecord medicalRecord;

    public EHealthCareApp() {
        prepareGUI();
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
        doctors = new ArrayList<>();
        medicalRecord = new MedicalRecord();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("E-Healthcare Application");
        mainFrame.setSize(400, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        patientRegistrationPanel = new JPanel();
        patientRegistrationPanel.setLayout(new GridLayout(6, 2));

        // ... (code for patient registration, appointment scheduling)

        viewMedicalRecordsButton = new JButton("View Medical Records");

        viewMedicalRecordsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String patientName = JOptionPane.showInputDialog(mainFrame, "Enter Patient Name:");
                if (patientName != null) {
                    MedicalRecordEntry record = medicalRecord.getRecordForPatient(patientName);
                    if (record != null) {
                        JOptionPane.showMessageDialog(mainFrame, "Medical Record for " + patientName + ":\n" + record.toString(), "Medical Record", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(mainFrame, "No medical record found for " + patientName, "Medical Record", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        patientRegistrationPanel.add(new JLabel()); // Empty label for spacing
        patientRegistrationPanel.add(viewMedicalRecordsButton);

        // ... (code for doctor management)

        mainFrame.add(patientRegistrationPanel, BorderLayout.NORTH);
        mainFrame.add(appointmentPanel, BorderLayout.CENTER);
        mainFrame.add(doctorPanel, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }

    // Define the Doctor and MedicalRecord classes as appropriate for your application

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EHealthCareApp app = new EHealthCareApp();
            }
        });
    }
}
