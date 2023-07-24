package controller;
import model.*;
import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarRentalController {
    private RentalCompany model;
    private CarRentalView view;

    public CarRentalController(RentalCompany model, CarRentalView view) {
        this.model = model;
        this.view = view;

        // Add ActionListener to buttons and other components of the graphical interface (View).
        view.addRegisterUserButtonListener(new RegisterUserButtonListener());
        view.addAddCarButtonListener(new AddCarButtonListener());
        view.addRentCarButtonListener(new RentCarButtonListener());
        view.addReturnCarButtonListener(new ReturnCarButtonListener());
        view.addShowReportsButtonListener(new ShowReportsButtonListener());

        updateView(); // Update the view initially with data from the model.
    }

    private void updateView() {
        view.updateUsersComboBox();
        // Update other components of the graphical interface with relevant data from the model.
        // ...
    }

    // Implement methods to handle user actions and update the model and view accordingly.

    // ... ActionListener inner classes for each button and other components.


    // Implementar métodos para manejar las acciones del usuario y actualizar el modelo y la vista en consecuencia.
    private class RegisterUserButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNameInput();
            String lastName = view.getLastNameInput();
            String gender = view.getGenderInput();
            String licenseName = view.getLicenseNameInput();
            String licenseLastName = view.getLicenseLastNameInput();
            String licenseNumber = view.getLicenseNumberInput();
            String issuingProvince = view.getIssuingProvinceInput();
            String expirationDate = view.getExpirationDateInput();

            DriverLicense driverLicense = new DriverLicense(licenseName, licenseLastName, licenseNumber, issuingProvince, expirationDate);
            User user = model.registerUser(name, lastName, driverLicense, gender);
            if (user != null) {
                view.showMessage("User successfully registered: " + user.getName() + " " + user.getLastName());
            } else {
                view.showMessage("User registration failed. Please make sure driver's license name and last name match.");
            }
            updateView();
        }
    }

    private class AddCarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String carId = view.getCarIdInput();
            String color = view.getCarColorInput();
            String brandName = view.getCarBrandInput();
            String modelName = view.getCarModelInput();
            double dailyRentalPrice = view.getCarDailyPriceInput();
            String fuelType = view.getCarFuelTypeInput();

            Car car = model.addCar(carId, color, brandName, modelName, dailyRentalPrice, fuelType);
            view.showMessage("Car successfully added: " + car.getBrandName() + " " + car.getModelName());
            updateView();
        }
    }

    private class RentCarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (model.getTotalUsers() == 0) {
                view.showMessage("No users registered. Please add a user first.");
                return;
            }

            if (model.getTotalLeasedCars() == model.getCarCount()) {
                view.showMessage("All cars are currently leased. Please try again later.");
                return;
            }

            String selectedUser = view.getSelectedUser();
            String selectedCar = view.getSelectedAvailableCar();
            int rentalDuration = view.getRentalDurationInput();

            User user = model.getUserByName(selectedUser);
            Car car = model.getCarByBrandModel(selectedCar);
            user.rentCar(car, rentalDuration);
            view.showMessage("Car successfully rented to " + user.getName() + " " + user.getLastName() + ".");
            updateView();
        }
    }

    private class ReturnCarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (model.getTotalLeasedCars() == 0) {
                view.showMessage("No cars are currently rented.");
                return;
            }

            String selectedUser = view.getSelectedUserForReturn();
            String selectedCar = view.getSelectedRentedCar();
            User user = model.getUserByName(selectedUser);
            Car car = model.getRentedCarByBrandModel(selectedCar);

            if (user != null && car != null) {
                user.returnCar(car);
                view.showMessage("Car successfully returned by " + user.getName() + " " + user.getLastName() + ".");
            }
            updateView();
        }
    }

    private class ShowReportsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int leasedCars = model.getTotalLeasedCars();
            int totalUsers = model.getTotalUsers();
            double totalEarnings = model.getTotalEarnings();

            view.showMessage("Total leased cars: " + leasedCars +
                    "\nTotal users: " + totalUsers +
                    "\nTotal earnings: $" + totalEarnings);
        }
    }
}
