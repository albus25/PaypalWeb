/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Albus
 */
@Entity
@Table(name = "route_tb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteTb.findAll", query = "SELECT r FROM RouteTb r"),
    @NamedQuery(name = "RouteTb.findByRouteId", query = "SELECT r FROM RouteTb r WHERE r.routeId = :routeId"),
    @NamedQuery(name = "RouteTb.findByName", query = "SELECT r FROM RouteTb r WHERE r.name = :name"),
    @NamedQuery(name = "RouteTb.findByLongitude", query = "SELECT r FROM RouteTb r WHERE r.longitude = :longitude"),
    @NamedQuery(name = "RouteTb.findByLatitude", query = "SELECT r FROM RouteTb r WHERE r.latitude = :latitude"),
    @NamedQuery(name = "RouteTb.findByPincode", query = "SELECT r FROM RouteTb r WHERE r.pincode = :pincode"),
    @NamedQuery(name = "RouteTb.findByOrderId", query = "SELECT r FROM RouteTb r WHERE r.orderId = :orderId")})
public class RouteTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ROUTE_ID")
    private Integer routeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LONGITUDE")
    private int longitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LATITUDE")
    private int latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PINCODE")
    private int pincode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDER_ID")
    private int orderId;

    public RouteTb() {
    }

    public RouteTb(Integer routeId) {
        this.routeId = routeId;
    }

    public RouteTb(Integer routeId, String name, int longitude, int latitude, int pincode, int orderId) {
        this.routeId = routeId;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.pincode = pincode;
        this.orderId = orderId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routeId != null ? routeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RouteTb)) {
            return false;
        }
        RouteTb other = (RouteTb) object;
        if ((this.routeId == null && other.routeId != null) || (this.routeId != null && !this.routeId.equals(other.routeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.RouteTb[ routeId=" + routeId + " ]";
    }
    
}
