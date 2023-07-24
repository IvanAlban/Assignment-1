package view;
import model.*;
import controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarRentalView extends JFrame {
    private RentalCompany model;

    private JTextArea outputTextArea;
    private JTextField nameInput;
    private JTextField lastNameInput;
    private JTextField genderInput;
    private JTextField licenseNameInput;
    private JTextField licenseLastNameInput;
    private JTextField licenseNumberInput;
    private JTextField issuingProvinceInput;
    private JTextField expirationDateInput;
    private JTextField carIdInput;
    private JTextField carColorInput;
    private JTextField carBrandInput;
    private JTextField carModelInput;
    private JTextField carDailyPriceInput;
    private JTextField carFuelTypeInput;
    private JComboBox<String> usersComboBox;
    private JComboBox<String> availableCarsComboBox;
    private JTextField rentalDurationInput;
    private JComboBox<String> rentedCarsComboBox;
    private JButton registerUserButton;
    private JButton addCarButton;
    private JButton rentCarButton;
    private JButton returnCarButton;
    private JButton showReportsButton;

    public CarRentalView() {
        model = new RentalCompany();

        setTitle("Car Rental System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        outputTextArea = new JTextArea(15, 40);
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        // User registration inputs
        JLabel nameLabel = new JLabel("Name:");
        nameInput = new JTextField(15);
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameInput = new JTextField(15);
        JLabel genderLabel = new JLabel("Gender:");
        genderInput = new JTextField(10);
        JLabel licenseNameLabel = new JLabel("License Name:");
        licenseNameInput = new JTextField(15);
        JLabel licenseLastNameLabel = new JLabel("License Last Name:");
        licenseLastNameInput = new JTextField(15);
        JLabel licenseNumberLabel = new JLabel("License Number:");
        licenseNumberInput = new JTextField(15);
        JLabel issuingProvinceLabel = new JLabel("Issuing Province:");
        issuingProvinceInput = new JTextField(15);
        JLabel expirationDateLabel = new JLabel("Expiration Date:");
        expirationDateInput = new JTextField(15);
        registerUserButton = new JButton("Register User");

        constraints.gridx = 0;
        constraints.gridy = 0;
        controlPanel.add(nameLabel, constraints);
        constraints.gridx = 1;
        controlPanel.add(nameInput, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        controlPanel.add(lastNameLabel, constraints);
        constraints.gridx = 1;
        controlPanel.add(lastNameInput, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        controlPanel.add(genderLabel, constraints);
        constraints.gridx = 1;
        controlPanel.add(genderInput, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        controlPanel.add(licenseNameLabel, constraints);
        constraints.gridx = 1;
        controlPanel.add(licenseNameInput, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        controlPanel.add(licenseLastNameLabel, constraints);
        constraints.gridx = 1;
        controlPanel.add(licenseLastNameInput, constraints);
        constraints.gridx = 0;
        constraints.gridy = 5;
        controlPanel.add(licenseNumberLabel, constraints);
        constraints.gridx = 1;
        controlPanel.add(licenseNumberInput, constraints);
        constraints.gridx = 0;
        constraints.gridy = 6;
        controlPanel.add(issuingProvinceLabel, constraints);
        constraints.gridx = 1;
        controlPanel.add(issuingProvinceInput, constraints);
        constraints.gridx = 0;
        constraints.gridy = 7;
        controlPanel.add(expirationDateLabel, constraints);
        constraints.gridx = 1;
        controlPanel.add(expirationDateInput, constraints);
        constraints.gridx = 1;
        constraints.gridy = 8;
        controlPanel.add(registerUserButton, constraints);

        // Car registration inputs
        JLabel carIdLabel = new JLabel("Car ID:");
        carIdInput = new JTextField(10);
        JLabel carColorLabel = new JLabel("Color:");
        carColorInput = new JTextField(10);
        JLabel carBrandLabel = new JLabel("Brand:");
        carBrandInput = new JTextField(10);
        JLabel carModelLabel = new JLabel("Model:");
        carModelInput = new JTextField(10);
        JLabel carDailyPriceLabel = new JLabel("Daily Price:");
        carDailyPriceInput = new JTextField(10);
        JLabel carFuelTypeLabel = new JLabel("Fuel Type:");
        carFuelTypeInput = new JTextField(10);
        addCarButton = new JButton("Add Car");

        constraints.gridx = 0;
        constraints.gridy = 9;
        controlPanel.add(carIdLabel, constraints);
        constraints.gridx = 1;
        controlPanel.add(carIdInput, constraints);
        constraints.gridx = 0;
        constraints.gridy = 10;
        controlPanel.add(carColorLabel, constraints);
        constraints.gridx = 1;
        controlPanel.add(carColorInput, constraints);
        constraints.gridx = 0;
        constraints.gridy = 11;
        controlPanel.add(carBrandLabel, constraints);
        constraints.gridx = 1;
        controlPanel.add(carBrandInput, constraints);
        constraints.gridx = 0;
        constraints.gridy = 12;
        controlPanel.add(carModelLabel, constraints);
        constraints.gridx = 1;
        controlPanel.add(carModelInput, constraints);
        constraints.gridx = 0;
        constraints.gridy = 13;
        controlPanel.add(carDailyPriceLabel, constraints);
        constraints.gridx = 1;
        controlPanel.add(carDailyPriceInput, constraints);
        constraints.gridx = 0;
        constraints.gridy = 14;
        controlPanel.add(carFuelTypeLabel, constraints);
        constraints.gridx = 1;
        controlPanel.add(carFuelTypeInput, constraints);
        constraints.gridx = 1;
        constraints.gridy = 15;
        controlPanel.add(addCarButton, constraints);

        // Car rental inputs
        usersComboBox = new JComboBox<>(model.getUsersArray());
        availableCarsComboBox = new JComboBox<>(model.getAvailableCarsArray());
        JLabel rentalDurationLabel = new JLabel("Rental Duration (days):");
        rentalDurationInput = new JTextField(10);
        rentCarButton = new JButton("Rent Car");

        constraints.gridx = 0;
        constraints.gridy = 16;
        controlPanel.add(new JLabel("Select User:"), constraints);
        constraints.gridx = 1;
        controlPanel.add(usersComboBox, constraints);
        constraints.gridx = 0;
        constraints.gridy = 17;
        controlPanel.add(new JLabel("Select Car to Rent:"), constraints);
        constraints.gridx = 1;
        controlPanel.add(availableCarsComboBox, constraints);
        constraints.gridx = 0;
        constraints.gridy = 18;
        controlPanel.add(rentalDurationLabel, constraints);
        constraints.gridx = 1;
        controlPanel.add(rentalDurationInput, constraints);
        constraints.gridx = 1;
        constraints.gridy = 19;
        controlPanel.add(rentCarButton, constraints);

        // Car return inputs
        rentedCarsComboBox = new JComboBox<>(model.getRentedCarsArray());
        returnCarButton = new JButton("Return Car");

        constraints.gridx = 0;
        constraints.gridy = 20;
        controlPanel.add(new JLabel("Select User to Return Car:"), constraints);
        constraints.gridx = 1;
        controlPanel.add(rentedCarsComboBox, constraints);
        constraints.gridx = 1;
        constraints.gridy = 21;
        controlPanel.add(returnCarButton, constraints);

        // Show reports button
        showReportsButton = new JButton("Show Reports");
        constraints.gridx = 0;
        constraints.gridy = 22;
        constraints.gridwidth = 2;
        controlPanel.add(showReportsButton, constraints);

        add(controlPanel, BorderLayout.SOUTH);
        updateUsersComboBox();
        updateAvailableCarsComboBox();
        updateRentedCarsComboBox();
        pack();
    }
    public void updateUsersComboBox() {
        usersComboBox.removeAllItems();
        String[] usersArray = model.getUsersArray();
        for (String user : usersArray) {
            usersComboBox.addItem(user);
        }
    }

    public void updateAvailableCarsComboBox() {
        availableCarsComboBox.removeAllItems();
        String[] availableCarsArray = model.getAvailableCarsArray();
        for (String car : availableCarsArray) {
            availableCarsComboBox.addItem(car);
        }
    }

    public void updateRentedCarsComboBox() {
        rentedCarsComboBox.removeAllItems();
        String[] rentedCarsArray = model.getRentedCarsArray();
        for (String car : rentedCarsArray) {
            rentedCarsComboBox.addItem(car);
        }
    }



    public String getNameInput() {
        return nameInput.getText();
    }

    public String getLastNameInput() {
        return lastNameInput.getText();
    }

    public String getGenderInput() {
        return genderInput.getText();
    }

    public String getLicenseNameInput() {
        return licenseNameInput.getText();
    }

    public String getLicenseLastNameInput() {
        return licenseLastNameInput.getText();
    }

    public String getLicenseNumberInput() {
        return licenseNumberInput.getText();
    }

    public String getIssuingProvinceInput() {
        return issuingProvinceInput.getText();
    }

    public String getExpirationDateInput() {
        return expirationDateInput.getText();
    }

    public String getCarIdInput() {
        return carIdInput.getText();
    }

    public String getCarColorInput() {
        return carColorInput.getText();
    }

    public String getCarBrandInput() {
        return carBrandInput.getText();
    }

    public String getCarModelInput() {
        return carModelInput.getText();
    }

    public double getCarDailyPriceInput() {
        return Double.parseDouble(carDailyPriceInput.getText());
    }

    public String getCarFuelTypeInput() {
        return carFuelTypeInput.getText();
    }

    public String getSelectedUser() {
        return usersComboBox.getSelectedItem().toString();
    }

    public String getSelectedAvailableCar() {
        return availableCarsComboBox.getSelectedItem().toString();
    }

    public int getRentalDurationInput() {
        return Integer.parseInt(rentalDurationInput.getText());
    }

    public String getSelectedUserForReturn() {
        return rentedCarsComboBox.getSelectedItem().toString();
    }

    public String getSelectedRentedCar() {
        return rentedCarsComboBox.getSelectedItem().toString();
    }

    public void addRegisterUserButtonListener(ActionListener listener) {
        registerUserButton.addActionListener(listener);
    }

    public void addAddCarButtonListener(ActionListener listener) {
        addCarButton.addActionListener(listener);
    }

    public void addRentCarButtonListener(ActionListener listener) {
        rentCarButton.addActionListener(listener);
    }

    public void addReturnCarButtonListener(ActionListener listener) {
        returnCarButton.addActionListener(listener);
    }

    public void addShowReportsButtonListener(ActionListener listener) {
        showReportsButton.addActionListener(listener);
    }

    public void showMessage(String message) {
        outputTextArea.append(message + "\n");
    }
}
