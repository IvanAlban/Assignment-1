package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import view.*;
import controller.*;

public class RentalCompany {
    private List<User> users;
    private List<Car> cars;

    public RentalCompany() {
        users = new ArrayList<>();
        User user1 = new User("Aquiles", "Castro", null, "Male");
        users.add(user1);
        User user2 = new User("Rigoberto", "Smith", null, "Male");
        users.add(user2);
        User user3 = new User("Rosa", "Melano", null, "Female");
        users.add(user3);
        User user4 = new User("Helver", "Galarga", null, "Male>");
        users.add(user4);

        cars = new ArrayList<>();
        cars.add(addCar("CAR001", "Red", "Toyota", "Corolla", 35, "regular"));
        cars.add(addCar("CAR002", "Blue", "Honda", "Civic", 40, "hybrid"));
    }

    public User registerUser(String name, String lastName, DriverLicense driverLicense, String gender) {
        // Check if the driver license name and family name are the same
        if (!name.equals(driverLicense.getName()) || !lastName.equals(driverLicense.getLastName())) {
            return null;
        }

        User newUser = new User(name, lastName, driverLicense, gender);
        users.add(newUser);
        return newUser;
    }

    public Car addCar(String carId, String color, String brandName, String modelName, double dailyRentalPrice, String fuelType) {
        Car newCar = new Car(carId, color, brandName, modelName, dailyRentalPrice, fuelType);
        cars.add(newCar);
        return newCar;
    }

    public int getTotalLeasedCars() {
        int leasedCars = 0;
        for (Car car : cars) {
            if (car.getAvailabilityStatus().equals("rented")) {
                leasedCars++;
            }
        }
        return leasedCars;
    }

    public int getTotalUsers() {
        return users.size();
    }

    public double getTotalEarnings() {
        double totalEarnings = 0;
        for (Car car : cars) {
            if (car.getAvailabilityStatus().equals("free")) {
                totalEarnings += car.getDailyRentalPrice() * car.getRentalDuration();
            }
        }
        return totalEarnings;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Car> getCars() {
        return cars;
    }

    public String[] getUsersArray() {
        String[] usersArray = new String[users.size()];
        for (int i = 0; i < users.size(); i++) {
            usersArray[i] = users.get(i).getName() + " " + users.get(i).getLastName();
        }
        return usersArray;
    }

    public String[] getAvailableCarsArray() {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getAvailabilityStatus().equals("free")) {
                availableCars.add(car);
            }
        }

        String[] carsArray = new String[availableCars.size()];
        for (int i = 0; i < availableCars.size(); i++) {
            carsArray[i] = availableCars.get(i).getBrandName() + " " + availableCars.get(i).getModelName();
        }
        return carsArray;
    }

    public User getUserByName(String name) {
        for (User user : users) {
            if ((user.getName() + " " + user.getLastName()).equals(name)) {
                return user;
            }
        }
        return null;
    }

    public Car getCarByBrandModel(String brandModel) {
        for (Car car : cars) {
            if ((car.getBrandName() + " " + car.getModelName()).equals(brandModel)) {
                return car;
            }
        }
        return null;
    }

    public String[] getRentedCarsArray() {
        List<Car> rentedCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getAvailabilityStatus().equals("rented")) {
                rentedCars.add(car);
            }
        }

        String[] carsArray = new String[rentedCars.size()];
        for (int i = 0; i < rentedCars.size(); i++) {
            carsArray[i] = rentedCars.get(i).getBrandName() + " " + rentedCars.get(i).getModelName();
        }
        return carsArray;
    }

    public Car getRentedCarByBrandModel(String brandModel) {
        for (Car car : cars) {
            if ((car.getBrandName() + " " + car.getModelName()).equals(brandModel) && car.getAvailabilityStatus().equals("rented")) {
                return car;
            }
        }
        return null;
    }

    public int getCarCount() {
        return cars.size();
    }
}
