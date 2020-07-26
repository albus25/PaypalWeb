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
@Table(name = "state_tb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StateTb.findAll", query = "SELECT s FROM StateTb s"),
    @NamedQuery(name = "StateTb.findByStateId", query = "SELECT s FROM StateTb s WHERE s.stateId = :stateId"),
    @NamedQuery(name = "StateTb.findByStateName", query = "SELECT s FROM StateTb s WHERE s.stateName = :stateName")})
public class StateTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "STATE_ID")
    private Integer stateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "STATE_NAME")
    private String stateName;
    @OneToMany(mappedBy = "stateId")
    private Collection<SysUsers> sysUsersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<CityTb> cityTbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<DriverTb> driverTbCollection;

    public StateTb() {
    }

    public StateTb(Integer stateId) {
        this.stateId = stateId;
    }

    public StateTb(Integer stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @XmlTransient
    public Collection<SysUsers> getSysUsersCollection() {
        return sysUsersCollection;
    }

    public void setSysUsersCollection(Collection<SysUsers> sysUsersCollection) {
        this.sysUsersCollection = sysUsersCollection;
    }

    @XmlTransient
    public Collection<CityTb> getCityTbCollection() {
        return cityTbCollection;
    }

    public void setCityTbCollection(Collection<CityTb> cityTbCollection) {
        this.cityTbCollection = cityTbCollection;
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
        hash += (stateId != null ? stateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StateTb)) {
            return false;
        }
        StateTb other = (StateTb) object;
        if ((this.stateId == null && other.stateId != null) || (this.stateId != null && !this.stateId.equals(other.stateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.StateTb[ stateId=" + stateId + " ]";
    }
    
}
