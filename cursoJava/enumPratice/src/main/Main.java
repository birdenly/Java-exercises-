package cursoJava.enumPratice.src.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import cursoJava.enumPratice.src.main.entities.Client;
import cursoJava.enumPratice.src.main.entities.Order;
import cursoJava.enumPratice.src.main.entities.OrderItem;
import cursoJava.enumPratice.src.main.entities.Product;
import cursoJava.enumPratice.src.main.enums.OrderStatus;

public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.nextLine());
        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = sc.nextLine();
        Order order = new Order(new Date(), OrderStatus.valueOf(status), client);

        System.out.print("How many items to this order?");
        int amount = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < amount; i++) {
            System.out.println("Enter #" + (i + 1) + " item data:");    
            System.out.print("Enter the product name: ");
            String productName = sc.nextLine();
            System.out.print("Enter the product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Enter the quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            OrderItem orderItem = new OrderItem(quantity, productPrice, new Product(productName, productPrice));
            order.addItem(orderItem);

        }

        System.out.println();

        System.out.println("ORDER SUMMARY:");
        System.out.println("Order moment: " + sdf.format(order.getMoment()));
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Client: " + client.getName() + " (" + sdf.format(client.getBirthDate()) + ") - " + client.getEmail());
        System.out.println("Order items:");
        for(OrderItem item : order.getItems()) {
            System.out.println(item.getProduct().getName() + ", $" + item.getProduct().getPrice() + ", Quantity: " + item.getQuantity() + ", Subtotal: $" + item.subTotal());
        }
        System.out.println("Total price: $" + order.total());


    }
}
