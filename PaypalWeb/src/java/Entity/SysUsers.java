/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Albus
 */
@Entity
@Table(name = "sys_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysUsers.findAll", query = "SELECT s FROM SysUsers s"),
    @NamedQuery(name = "SysUsers.findByUserid", query = "SELECT s FROM SysUsers s WHERE s.userid = :userid"),
    @NamedQuery(name = "SysUsers.findByUsername", query = "SELECT s FROM SysUsers s WHERE s.username = :username"),
    @NamedQuery(name = "SysUsers.findByEmail", query = "SELECT s FROM SysUsers s WHERE s.email = :email"),
    @NamedQuery(name = "SysUsers.findByMobile", query = "SELECT s FROM SysUsers s WHERE s.mobile = :mobile"),
    @NamedQuery(name = "SysUsers.findByAddress", query = "SELECT s FROM SysUsers s WHERE s.address = :address"),
    @NamedQuery(name = "SysUsers.findByFullname", query = "SELECT s FROM SysUsers s WHERE s.fullname = :fullname"),
    @NamedQuery(name = "SysUsers.findByPassword", query = "SELECT s FROM SysUsers s WHERE s.password = :password"),
    @NamedQuery(name = "SysUsers.findByProfile", query = "SELECT s FROM SysUsers s WHERE s.profile = :profile"),
    @NamedQuery(name = "SysUsers.findByStatus", query = "SELECT s FROM SysUsers s WHERE s.status = :status"),
    @NamedQuery(name = "SysUsers.findByCreatedAt", query = "SELECT s FROM SysUsers s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "SysUsers.findByUpdatedAt", query = "SELECT s FROM SysUsers s WHERE s.updatedAt = :updatedAt")})
public class SysUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USERID")
    private Integer userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USERNAME")
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 20)
    @Column(name = "MOBILE")
    private String mobile;
    @Size(max = 30)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 50)
    @Column(name = "FULLNAME")
    private String fullname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 200)
    @Column(name = "PROFILE")
    private String profile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<UserGroup> userGroupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "truckOwnerId")
    private Collection<RequestQuoteTb> requestQuoteTbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "truckOwnerId")
    private Collection<OrderTb> orderTbCollection;
    @JoinColumn(name = "STATE_ID", referencedColumnName = "STATE_ID")
    @ManyToOne
    private StateTb stateId;
    @JoinColumn(name = "CITY_ID", referencedColumnName = "CITY_ID")
    @ManyToOne
    private CityTb cityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargoOwnerId")
    private Collection<RequestOrderTb> requestOrderTbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "truckOwnerId")
    private Collection<DriverTb> driverTbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "truckOwnerId")
    private Collection<MyTruckTb> myTruckTbCollection;

    public SysUsers() {
    }

    public SysUsers(Integer userid) {
        this.userid = userid;
    }

    public SysUsers(Integer userid, String username, String email, String password, int status, Date createdAt) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @XmlTransient
    public Collection<UserGroup> getUserGroupCollection() {
        return userGroupCollection;
    }

    public void setUserGroupCollection(Collection<UserGroup> userGroupCollection) {
        this.userGroupCollection = userGroupCollection;
    }

    @XmlTransient
    public Collection<RequestQuoteTb> getRequestQuoteTbCollection() {
        return requestQuoteTbCollection;
    }

    public void setRequestQuoteTbCollection(Collection<RequestQuoteTb> requestQuoteTbCollection) {
        this.requestQuoteTbCollection = requestQuoteTbCollection;
    }

    @XmlTransient
    public Collection<OrderTb> getOrderTbCollection() {
        return orderTbCollection;
    }

    public void setOrderTbCollection(Collection<OrderTb> orderTbCollection) {
        this.orderTbCollection = orderTbCollection;
    }

    public StateTb getStateId() {
        return stateId;
    }

    public void setStateId(StateTb stateId) {
        this.stateId = stateId;
    }

    public CityTb getCityId() {
        return cityId;
    }

    public void setCityId(CityTb cityId) {
        this.cityId = cityId;
    }

    @XmlTransient
    public Collection<RequestOrderTb> getRequestOrderTbCollection() {
        return requestOrderTbCollection;
    }

    public void setRequestOrderTbCollection(Collection<RequestOrderTb> requestOrderTbCollection) {
        this.requestOrderTbCollection = requestOrderTbCollection;
    }

    @XmlTransient
    public Collection<DriverTb> getDriverTbCollection() {
        return driverTbCollection;
    }

    public void setDriverTbCollection(Collection<DriverTb> driverTbCollection) {
        this.driverTbCollection = driverTbCollection;
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
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysUsers)) {
            return false;
        }
        SysUsers other = (SysUsers) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.SysUsers[ userid=" + userid + " ]";
    }
    
}
