package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 794473 - Amitoj Singh
 */
@Entity
@Table(name = "category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
    , @NamedQuery(name = "Category.findByCategoryID", query = "SELECT c FROM Category c WHERE c.categoryID = :categoryID")
    , @NamedQuery(name = "Category.findByCategoryDescription", query = "SELECT c FROM Category c WHERE c.categoryDescription = :categoryDescription")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Category_ID")
    private Integer categoryID;
    @Basic(optional = false)
    @Column(name = "Category_Description")
    private String categoryDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.EAGER)
    private List<Item> itemList;

    /**
     *
     */
    public Category() {
    }

    /**
     *
     * @param categoryID
     */
    public Category(Integer categoryID) {
        this.categoryID = categoryID;
    }

    /**
     *
     * @param categoryID
     * @param categoryDescription
     */
    public Category(Integer categoryID, String categoryDescription) {
        this.categoryID = categoryID;
        this.categoryDescription = categoryDescription;
    }

    /**
     *
     * @return categoryID
     */
    public Integer getCategoryID() {
        return categoryID;
    }

    /**
     *
     * @param categoryID
     */
    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    /**
     *
     * @return description
     */
    public String getCategoryDescription() {
        return categoryDescription;
    }

    /**
     *
     * @param categoryDescription
     */
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    /**
     *
     * @return Item List
     */
    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    /**
     *
     * @param itemList
     */
    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryID != null ? categoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoryID == null && other.categoryID != null) || (this.categoryID != null && !this.categoryID.equals(other.categoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Category[ categoryID=" + categoryID + " ]";
    }
    
}
