/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Entity;

/**
 *
 * @author malsh
 */
public class CustomerOrder {
    private String cusOrderId;
    private String cusId;
    private String date;
    private double total;

    public CustomerOrder() {
    }

    public CustomerOrder(String cusOrderId, String cusId, String date, double total) {
        this.cusOrderId = cusOrderId;
        this.cusId = cusId;
        this.date = date;
        this.total = total;
    }

    /**
     * @return the cusOrderId
     */
    public String getCusOrderId() {
        return cusOrderId;
    }

    /**
     * @param cusOrderId the cusOrderId to set
     */
    public void setCusOrderId(String cusOrderId) {
        this.cusOrderId = cusOrderId;
    }

    /**
     * @return the cusId
     */
    public String getCusId() {
        return cusId;
    }

    /**
     * @param cusId the cusId to set
     */
    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
