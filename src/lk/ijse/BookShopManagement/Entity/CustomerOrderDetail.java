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
public class CustomerOrderDetail {
    private String cusOrderId;
    private String itemCode;
    private int qty;
    private double price;

    public CustomerOrderDetail() {
    }

    public CustomerOrderDetail(String cusOrderId, String itemCode, int qty, double price) {
        this.cusOrderId = cusOrderId;
        this.itemCode = itemCode;
        this.qty = qty;
        this.price = price;
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
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    
    
    
}
