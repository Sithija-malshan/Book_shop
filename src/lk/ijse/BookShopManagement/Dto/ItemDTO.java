/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.BookShopManagement.Dto;

/**
 *
 * @author malsh
 */
public class ItemDTO {
    private String itemCode;
    private String description;
    private String categoryID;
    private String brandID;
    private double cost;
    private double sale;
    private int qty;

    public ItemDTO() {
    }

    public ItemDTO(String itemCode, String description, String categoryID, String brandID, double cost, double sale, int qty) {
        this.itemCode = itemCode;
        this.description = description;
        this.categoryID = categoryID;
        this.brandID = brandID;
        this.cost = cost;
        this.sale = sale;
        this.qty = qty;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the categoryID
     */
    public String getCategoryID() {
        return categoryID;
    }

    /**
     * @param categoryID the categoryID to set
     */
    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    /**
     * @return the brandID
     */
    public String getBrandID() {
        return brandID;
    }

    /**
     * @param brandID the brandID to set
     */
    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return the sale
     */
    public double getSale() {
        return sale;
    }

    /**
     * @param sale the sale to set
     */
    public void setSale(double sale) {
        this.sale = sale;
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
    
}
