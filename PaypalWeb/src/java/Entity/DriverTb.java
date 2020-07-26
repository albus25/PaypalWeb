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
@Table(name = "driver_tb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DriverTb.findAll", query = "SELECT d FROM DriverTb d"),
    @NamedQuery(name = "DriverTb.findById", query = "SELECT d FROM DriverTb d WHERE d.id = :id"),
    @NamedQuery(name = "DriverTb.findByFirstName", query = "SELECT d FROM DriverTb d WHERE d.firstName = :firstName"),
    @NamedQuery(name = "DriverTb.findByLastName", query = "SELECT d FROM DriverTb d WHERE d.lastName = :lastName"),
    @NamedQuery(name = "DriverTb.findByProfile", query = "SELECT d FROM DriverTb d WHERE d.profile = :profile"),
    @NamedQuery(name = "DriverTb.findByExperience", query = "SELECT d FROM DriverTb d WHERE d.experience = :experience"),
    @NamedQuery(name = "DriverTb.findBySalary", query = "SELECT d FROM DriverTb d WHERE d.salary = :salary"),
    @NamedQuery(name = "DriverTb.findByStatus", query = "SELECT d FROM DriverTb d WHERE d.status = :status"),
    @NamedQuery(name = "DriverTb.findByLicenceNo", query = "SELECT d FROM DriverTb d WHERE d.licenceNo = :licenceNo"),
    @NamedQuery(name = "DriverTb.findByDlIssueDate", query = "SELECT d FROM DriverTb d WHERE d.dlIssueDate = :dlIssueDate"),
    @NamedQuery(name = "DriverTb.findByDlValidTill", query = "SELECT d FROM DriverTb d WHERE d.dlValidTill = :dlValidTill"),
    @NamedQuery(name = "DriverTb.findByCreatedAt", query = "SELECT d FROM DriverTb d WHERE d.createdAt = :createdAt"),
    @NamedQuery(name = "DriverTb.findByDob", query = "SELECT d FROM DriverTb d WHERE d.dob = :dob"),
    @NamedQuery(name = "DriverTb.findByMobileNo", query = "SELECT d FROM DriverTb d WHERE d.mobileNo = :mobileNo"),
    @NamedQuery(name = "DriverTb.findByAddress", query = "SELECT d FROM DriverTb d WHERE d.address = :address"),
    @NamedQuery(name = "DriverTb.findByZipcode", query = "SELECT d FROM DriverTb d WHERE d.zipcode = :zipcode"),
    @NamedQuery(name = "DriverTb.findByMobileType", query = "SELECT d FROM DriverTb d WHERE d.mobileType = :mobileType"),
    @NamedQuery(name = "DriverTb.findByBloodGp", query = "SELECT d FROM DriverTb d WHERE d.bloodGp = :bloodGp"),
    @NamedQuery(name = "DriverTb.findByEnable", query = "SELECT d FROM DriverTb d WHERE d.enable = :enable")})
public class DriverTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "PROFILE")
    private String profile;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "EXPERIENCE")
    private Float experience;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALARY")
    private double salary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LICENCE_NO")
    private String licenceNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DL_ISSUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date dlIssueDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DL_VALID_TILL")
    @Temporal(TemporalType.DATE)
    private Date dlValidTill;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MOBILE_NO")
    private String mobileNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 50)
    @Column(name = "ZIPCODE")
    private String zipcode;
    @Size(max = 20)
    @Column(name = "MOBILE_TYPE")
    private String mobileType;
    @Size(max = 10)
    @Column(name = "BLOOD_GP")
    private String bloodGp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENABLE")
    private int enable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driverId")
    private Collection<OrderTb> orderTbCollection;
    @JoinColumn(name = "TRUCK_OWNER_ID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private SysUsers truckOwnerId;
    @JoinColumn(name = "DRIVING_TYPE_ID", referencedColumnName = "TYPEID")
    @ManyToOne(optional = false)
    private DrivingLicenceTb drivingTypeId;
    @JoinColumn(name = "STATE_ID", referencedColumnName = "STATE_ID")
    @ManyToOne(optional = false)
    private StateTb stateId;
    @JoinColumn(name = "CITY_ID", referencedColumnName = "CITY_ID")
    @ManyToOne(optional = false)
    private CityTb cityId;

    public DriverTb() {
    }

    public DriverTb(Integer id) {
        this.id = id;
    }

    public DriverTb(Integer id, String firstName, String lastName, String profile, double salary, int status, String licenceNo, Date dlIssueDate, Date dlValidTill, Date createdAt, Date dob, String mobileNo, String address, int enable) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profile = profile;
        this.salary = salary;
        this.status = status;
        this.licenceNo = licenceNo;
        this.dlIssueDate = dlIssueDate;
        this.dlValidTill = dlValidTill;
        this.createdAt = createdAt;
        this.dob = dob;
        this.mobileNo = mobileNo;
        this.address = address;
        this.enable = enable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Float getExperience() {
        return experience;
    }

    public void setExperience(Float experience) {
        this.experience = experience;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public Date getDlIssueDate() {
        return dlIssueDate;
    }

    public void setDlIssueDate(Date dlIssueDate) {
        this.dlIssueDate = dlIssueDate;
    }

    public Date getDlValidTill() {
        return dlValidTill;
    }

    public void setDlValidTill(Date dlValidTill) {
        this.dlValidTill = dlValidTill;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getMobileType() {
        return mobileType;
    }

    public void setMobileType(String mobileType) {
        this.mobileType = mobileType;
    }

    public String getBloodGp() {
        return bloodGp;
    }

    public void setBloodGp(String bloodGp) {
        this.bloodGp = bloodGp;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    @XmlTransient
    public Collection<OrderTb> getOrderTbCollection() {
        return orderTbCollection;
    }

    public void setOrderTbCollection(Collection<OrderTb> orderTbCollection) {
        this.orderTbCollection = orderTbCollection;
    }

    public SysUsers getTruckOwnerId() {
        return truckOwnerId;
    }

    public void setTruckOwnerId(SysUsers truckOwnerId) {
        this.truckOwnerId = truckOwnerId;
    }

    public DrivingLicenceTb getDrivingTypeId() {
        return drivingTypeId;
    }

    public void setDrivingTypeId(DrivingLicenceTb drivingTypeId) {
        this.drivingTypeId = drivingTypeId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DriverTb)) {
            return false;
        }
        DriverTb other = (DriverTb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DriverTb[ id=" + id + " ]";
    }
    
}
