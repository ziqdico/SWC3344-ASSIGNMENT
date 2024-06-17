
/**
 * class Order.
 *
 * @author (Muhammad Ameer Haziq bin Mohamad Fikri)
 * @version (17 June 2024)
 */
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Order {
    private int orderId;
    private String customerName;
    private String customerAddress;
    private String productName;
    private int quantity;
    private double pricePerUnit;
    private double totalPrice;
    private String status;

    public Order(int orderId, String customerName, String customerAddress, String productName, int quantity, double pricePerUnit, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.totalPrice = quantity * pricePerUnit;
        this.status = status;
    }

    // Getters and setters for all attributes
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerAddress() { return customerAddress; }
    public void setCustomerAddress(String customerAddress) { this.customerAddress = customerAddress; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(double pricePerUnit) { this.pricePerUnit = pricePerUnit; }

    public double getTotalPrice() { return totalPrice; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer Name: " + customerName + ", Address: " + customerAddress +
                ", Product: " + productName + ", Quantity: " + quantity + ", Price per Unit: " + pricePerUnit +
                ", Total Price: " + totalPrice + ", Status: " + status;
    }
}

