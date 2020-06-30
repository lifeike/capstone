/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "order_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderStatus.findAll", query = "SELECT o FROM OrderStatus o")
    , @NamedQuery(name = "OrderStatus.findByStatID", query = "SELECT o FROM OrderStatus o WHERE o.statID = :statID")
    , @NamedQuery(name = "OrderStatus.findByStatDescription", query = "SELECT o FROM OrderStatus o WHERE o.statDescription = :statDescription")})
public class OrderStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Stat_ID")
    private Integer statID;
    @Basic(optional = false)
    @Column(name = "Stat_Description")
    private String statDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderstat", fetch = FetchType.EAGER)
    private List<Orders> ordersList;

    /**
     *
     */
    public OrderStatus() {
    }

    /**
     *
     * @param statID
     */
    public OrderStatus(Integer statID) {
        this.statID = statID;
    }

    /**
     *
     * @param statID
     * @param statDescription
     */
    public OrderStatus(Integer statID, String statDescription) {
        this.statID = statID;
        this.statDescription = statDescription;
    }

    /**
     *
     * @return
     */
    public Integer getStatID() {
        return statID;
    }

    /**
     *
     * @param statID
     */
    public void setStatID(Integer statID) {
        this.statID = statID;
    }

    /**
     *
     * @return
     */
    public String getStatDescription() {
        return statDescription;
    }

    /**
     *
     * @param statDescription
     */
    public void setStatDescription(String statDescription) {
        this.statDescription = statDescription;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public List<Orders> getOrdersList() {
        return ordersList;
    }

    /**
     *
     * @param ordersList
     */
    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statID != null ? statID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderStatus)) {
            return false;
        }
        OrderStatus other = (OrderStatus) object;
        if ((this.statID == null && other.statID != null) || (this.statID != null && !this.statID.equals(other.statID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.OrderStatus[ statID=" + statID + " ]";
    }
    
}
