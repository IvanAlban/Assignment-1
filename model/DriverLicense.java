package model;

public class DriverLicense {
    private String name;
    private String lastName;
    private String licenseNumber;
    private String issuingProvince;
    private String expirationDate;

    public DriverLicense(String name, String lastName, String licenseNumber, String issuingProvince, String expirationDate) {
        this.name = name;
        this.lastName = lastName;
        this.licenseNumber = licenseNumber;
        this.issuingProvince = issuingProvince;
        this.expirationDate = expirationDate;
    }

    public DriverLicense() {
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getIssuingProvince() {
        return issuingProvince;
    }

    public void setIssuingProvince(String issuingProvince) {
        this.issuingProvince = issuingProvince;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public DriverLicense(String name) {
        this.name = name;
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
}
