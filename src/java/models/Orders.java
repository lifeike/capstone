/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 794473
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findByOrderNumber", query = "SELECT o FROM Orders o WHERE o.orderNumber = :orderNumber")
    , @NamedQuery(name = "Orders.findByShipfname", query = "SELECT o FROM Orders o WHERE o.shipfname = :shipfname")
    , @NamedQuery(name = "Orders.findByShiplname", query = "SELECT o FROM Orders o WHERE o.shiplname = :shiplname")
    , @NamedQuery(name = "Orders.findByPhone", query = "SELECT o FROM Orders o WHERE o.phone = :phone")
    , @NamedQuery(name = "Orders.findByOrderDate", query = "SELECT o FROM Orders o WHERE o.orderDate = :orderDate")
    , @NamedQuery(name = "Orders.findByShipDate", query = "SELECT o FROM Orders o WHERE o.shipDate = :shipDate")
    , @NamedQuery(name = "Orders.findByShipAddress", query = "SELECT o FROM Orders o WHERE o.shipAddress = :shipAddress")
    , @NamedQuery(name = "Orders.findByShipCity", query = "SELECT o FROM Orders o WHERE o.shipCity = :shipCity")
    , @NamedQuery(name = "Orders.findByShipPostalCode", query = "SELECT o FROM Orders o WHERE o.shipPostalCode = :shipPostalCode")
    , @NamedQuery(name = "Orders.findByShipCost", query = "SELECT o FROM Orders o WHERE o.shipCost = :shipCost")
    , @NamedQuery(name = "Orders.findByShipCompany", query = "SELECT o FROM Orders o WHERE o.shipCompany = :shipCompany")
    , @NamedQuery(name = "Orders.findByTrackingnumber", query = "SELECT o FROM Orders o WHERE o.trackingnumber = :trackingnumber")
    , @NamedQuery(name = "Orders.findByOrderTotal", query = "SELECT o FROM Orders o WHERE o.orderTotal = :orderTotal")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Order_Number")
    private String orderNumber;
    @Basic(optional = false)
    @Column(name = "Ship_fname")
    private String shipfname;
    @Basic(optional = false)
    @Column(name = "Ship_lname")
    private String shiplname;
    @Basic(optional = false)
    @Column(name = "Phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "Order_Date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Column(name = "Ship_Date")
    @Temporal(TemporalType.DATE)
    private Date shipDate;
    @Basic(optional = false)
    @Column(name = "Ship_Address")
    private String shipAddress;
    @Basic(optional = false)
    @Column(name = "Ship_City")
    private String shipCity;
    @Basic(optional = false)
    @Column(name = "Ship_Postal_Code")
    private String shipPostalCode;
    @Basic(optional = false)
    @Column(name = "Ship_Cost")
    private double shipCost;
    @Column(name = "Ship_Company")
    private String shipCompany;
    @Column(name = "Tracking_number")
    private String trackingnumber;
    @Basic(optional = false)
    @Column(name = "Order_Total")
    private double orderTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderNumber", fetch = FetchType.EAGER)
    private List<OrderItem> orderItemList;
    @JoinColumn(name = "Customer", referencedColumnName = "Email")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User customer;
    @JoinColumn(name = "Ship_Province", referencedColumnName = "Province_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Provinces shipProvince;
    @JoinColumn(name = "Order_stat", referencedColumnName = "Stat_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private OrderStatus orderstat;

    /**
     *
     */
    public Orders() {
    }

    /**
     *
     * @param orderNumber
     */
    public Orders(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     *
     * @param orderNumber
     * @param shipfname
     * @param shiplname
     * @param phone
     * @param orderDate
     * @param shipAddress
     * @param shipCity
     * @param shipPostalCode
     * @param shipCost
     * @param orderTotal
     */
    public Orders(String orderNumber, String shipfname, String shiplname, String phone, Date orderDate, String shipAddress, String shipCity, String shipPostalCode, double shipCost, double orderTotal) {
        this.orderNumber = orderNumber;
        this.shipfname = shipfname;
        this.shiplname = shiplname;
        this.phone = phone;
        this.orderDate = orderDate;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipPostalCode = shipPostalCode;
        this.shipCost = shipCost;
        this.orderTotal = orderTotal;
    }

    /**
     *
     * @return
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     *
     * @param orderNumber
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     *
     * @return
     */
    public String getShipfname() {
        return shipfname;
    }

    /**
     *
     * @param shipfname
     */
    public void setShipfname(String shipfname) {
        this.shipfname = shipfname;
    }

    /**
     *
     * @return
     */
    public String getShiplname() {
        return shiplname;
    }

    /**
     *
     * @param shiplname
     */
    public void setShiplname(String shiplname) {
        this.shiplname = shiplname;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     *
     * @param orderDate
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     *
     * @return
     */
    public Date getShipDate() {
        return shipDate;
    }

    /**
     *
     * @param shipDate
     */
    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    /**
     *
     * @return
     */
    public String getShipAddress() {
        return shipAddress;
    }

    /**
     *
     * @param shipAddress
     */
    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    /**
     *
     * @return
     */
    public String getShipCity() {
        return shipCity;
    }

    /**
     *
     * @param shipCity
     */
    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    /**
     *
     * @return
     */
    public String getShipPostalCode() {
        return shipPostalCode;
    }

    /**
     *
     * @param shipPostalCode
     */
    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    /**
     *
     * @return
     */
    public double getShipCost() {
        return shipCost;
    }

    /**
     *
     * @param shipCost
     */
    public void setShipCost(double shipCost) {
        this.shipCost = shipCost;
    }

    /**
     *
     * @return
     */
    public String getShipCompany() {
        return shipCompany;
    }

    /**
     *
     * @param shipCompany
     */
    public void setShipCompany(String shipCompany) {
        this.shipCompany = shipCompany;
    }

    /**
     *
     * @return
     */
    public String getTrackingnumber() {
        return trackingnumber;
    }

    /**
     *
     * @param trackingnumber
     */
    public void setTrackingnumber(String trackingnumber) {
        this.trackingnumber = trackingnumber;
    }

    /**
     *
     * @return
     */
    public double getOrderTotal() {
        return orderTotal;
    }

    /**
     *
     * @param orderTotal
     */
    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    /**
     *
     * @param orderItemList
     */
    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    /**
     *
     * @return
     */
    public User getCustomer() {
        return customer;
    }

    /**
     *
     * @param customer
     */
    public void setCustomer(User customer) {
        this.customer = customer;
    }

    /**
     *
     * @return
     */
    public Provinces getShipProvince() {
        return shipProvince;
    }

    /**
     *
     * @param shipProvince
     */
    public void setShipProvince(Provinces shipProvince) {
        this.shipProvince = shipProvince;
    }

    /**
     *
     * @return
     */
    public OrderStatus getOrderstat() {
        return orderstat;
    }

    /**
     *
     * @param orderstat
     */
    public void setOrderstat(OrderStatus orderstat) {
        this.orderstat = orderstat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderNumber != null ? orderNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderNumber == null && other.orderNumber != null) || (this.orderNumber != null && !this.orderNumber.equals(other.orderNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Orders[ orderNumber=" + orderNumber + " ]";
    }
    
}
