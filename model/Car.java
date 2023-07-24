package model;

public class Car {
    private String carId;
    private String color;
    private String brandName;
    private String modelName;
    private double dailyRentalPrice;
    private String fuelType;
    private String availabilityStatus;
    private int rentalDuration;
    private User rentedBy;

    public Car(String carId, String color, String brandName, String modelName, double dailyRentalPrice, String fuelType) {
        this.carId = carId;
        this.color = color;
        this.brandName = brandName;
        this.modelName = modelName;
        this.dailyRentalPrice = dailyRentalPrice;
        this.fuelType = fuelType;
        this.availabilityStatus = "free";
        this.rentalDuration = 0;
        this.rentedBy = null;
    }

    public User getRentedBy() {
        return rentedBy;
    }

    public void setRentedBy(User rentedBy) {
        this.rentedBy = rentedBy;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    public void setDailyRentalPrice(double dailyRentalPrice) {
        this.dailyRentalPrice = dailyRentalPrice;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public boolean isRented() {
        return rentedBy != null;
    }
}
