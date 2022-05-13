package com.example.ecommerce;

public class orderclass {

    String Order_Date,Order_Time,Payment_Type,Paid,Price,Quantity,SIN,Status,TRX_ID,Title,Total_Price,Brand,PID;

    public orderclass(String order_Date, String order_Time, String payment_Type, String paid, String price, String quantity, String SIN, String status, String TRX_ID, String title, String total_Price, String brand, String PID) {
        Order_Date = order_Date;
        Order_Time = order_Time;
        Payment_Type = payment_Type;
        Paid = paid;
        Price = price;
        Quantity = quantity;
        this.SIN = SIN;
        Status = status;
        this.TRX_ID = TRX_ID;
        Title = title;
        Total_Price = total_Price;
        Brand = brand;
        this.PID = PID;
    }

    public orderclass() {
    }

    public String getOrder_Date() {
        return Order_Date;
    }

    public void setOrder_Date(String order_Date) {
        Order_Date = order_Date;
    }

    public String getOrder_Time() {
        return Order_Time;
    }

    public void setOrder_Time(String order_Time) {
        Order_Time = order_Time;
    }

    public String getPayment_Type() {
        return Payment_Type;
    }

    public void setPayment_Type(String payment_Type) {
        Payment_Type = payment_Type;
    }

    public String getPaid() {
        return Paid;
    }

    public void setPaid(String paid) {
        Paid = paid;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getSIN() {
        return SIN;
    }

    public void setSIN(String SIN) {
        this.SIN = SIN;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getTRX_ID() {
        return TRX_ID;
    }

    public void setTRX_ID(String TRX_ID) {
        this.TRX_ID = TRX_ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTotal_Price() {
        return Total_Price;
    }

    public void setTotal_Price(String total_Price) {
        Total_Price = total_Price;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }
}
