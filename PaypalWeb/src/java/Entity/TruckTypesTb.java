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
@Table(name = "truck_types_tb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TruckTypesTb.findAll", query = "SELECT t FROM TruckTypesTb t"),
    @NamedQuery(name = "TruckTypesTb.findByTypeid", query = "SELECT t FROM TruckTypesTb t WHERE t.typeid = :typeid"),
    @NamedQuery(name = "TruckTypesTb.findByTypename", query = "SELECT t FROM TruckTypesTb t WHERE t.typename = :typename")})
public class TruckTypesTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TYPEID")
    private Integer typeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "TYPENAME")
    private String typename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "truckTypeId")
    private Collection<TruckModelTb> truckModelTbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "truckType")
    private Collection<RequestOrderTb> requestOrderTbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "truckTypeId")
    private Collection<MyTruckTb> myTruckTbCollection;

    public TruckTypesTb() {
    }

    public TruckTypesTb(Integer typeid) {
        this.typeid = typeid;
    }

    public TruckTypesTb(Integer typeid, String typename) {
        this.typeid = typeid;
        this.typename = typename;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @XmlTransient
    public Collection<TruckModelTb> getTruckModelTbCollection() {
        return truckModelTbCollection;
    }

    public void setTruckModelTbCollection(Collection<TruckModelTb> truckModelTbCollection) {
        this.truckModelTbCollection = truckModelTbCollection;
    }

    @XmlTransient
    public Collection<RequestOrderTb> getRequestOrderTbCollection() {
        return requestOrderTbCollection;
    }

    public void setRequestOrderTbCollection(Collection<RequestOrderTb> requestOrderTbCollection) {
        this.requestOrderTbCollection = requestOrderTbCollection;
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
        hash += (typeid != null ? typeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TruckTypesTb)) {
            return false;
        }
        TruckTypesTb other = (TruckTypesTb) object;
        if ((this.typeid == null && other.typeid != null) || (this.typeid != null && !this.typeid.equals(other.typeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TruckTypesTb[ typeid=" + typeid + " ]";
    }
    
}
