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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 794473
 */
@Entity
@Table(name = "contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")
    , @NamedQuery(name = "Contact.findByIssueNumber", query = "SELECT c FROM Contact c WHERE c.issueNumber = :issueNumber")
    , @NamedQuery(name = "Contact.findByName", query = "SELECT c FROM Contact c WHERE c.name = :name")
    , @NamedQuery(name = "Contact.findByEmail", query = "SELECT c FROM Contact c WHERE c.email = :email")
    , @NamedQuery(name = "Contact.findByIssue", query = "SELECT c FROM Contact c WHERE c.issue = :issue")})
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "issueNumber")
    private Integer issueNumber;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Issue")
    private String issue;

    /**
     *
     */
    public Contact() {
    }

    /**
     *
     * @param issueNumber
     */
    public Contact(Integer issueNumber) {
        this.issueNumber = issueNumber;
    }

    /**
     *
     * @param issueNumber
     * @param name
     * @param email
     * @param issue
     */
    public Contact(Integer issueNumber, String name, String email, String issue) {
        this.issueNumber = issueNumber;
        this.name = name;
        this.email = email;
        this.issue = issue;
    }

    /**
     *
     * @return
     */
    public Integer getIssueNumber() {
        return issueNumber;
    }

    /**
     *
     * @param issueNumber
     */
    public void setIssueNumber(Integer issueNumber) {
        this.issueNumber = issueNumber;
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
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getIssue() {
        return issue;
    }

    /**
     *
     * @param issue
     */
    public void setIssue(String issue) {
        this.issue = issue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (issueNumber != null ? issueNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.issueNumber == null && other.issueNumber != null) || (this.issueNumber != null && !this.issueNumber.equals(other.issueNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Contact[ issueNumber=" + issueNumber + " ]";
    }
    
}
