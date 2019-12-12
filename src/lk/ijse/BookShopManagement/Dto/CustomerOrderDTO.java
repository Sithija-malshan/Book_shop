/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Dto;

import java.util.ArrayList;

/**
 *
 * @author malsh
 */
public class CustomerOrderDTO {
    private String orderId;
    private String cusId;
    private String date;
    private double total;
    private ArrayList<CustomerOrderDetailDTO> allOrderDetails;
    private ArrayList<ItemDTO> orderItem;

    public CustomerOrderDTO() {
    }

    public CustomerOrderDTO(String orderId, String cusId, String date, double total, ArrayList<CustomerOrderDetailDTO> allOrderDetails, ArrayList<ItemDTO> orderItem) {
        this.orderId = orderId;
        this.cusId = cusId;
        this.date = date;
        this.total = total;
        this.allOrderDetails = allOrderDetails;
        this.orderItem = orderItem;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    /**
     * @return the allOrderDetails
     */
    public ArrayList<CustomerOrderDetailDTO> getAllOrderDetails() {
        return allOrderDetails;
    }

    /**
     * @param allOrderDetails the allOrderDetails to set
     */
    public void setAllOrderDetails(ArrayList<CustomerOrderDetailDTO> allOrderDetails) {
        this.allOrderDetails = allOrderDetails;
    }

    /**
     * @return the orderItem
     */
    public ArrayList<ItemDTO> getOrderItem() {
        return orderItem;
    }

    /**
     * @param orderItem the orderItem to set
     */
    public void setOrderItem(ArrayList<ItemDTO> orderItem) {
        this.orderItem = orderItem;
    }
    
}
