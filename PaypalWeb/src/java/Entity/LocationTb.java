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
@Table(name = "location_tb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocationTb.findAll", query = "SELECT l FROM LocationTb l"),
    @NamedQuery(name = "LocationTb.findById", query = "SELECT l FROM LocationTb l WHERE l.id = :id"),
    @NamedQuery(name = "LocationTb.findByLocationName", query = "SELECT l FROM LocationTb l WHERE l.locationName = :locationName"),
    @NamedQuery(name = "LocationTb.findByLocationAddress", query = "SELECT l FROM LocationTb l WHERE l.locationAddress = :locationAddress"),
    @NamedQuery(name = "LocationTb.findByLongitude", query = "SELECT l FROM LocationTb l WHERE l.longitude = :longitude"),
    @NamedQuery(name = "LocationTb.findByLatitude", query = "SELECT l FROM LocationTb l WHERE l.latitude = :latitude"),
    @NamedQuery(name = "LocationTb.findByDescription", query = "SELECT l FROM LocationTb l WHERE l.description = :description")})
public class LocationTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOCATION_NAME")
    private int locationName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "LOCATION_ADDRESS")
    private String locationAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LONGITUDE")
    private double longitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LATITUDE")
    private double latitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departurePoint")
    private Collection<RequestOrderTb> requestOrderTbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "endingPoint")
    private Collection<RequestOrderTb> requestOrderTbCollection1;

    public LocationTb() {
    }

    public LocationTb(Integer id) {
        this.id = id;
    }

    public LocationTb(Integer id, int locationName, String locationAddress, double longitude, double latitude, String description) {
        this.id = id;
        this.locationName = locationName;
        this.locationAddress = locationAddress;
        this.longitude = longitude;
        this.latitude = latitude;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLocationName() {
        return locationName;
    }

    public void setLocationName(int locationName) {
        this.locationName = locationName;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<RequestOrderTb> getRequestOrderTbCollection() {
        return requestOrderTbCollection;
    }

    public void setRequestOrderTbCollection(Collection<RequestOrderTb> requestOrderTbCollection) {
        this.requestOrderTbCollection = requestOrderTbCollection;
    }

    @XmlTransient
    public Collection<RequestOrderTb> getRequestOrderTbCollection1() {
        return requestOrderTbCollection1;
    }

    public void setRequestOrderTbCollection1(Collection<RequestOrderTb> requestOrderTbCollection1) {
        this.requestOrderTbCollection1 = requestOrderTbCollection1;
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
        if (!(object instanceof LocationTb)) {
            return false;
        }
        LocationTb other = (LocationTb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.LocationTb[ id=" + id + " ]";
    }
    
}
