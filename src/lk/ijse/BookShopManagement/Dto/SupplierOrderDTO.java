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
public class SupplierOrderDTO {
    private String soId;
    private String supId;
    private String date;
    private ArrayList<ItemDTO> orderItems;

    public SupplierOrderDTO() {
    }

    public SupplierOrderDTO(String soId, String supId, String date, ArrayList<ItemDTO> orderItems) {
        this.soId = soId;
        this.supId = supId;
        this.date = date;
        this.orderItems = orderItems;
    }

    /**
     * @return the soId
     */
    public String getSoId() {
        return soId;
    }

    /**
     * @param soId the soId to set
     */
    public void setSoId(String soId) {
        this.soId = soId;
    }

    /**
     * @return the supId
     */
    public String getSupId() {
        return supId;
    }

    /**
     * @param supId the supId to set
     */
    public void setSupId(String supId) {
        this.supId = supId;
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
     * @return the orderItems
     */
    public ArrayList<ItemDTO> getOrderItems() {
        return orderItems;
    }

    /**
     * @param orderItems the orderItems to set
     */
    public void setOrderItems(ArrayList<ItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
    
    
}
