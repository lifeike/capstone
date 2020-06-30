package models;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 794473
 */
@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")
    , @NamedQuery(name = "Item.findByUpsc", query = "SELECT i FROM Item i WHERE i.upsc = :upsc")
    , @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name")
    , @NamedQuery(name = "Item.findByDescription", query = "SELECT i FROM Item i WHERE i.description = :description")
    , @NamedQuery(name = "Item.findByCost", query = "SELECT i FROM Item i WHERE i.cost = :cost")
    , @NamedQuery(name = "Item.findByRetailCost", query = "SELECT i FROM Item i WHERE i.retailCost = :retailCost")
    , @NamedQuery(name = "Item.findByImageLink", query = "SELECT i FROM Item i WHERE i.imageLink = :imageLink")
    , @NamedQuery(name = "Item.findByQuantity", query = "SELECT i FROM Item i WHERE i.quantity = :quantity")
    , @NamedQuery(name = "Item.findByStatus", query = "SELECT i FROM Item i WHERE i.status = :status")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Upsc")
    private String upsc;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @Column(name = "Cost")
    private double cost;
    @Basic(optional = false)
    @Column(name = "Retail_Cost")
    private double retailCost;
    @Basic(optional = false)
    @Column(name = "Image_Link")
    private String imageLink;
    @Basic(optional = false)
    @Column(name = "Quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "Status")
    private boolean status;
    @JoinColumn(name = "Category", referencedColumnName = "Category_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Category category;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item", fetch = FetchType.EAGER)
    private List<OrderItem> orderItemList;

    /**
     *
     */
    public Item() {
    }

    /**
     *
     * @param upsc
     */
    public Item(String upsc) {
        this.upsc = upsc;
    }

    /**
     *
     * @param upsc
     * @param name
     * @param description
     * @param cost
     * @param retailCost
     * @param imageLink
     * @param quantity
     * @param status
     */
    public Item(String upsc, String name, String description, double cost, double retailCost, String imageLink, int quantity, boolean status) {
        this.upsc = upsc;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.retailCost = retailCost;
        this.imageLink = imageLink;
        this.quantity = quantity;
        this.status = status;
    }

    /**
     *
     * @return
     */
    public String getUpsc() {
        return upsc;
    }

    /**
     *
     * @param upsc
     */
    public void setUpsc(String upsc) {
        this.upsc = upsc;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
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
    public double getRetailCost() {
        return retailCost;
    }

    /**
     *
     * @param retailCost
     */
    public void setRetailCost(double retailCost) {
        this.retailCost = retailCost;
    }

    /**
     *
     * @return
     */
    public String getImageLink() {
        return imageLink;
    }

    /**
     *
     * @param imageLink
     */
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
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
    public boolean getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public Category getCategory() {
        return category;
    }

    /**
     *
     * @param category
     */
    public void setCategory(Category category) {
        this.category = category;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (upsc != null ? upsc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.upsc == null && other.upsc != null) || (this.upsc != null && !this.upsc.equals(other.upsc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Item[ upsc=" + upsc + " ]";
    }

}
