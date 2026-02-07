package bridgelabz.json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Car1 {
    private String brand;
    private String model;
    private int year;

    public Car1() {}

    public Car1(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
    
    public static void main(String[] args) {
        try {
            Car1 myCar = new Car1("Tesla", "Model S", 2023);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(myCar));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}