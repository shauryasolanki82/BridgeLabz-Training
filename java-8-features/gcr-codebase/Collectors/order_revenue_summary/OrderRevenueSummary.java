package order_revenue_summary;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderRevenueSummary {
    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(new Order("Rahul", 250.50), new Order("Anita", 300.00), new Order("Rahul", 150.00), new Order("Neha", 500.00), new Order("Anita", 200.00));

        Map<String, Double> revenueByCustomer =
                orders.stream().collect(Collectors.groupingBy(Order::getCustomerName, Collectors.summingDouble(Order::getAmount)));

        revenueByCustomer.forEach((customer, total) ->System.out.println(customer + " : " + total));
    }
}
