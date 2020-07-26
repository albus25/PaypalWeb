/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Albus
 */
@Entity
@Table(name = "fuel_type_tb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuelTypeTb.findAll", query = "SELECT f FROM FuelTypeTb f"),
    @NamedQuery(name = "FuelTypeTb.findById", query = "SELECT f FROM FuelTypeTb f WHERE f.id = :id"),
    @NamedQuery(name = "FuelTypeTb.findByType", query = "SELECT f FROM FuelTypeTb f WHERE f.type = :type"),
    @NamedQuery(name = "FuelTypeTb.findByCurrentPrice", query = "SELECT f FROM FuelTypeTb f WHERE f.currentPrice = :currentPrice")})
public class FuelTypeTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CURRENT_PRICE")
    private double currentPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fuelTypeId")
    private Collection<MyTruckTb> myTruckTbCollection;

    public FuelTypeTb() {
    }

    public FuelTypeTb(Integer id) {
        this.id = id;
    }

    public FuelTypeTb(Integer id, String type, double currentPrice) {
        this.id = id;
        this.type = type;
        this.currentPrice = currentPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @XmlTransient
    public Collection<MyTruckTb> getMyTruckTbCollection() {
        return myTruckTbCollection;
    }

    public void setMyTruckTbCollection(Collection<MyTruckTb> myTruckTbCollection) {
        this.myTruckTbCollection = myTruckTbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuelTypeTb)) {
            return false;
        }
        FuelTypeTb other = (FuelTypeTb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.FuelTypeTb[ id=" + id + " ]";
    }
    
}
