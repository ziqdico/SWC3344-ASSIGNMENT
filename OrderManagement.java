import java.util.Scanner;
import java.util.Iterator;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class OrderManagement {
    private ArrayList<Order> orderList = new ArrayList<>();

    public void loadOrdersFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int orderId = Integer.parseInt(parts[0].trim());
                String customerName = parts[1].trim();
                String customerAddress = parts[2].trim();
                String productName = parts[3].trim();
                int quantity = Integer.parseInt(parts[4].trim());
                double pricePerUnit = Double.parseDouble(parts[5].trim());
                String status = parts[6].trim();

                Order order = new Order(orderId, customerName, customerAddress, productName, quantity, pricePerUnit, status);
                orderList.add(order);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void addOrder(Order order) {
        for (Order o : orderList) {
            if (o.getOrderId() == order.getOrderId()) {
                System.out.println("Order ID already exists. Please use a unique order ID.");
                return;
            }
        }
        orderList.add(order);
        System.out.println("Order added successfully.");
    }

    public void modifyOrder(int orderId, Order newOrder) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderId() == orderId) {
                orderList.set(i, newOrder);
                System.out.println("Order modified successfully.");
                return;
            }
        }
        System.out.println("Order ID not found.");
    }

    public void removeOrder(int orderId) {
        Iterator<Order> iterator = orderList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getOrderId() == orderId) {
                iterator.remove();
                System.out.println("Order removed successfully.");
                return;
            }
        }
        System.out.println("Order ID not found.");
    }

    public void displayAllOrders() {
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

    public void displayOrdersByCustomer(String customerName) {
        for (Order order : orderList) {
            if (order.getCustomerName().equalsIgnoreCase(customerName)) {
                System.out.println(order);
            }
        }
    }

    public void displayOrdersByProduct(String productName) {
        for (Order order : orderList) {
            if (order.getProductName().equalsIgnoreCase(productName)) {
                System.out.println(order);
            }
        }
    }

    public void displayOrdersByStatus(String status) {
        for (Order order : orderList) {
            if (order.getStatus().equalsIgnoreCase(status)) {
                System.out.println(order);
            }
        }
    }

    public static void main(String[] args) {
        OrderManagement om = new OrderManagement();
        // Make sure to use double backslashes or single forward slashes in the path
        om.loadOrdersFromFile("C:\\Users\\User\\OneDrive\\Desktop\\swc2333\\Lab Session1\\LabExercise1\\Orders.txt");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new order");
            System.out.println("2. Modify an existing order");
            System.out.println("3. Remove an existing order");
            System.out.println("4. Display all orders");
            System.out.println("5. Display orders by customer name");
            System.out.println("6. Display orders by product name");
            System.out.println("7. Display orders by status");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter order ID: ");
                    int orderId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter customer address: ");
                    String customerAddress = scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price per unit: ");
                    double pricePerUnit = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter status: ");
                    String status = scanner.nextLine();

                    Order newOrder = new Order(orderId, customerName, customerAddress, productName, quantity, pricePerUnit, status);
                    om.addOrder(newOrder);
                    break;

                case 2:
                    System.out.print("Enter order ID to modify: ");
                    int modifyOrderId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new customer name: ");
                    String newCustomerName = scanner.nextLine();
                    System.out.print("Enter new customer address: ");
                    String newCustomerAddress = scanner.nextLine();
                    System.out.print("Enter new product name: ");
                    String newProductName = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    System.out.print("Enter new price per unit: ");
                    double newPricePerUnit = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new status: ");
                    String newStatus = scanner.nextLine();

                    Order modifiedOrder = new Order(modifyOrderId, newCustomerName, newCustomerAddress, newProductName, newQuantity, newPricePerUnit, newStatus);
                    om.modifyOrder(modifyOrderId, modifiedOrder);
                    break;

                case 3:
                    System.out.print("Enter order ID to remove: ");
                    int removeOrderId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    om.removeOrder(removeOrderId);
                    break;

                case 4:
                    om.displayAllOrders();
                    break;

                case 5:
                    System.out.print("Enter customer name: ");
                    String searchCustomerName = scanner.nextLine();
                    om.displayOrdersByCustomer(searchCustomerName);
                    break;

                case 6:
                    System.out.print("Enter product name: ");
                    String searchProductName = scanner.nextLine();
                    om.displayOrdersByProduct(searchProductName);
                    break;

                case 7:
                    System.out.print("Enter status: ");
                    String searchStatus = scanner.nextLine();
                    om.displayOrdersByStatus(searchStatus);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
