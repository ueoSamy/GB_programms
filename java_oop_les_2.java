// Абстрактный класс для представления транспортного средства
abstract class Vehicle {
    private static int idCounter = 1;

    protected int id;
    protected String brand;
    protected String model;
    protected int year;

    public Vehicle(String brand, String model, int year) {
        this.id = idCounter++;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public abstract void startEngine();

    public abstract void stopEngine();

    public abstract void accelerate(int speed);

    public abstract void brake();

    public abstract void displayInfo();
}

// Интерфейс для летающих транспортных средств
interface Flyable {
    void takeOff();

    void land();
}

// Интерфейс для плавающих транспортных средств
interface Swimmable {
    void startSwimming();

    void stopSwimming();
}

// Класс для представления автомобиля
class Car extends Vehicle {
    private int fuelCapacity;
    private int currentFuelLevel;

    public Car(String brand, String model, int year, int fuelCapacity) {
        super(brand, model, year);
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = 0;
    }

    @Override
    public void startEngine() {
        System.out.println("Car engine started.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car engine stopped.");
    }

    @Override
    public void accelerate(int speed) {
        System.out.println("Car accelerating to " + speed + " km/h.");
    }

    @Override
    public void brake() {
        System.out.println("Car braking.");
    }

    public void refuel(int liters) {
        System.out.println("Refueling car with " + liters + " liters.");
        currentFuelLevel += liters;
        if (currentFuelLevel > fuelCapacity) {
            currentFuelLevel = fuelCapacity;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Car info - ID: " + id + ", Brand: " + brand + ", Model: " + model + ", Year: " + year);
    }
}

// Класс для представления самолета
class Aircraft extends Vehicle implements Flyable {
    private int maxAltitude;
    private boolean isFlying;

    public Aircraft(String brand, String model, int year, int maxAltitude) {
        super(brand, model, year);
        this.maxAltitude = maxAltitude;
        this.isFlying = false;
    }

    @Override
    public void startEngine() {
        System.out.println("Aircraft engine started.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Aircraft engine stopped.");
        isFlying = false;
    }

    @Override
    public void accelerate(int speed) {
        System.out.println("Aircraft accelerating to " + speed + " km/h.");
    }

    @Override
    public void brake() {
        System.out.println("Aircraft braking.");
    }

    @Override
    public void takeOff() {
        System.out.println("Aircraft taking off.");
        isFlying = true;
    }

    @Override
    public void land() {
        System.out.println("Aircraft landing.");
        isFlying = false;
    }

    @Override
    public void displayInfo() {
        System.out.println("Aircraft info - ID: " + id + ", Brand: " + brand + ", Model: " + model + ", Year: " + year);
    }
}

// Класс для представления лодки
class Boat extends Vehicle implements Swimmable {
    private int maxSpeed;
    private boolean isSailing;

    public Boat(String brand, String model, int year, int maxSpeed) {
        super(brand, model, year);
        this.maxSpeed = maxSpeed;
        this.isSailing = false;
    }

    @Override
    public void startEngine() {
        System.out.println("Boat engine started.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Boat engine stopped.");
        isSailing = false;
    }

    @Override
    public void accelerate(int speed) {
        System.out.println("Boat accelerating to " + speed + " knots.");
    }

    @Override
    public void brake() {
        System.out.println("Boat braking.");
    }

    @Override
    public void startSwimming() {
        System.out.println("Boat starting to sail.");
        isSailing = true;
    }

    @Override
    public void stopSwimming() {
        System.out.println("Boat stopping sailing.");
        isSailing = false;
    }

    @Override
    public void displayInfo() {
        System.out.println("Boat info - ID: " + id + ", Brand: " + brand + ", Model: " + model + ", Year: " + year);
    }
}

// Главный класс для проверки
public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2022, 50);
        Aircraft aircraft = new Aircraft("Boeing", "747", 2022, 40000);
        Boat boat = new Boat("Sea Ray", "Sundancer", 2022, 30);

        car.startEngine();
        car.accelerate(60);
        car.brake();
        car.refuel(20);
        car.displayInfo();

        System.out.println();

        aircraft.startEngine();
        aircraft.takeOff();
        aircraft.accelerate(800);
        aircraft.land();
        aircraft.stopEngine();
        aircraft.displayInfo();

        System.out.println();

        boat.startEngine();
        boat.startSwimming();
        boat.accelerate(20);
        boat.stopSwimming();
        boat.stopEngine();
        boat.displayInfo();
    }
}
