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
@Table(name = "provinces")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provinces.findAll", query = "SELECT p FROM Provinces p")
    , @NamedQuery(name = "Provinces.findByProvinceID", query = "SELECT p FROM Provinces p WHERE p.provinceID = :provinceID")
    , @NamedQuery(name = "Provinces.findByProvinceName", query = "SELECT p FROM Provinces p WHERE p.provinceName = :provinceName")
    , @NamedQuery(name = "Provinces.findByTaxPercentage", query = "SELECT p FROM Provinces p WHERE p.taxPercentage = :taxPercentage")})
public class Provinces implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Province_ID")
    private Integer provinceID;
    @Basic(optional = false)
    @Column(name = "Province_Name")
    private String provinceName;
    @Basic(optional = false)
    @Column(name = "Tax_Percentage")
    private double taxPercentage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipProvince", fetch = FetchType.EAGER)
    private List<Orders> ordersList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "province", fetch = FetchType.EAGER)
    private List<User> userList;

    /**
     *
     */
    public Provinces() {
    }

    /**
     *
     * @param provinceID
     */
    public Provinces(Integer provinceID) {
        this.provinceID = provinceID;
    }

    /**
     *
     * @param provinceID
     * @param provinceName
     * @param taxPercentage
     */
    public Provinces(Integer provinceID, String provinceName, double taxPercentage) {
        this.provinceID = provinceID;
        this.provinceName = provinceName;
        this.taxPercentage = taxPercentage;
    }

    /**
     *
     * @return
     */
    public Integer getProvinceID() {
        return provinceID;
    }

    /**
     *
     * @param provinceID
     */
    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    /**
     *
     * @return
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     *
     * @param provinceName
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     *
     * @return
     */
    public double getTaxPercentage() {
        return taxPercentage;
    }

    /**
     *
     * @param taxPercentage
     */
    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
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

    /**
     *
     * @return
     */
    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    /**
     *
     * @param userList
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinceID != null ? provinceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provinces)) {
            return false;
        }
        Provinces other = (Provinces) object;
        if ((this.provinceID == null && other.provinceID != null) || (this.provinceID != null && !this.provinceID.equals(other.provinceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Provinces[ provinceID=" + provinceID + " ]";
    }
    
}
