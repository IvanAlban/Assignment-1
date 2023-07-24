package model;
import java.util.ArrayList;
import java.util.List;
public class User {
    private String name;
    private String lastName;
    private DriverLicense driverLicense;
    private String gender;
    private List<Car> rentedCars;

    public User(String name, String lastName, DriverLicense driverLicense, String gender) {
        this.name = name;
        this.lastName = lastName;
        this.driverLicense = driverLicense;
        this.gender = gender;
        this.rentedCars = new ArrayList<>();
    }

    public List<Car> getRentedCars() {
        return rentedCars;
    }

    public void setRentedCars(List<Car> rentedCars) {
        this.rentedCars = rentedCars;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public DriverLicense getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(DriverLicense driverLicense) {
        this.driverLicense = driverLicense;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
// Getters and setters for the User class

    public void rentCar(Car car, int rentalDuration) {
        if (car.getAvailabilityStatus().equals("free") && !car.isRented() && !rentedCars.contains(car)) {
            car.setAvailabilityStatus("rented");
            car.setRentedBy(this);
            car.setRentalDuration(rentalDuration);
            rentedCars.add(car);
        }
    }

    public void returnCar(Car car) {
        if (rentedCars.contains(car)) {
            car.setAvailabilityStatus("free");
            car.setRentedBy(null);
            car.setRentalDuration(0);
            rentedCars.remove(car);
        }
    }
}
