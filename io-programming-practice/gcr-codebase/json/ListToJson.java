package bridgelabz.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

class Car {
    private String brand;
    private String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() { 
    	return brand; 
    }
    public String getModel() { 
    	return model; 
    }
}

public class ListToJson {
    public static void main(String[] args) {
        try {
            List<Car> carList = new ArrayList<>();
            carList.add(new Car("Tesla", "Model S"));
            carList.add(new Car("Ford", "Mustang"));
            carList.add(new Car("Toyota", "Camry"));
            ObjectMapper mapper = new ObjectMapper();
            String jsonArray = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(carList);
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
