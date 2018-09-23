package JAVA_otomoto_like.model;


import javax.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private VehicleType vehicleType;

    @Column
    private String vinNumber;

    @Column
    private Integer productionYear;

    @Column
    private String brand;

    @Column
    private String model;

    @Column
    private String policyNumber;

    @Column
    private String regNumber;

    @Column
    private FuelType fuelType;

    @Column
    private Integer carMileage;

    @Column
    private String engine;

    @Column
    private Integer horsepower;

    @Column
    private GearboxType gearboxType;

    @Column
    private Integer testRidesNumber;

    @Column
    private String description;

    public Vehicle(String vinNumber, Integer productionYear, String brand, String model, String policyNumber, String regNumber, FuelType fuelType, Integer carMileage, String engine, Integer horsepower, GearboxType gearboxType, Integer testRidesNumber, String description) {
        this.vinNumber = vinNumber;
        this.productionYear = productionYear;
        this.brand = brand;
        this.model = model;
        this.policyNumber = policyNumber;
        this.regNumber = regNumber;
        this.fuelType = fuelType;
        this.carMileage = carMileage;
        this.engine = engine;
        this.horsepower = horsepower;
        this.gearboxType = gearboxType;
        this.testRidesNumber = testRidesNumber;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(Integer carMileage) {
        this.carMileage = carMileage;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public GearboxType getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(GearboxType gearboxType) {
        this.gearboxType = gearboxType;
    }

    public Integer getTestRidesNumber() {
        return testRidesNumber;
    }

    public void setTestRidesNumber(Integer testRidesNumber) {
        this.testRidesNumber = testRidesNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
