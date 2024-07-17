package javaTester.javaOOP;

public class CarPop {
    static String carCompany;
    static String carType;
    static String fuelType;
    static Float mileAge;
    static Double carPrice;

    public static void main(String[] args) {
        carCompany = "Honda";
        carType = "City";
        fuelType = "Petrol";
        mileAge = 200f;
        carPrice = 50000d;
        System.out.println("Car company = " + carCompany);
        System.out.println("Car type = " + carType);
        System.out.println("Fuel type = " + fuelType);
        System.out.println("Mile age = " + mileAge);
        System.out.println("Car Price = " + carPrice);

        carCompany = "Hyundai";
        carType = "Accent";
        fuelType = "Diesel";
        mileAge = 150f;
        carPrice = 30000d;
        System.out.println("Car company = " + carCompany);
        System.out.println("Car type = " + carType);
        System.out.println("Fuel type = " + fuelType);
        System.out.println("Mile age = " + mileAge);
        System.out.println("Car Price = " + carPrice);

    }
}
