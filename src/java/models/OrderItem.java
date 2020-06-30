/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 794473
 */
@Entity
@Table(name = "order_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderItem.findAll", query = "SELECT o FROM OrderItem o")
    , @NamedQuery(name = "OrderItem.findByOrderItemRef", query = "SELECT o FROM OrderItem o WHERE o.orderItemRef = :orderItemRef")
    , @NamedQuery(name = "OrderItem.findByCost", query = "SELECT o FROM OrderItem o WHERE o.cost = :cost")
    , @NamedQuery(name = "OrderItem.findByQuantity", query = "SELECT o FROM OrderItem o WHERE o.quantity = :quantity")
    , @NamedQuery(name = "OrderItem.findByOrdertotal", query = "SELECT o FROM OrderItem o WHERE o.ordertotal = :ordertotal")})
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Order_Item_Ref")
    private String orderItemRef;
    @Basic(optional = false)
    @Column(name = "Cost")
    private double cost;
    @Basic(optional = false)
    @Column(name = "Quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "Order_total")
    private double ordertotal;
    @JoinColumn(name = "Item", referencedColumnName = "Upsc")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Item item;
    @JoinColumn(name = "Order_Number", referencedColumnName = "Order_Number")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Orders orderNumber;

    /**
     *
     */
    public OrderItem() {
    }

    /**
     *
     * @param orderItemRef
     */
    public OrderItem(String orderItemRef) {
        this.orderItemRef = orderItemRef;
    }

    /**
     *
     * @param orderItemRef
     * @param cost
     * @param quantity
     * @param ordertotal
     */
    public OrderItem(String orderItemRef, double cost, int quantity, double ordertotal) {
        this.orderItemRef = orderItemRef;
        this.cost = cost;
        this.quantity = quantity;
        this.ordertotal = ordertotal;
    }

    /**
     *
     * @return
     */
    public String getOrderItemRef() {
        return orderItemRef;
    }

    /**
     *
     * @param orderItemRef
     */
    public void setOrderItemRef(String orderItemRef) {
        this.orderItemRef = orderItemRef;
    }

    /**
     *
     * @return
     */
    public double getCost() {
        return cost;
    }

    /**
     *
     * @param cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public double getOrdertotal() {
        return ordertotal;
    }

    /**
     *
     * @param ordertotal
     */
    public void setOrdertotal(double ordertotal) {
        this.ordertotal = ordertotal;
    }

    /**
     *
     * @return
     */
    public Item getItem() {
        return item;
    }

    /**
     *
     * @param item
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     *
     * @return
     */
    public Orders getOrderNumber() {
        return orderNumber;
    }

    /**
     *
     * @param orderNumber
     */
    public void setOrderNumber(Orders orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderItemRef != null ? orderItemRef.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
        if ((this.orderItemRef == null && other.orderItemRef != null) || (this.orderItemRef != null && !this.orderItemRef.equals(other.orderItemRef))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.OrderItem[ orderItemRef=" + orderItemRef + " ]";
    }
    
}
