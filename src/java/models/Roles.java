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
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r")
    , @NamedQuery(name = "Roles.findByRoleID", query = "SELECT r FROM Roles r WHERE r.roleID = :roleID")
    , @NamedQuery(name = "Roles.findByRoleDescription", query = "SELECT r FROM Roles r WHERE r.roleDescription = :roleDescription")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Role_ID")
    private Integer roleID;
    @Basic(optional = false)
    @Column(name = "Role_Description")
    private String roleDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role", fetch = FetchType.EAGER)
    private List<User> userList;

    /**
     *
     */
    public Roles() {
    }

    /**
     *
     * @param roleID
     */
    public Roles(Integer roleID) {
        this.roleID = roleID;
    }

    /**
     *
     * @param roleID
     * @param roleDescription
     */
    public Roles(Integer roleID, String roleDescription) {
        this.roleID = roleID;
        this.roleDescription = roleDescription;
    }

    /**
     *
     * @return
     */
    public Integer getRoleID() {
        return roleID;
    }

    /**
     *
     * @param roleID
     */
    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    /**
     *
     * @return
     */
    public String getRoleDescription() {
        return roleDescription;
    }

    /**
     *
     * @param roleDescription
     */
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
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
        hash += (roleID != null ? roleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.roleID == null && other.roleID != null) || (this.roleID != null && !this.roleID.equals(other.roleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Roles[ roleID=" + roleID + " ]";
    }
    
}
