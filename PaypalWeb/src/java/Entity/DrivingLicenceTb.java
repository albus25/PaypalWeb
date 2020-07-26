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
@Table(name = "driving_licence_tb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DrivingLicenceTb.findAll", query = "SELECT d FROM DrivingLicenceTb d"),
    @NamedQuery(name = "DrivingLicenceTb.findByTypeid", query = "SELECT d FROM DrivingLicenceTb d WHERE d.typeid = :typeid"),
    @NamedQuery(name = "DrivingLicenceTb.findByTypename", query = "SELECT d FROM DrivingLicenceTb d WHERE d.typename = :typename")})
public class DrivingLicenceTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TYPEID")
    private Integer typeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TYPENAME")
    private String typename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drivingTypeId")
    private Collection<DriverTb> driverTbCollection;

    public DrivingLicenceTb() {
    }

    public DrivingLicenceTb(Integer typeid) {
        this.typeid = typeid;
    }

    public DrivingLicenceTb(Integer typeid, String typename) {
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
    public Collection<DriverTb> getDriverTbCollection() {
        return driverTbCollection;
    }

    public void setDriverTbCollection(Collection<DriverTb> driverTbCollection) {
        this.driverTbCollection = driverTbCollection;
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
        if (!(object instanceof DrivingLicenceTb)) {
            return false;
        }
        DrivingLicenceTb other = (DrivingLicenceTb) object;
        if ((this.typeid == null && other.typeid != null) || (this.typeid != null && !this.typeid.equals(other.typeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DrivingLicenceTb[ typeid=" + typeid + " ]";
    }
    
}
