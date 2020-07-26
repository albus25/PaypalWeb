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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "city_tb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CityTb.findAll", query = "SELECT c FROM CityTb c"),
    @NamedQuery(name = "CityTb.findByCityId", query = "SELECT c FROM CityTb c WHERE c.cityId = :cityId"),
    @NamedQuery(name = "CityTb.findByCityName", query = "SELECT c FROM CityTb c WHERE c.cityName = :cityName")})
public class CityTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CITY_ID")
    private Integer cityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CITY_NAME")
    private String cityName;
    @OneToMany(mappedBy = "cityId")
    private Collection<SysUsers> sysUsersCollection;
    @JoinColumn(name = "STATE_ID", referencedColumnName = "STATE_ID")
    @ManyToOne(optional = false)
    private StateTb stateId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityId")
    private Collection<DriverTb> driverTbCollection;

    public CityTb() {
    }

    public CityTb(Integer cityId) {
        this.cityId = cityId;
    }

    public CityTb(Integer cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @XmlTransient
    public Collection<SysUsers> getSysUsersCollection() {
        return sysUsersCollection;
    }

    public void setSysUsersCollection(Collection<SysUsers> sysUsersCollection) {
        this.sysUsersCollection = sysUsersCollection;
    }

    public StateTb getStateId() {
        return stateId;
    }

    public void setStateId(StateTb stateId) {
        this.stateId = stateId;
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
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CityTb)) {
            return false;
        }
        CityTb other = (CityTb) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CityTb[ cityId=" + cityId + " ]";
    }
    
}
