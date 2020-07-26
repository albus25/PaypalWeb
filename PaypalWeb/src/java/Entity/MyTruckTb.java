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
@Table(name = "my_truck_tb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MyTruckTb.findAll", query = "SELECT m FROM MyTruckTb m"),
    @NamedQuery(name = "MyTruckTb.findByMyTruckId", query = "SELECT m FROM MyTruckTb m WHERE m.myTruckId = :myTruckId"),
    @NamedQuery(name = "MyTruckTb.findByRegNo", query = "SELECT m FROM MyTruckTb m WHERE m.regNo = :regNo"),
    @NamedQuery(name = "MyTruckTb.findByChasisNo", query = "SELECT m FROM MyTruckTb m WHERE m.chasisNo = :chasisNo"),
    @NamedQuery(name = "MyTruckTb.findByEngineNo", query = "SELECT m FROM MyTruckTb m WHERE m.engineNo = :engineNo"),
    @NamedQuery(name = "MyTruckTb.findByOwnerName", query = "SELECT m FROM MyTruckTb m WHERE m.ownerName = :ownerName"),
    @NamedQuery(name = "MyTruckTb.findByOwnerAddress", query = "SELECT m FROM MyTruckTb m WHERE m.ownerAddress = :ownerAddress"),
    @NamedQuery(name = "MyTruckTb.findByOwnerContactNo", query = "SELECT m FROM MyTruckTb m WHERE m.ownerContactNo = :ownerContactNo"),
    @NamedQuery(name = "MyTruckTb.findByVehicleColor", query = "SELECT m FROM MyTruckTb m WHERE m.vehicleColor = :vehicleColor"),
    @NamedQuery(name = "MyTruckTb.findByManufacturer", query = "SELECT m FROM MyTruckTb m WHERE m.manufacturer = :manufacturer"),
    @NamedQuery(name = "MyTruckTb.findByVehicleValue", query = "SELECT m FROM MyTruckTb m WHERE m.vehicleValue = :vehicleValue"),
    @NamedQuery(name = "MyTruckTb.findByRegDate", query = "SELECT m FROM MyTruckTb m WHERE m.regDate = :regDate"),
    @NamedQuery(name = "MyTruckTb.findByInsuranceValidUpto", query = "SELECT m FROM MyTruckTb m WHERE m.insuranceValidUpto = :insuranceValidUpto"),
    @NamedQuery(name = "MyTruckTb.findByFitnessValidUpto", query = "SELECT m FROM MyTruckTb m WHERE m.fitnessValidUpto = :fitnessValidUpto"),
    @NamedQuery(name = "MyTruckTb.findByTaxValidUpto", query = "SELECT m FROM MyTruckTb m WHERE m.taxValidUpto = :taxValidUpto"),
    @NamedQuery(name = "MyTruckTb.findByPermitValidUpto", query = "SELECT m FROM MyTruckTb m WHERE m.permitValidUpto = :permitValidUpto"),
    @NamedQuery(name = "MyTruckTb.findByEnable", query = "SELECT m FROM MyTruckTb m WHERE m.enable = :enable"),
    @NamedQuery(name = "MyTruckTb.findByStatus", query = "SELECT m FROM MyTruckTb m WHERE m.status = :status"),
    @NamedQuery(name = "MyTruckTb.findByTruckImg", query = "SELECT m FROM MyTruckTb m WHERE m.truckImg = :truckImg"),
    @NamedQuery(name = "MyTruckTb.findByRegCertificate", query = "SELECT m FROM MyTruckTb m WHERE m.regCertificate = :regCertificate"),
    @NamedQuery(name = "MyTruckTb.findByInsuranceCertificate", query = "SELECT m FROM MyTruckTb m WHERE m.insuranceCertificate = :insuranceCertificate"),
    @NamedQuery(name = "MyTruckTb.findByEmissionCertificate", query = "SELECT m FROM MyTruckTb m WHERE m.emissionCertificate = :emissionCertificate"),
    @NamedQuery(name = "MyTruckTb.findByFitnessCertificate", query = "SELECT m FROM MyTruckTb m WHERE m.fitnessCertificate = :fitnessCertificate"),
    @NamedQuery(name = "MyTruckTb.findByRoadPermitCertificate", query = "SELECT m FROM MyTruckTb m WHERE m.roadPermitCertificate = :roadPermitCertificate"),
    @NamedQuery(name = "MyTruckTb.findByTdsCertificate", query = "SELECT m FROM MyTruckTb m WHERE m.tdsCertificate = :tdsCertificate")})
public class MyTruckTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MY_TRUCK_ID")
    private Integer myTruckId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "REG_NO")
    private String regNo;
    @Size(max = 250)
    @Column(name = "CHASIS_NO")
    private String chasisNo;
    @Size(max = 250)
    @Column(name = "ENGINE_NO")
    private String engineNo;
    @Size(max = 250)
    @Column(name = "OWNER_NAME")
    private String ownerName;
    @Size(max = 300)
    @Column(name = "OWNER_ADDRESS")
    private String ownerAddress;
    @Size(max = 50)
    @Column(name = "OWNER_CONTACT_NO")
    private String ownerContactNo;
    @Size(max = 250)
    @Column(name = "VEHICLE_COLOR")
    private String vehicleColor;
    @Size(max = 250)
    @Column(name = "MANUFACTURER")
    private String manufacturer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "VEHICLE_VALUE")
    private String vehicleValue;
    @Column(name = "REG_DATE")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    @Column(name = "INSURANCE_VALID_UPTO")
    @Temporal(TemporalType.DATE)
    private Date insuranceValidUpto;
    @Column(name = "FITNESS_VALID_UPTO")
    @Temporal(TemporalType.DATE)
    private Date fitnessValidUpto;
    @Column(name = "TAX_VALID_UPTO")
    @Temporal(TemporalType.DATE)
    private Date taxValidUpto;
    @Column(name = "PERMIT_VALID_UPTO")
    @Temporal(TemporalType.DATE)
    private Date permitValidUpto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENABLE")
    private int enable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "TRUCK_IMG")
    private String truckImg;
    @Size(max = 1000)
    @Column(name = "REG_CERTIFICATE")
    private String regCertificate;
    @Size(max = 1000)
    @Column(name = "INSURANCE_CERTIFICATE")
    private String insuranceCertificate;
    @Size(max = 1000)
    @Column(name = "EMISSION_CERTIFICATE")
    private String emissionCertificate;
    @Size(max = 1000)
    @Column(name = "FITNESS_CERTIFICATE")
    private String fitnessCertificate;
    @Size(max = 1000)
    @Column(name = "ROAD_PERMIT_CERTIFICATE")
    private String roadPermitCertificate;
    @Size(max = 1000)
    @Column(name = "TDS_CERTIFICATE")
    private String tdsCertificate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "truckId")
    private Collection<OrderTb> orderTbCollection;
    @JoinColumn(name = "TRUCK_TYPE_ID", referencedColumnName = "TYPEID")
    @ManyToOne(optional = false)
    private TruckTypesTb truckTypeId;
    @JoinColumn(name = "TRUCK_MODEL_ID", referencedColumnName = "TRUCK_MODEL_ID")
    @ManyToOne(optional = false)
    private TruckModelTb truckModelId;
    @JoinColumn(name = "FUEL_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FuelTypeTb fuelTypeId;
    @JoinColumn(name = "TRUCK_OWNER_ID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private SysUsers truckOwnerId;

    public MyTruckTb() {
    }

    public MyTruckTb(Integer myTruckId) {
        this.myTruckId = myTruckId;
    }

    public MyTruckTb(Integer myTruckId, String regNo, String vehicleValue, int enable, int status, String truckImg) {
        this.myTruckId = myTruckId;
        this.regNo = regNo;
        this.vehicleValue = vehicleValue;
        this.enable = enable;
        this.status = status;
        this.truckImg = truckImg;
    }

    public Integer getMyTruckId() {
        return myTruckId;
    }

    public void setMyTruckId(Integer myTruckId) {
        this.myTruckId = myTruckId;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getChasisNo() {
        return chasisNo;
    }

    public void setChasisNo(String chasisNo) {
        this.chasisNo = chasisNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerContactNo() {
        return ownerContactNo;
    }

    public void setOwnerContactNo(String ownerContactNo) {
        this.ownerContactNo = ownerContactNo;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getVehicleValue() {
        return vehicleValue;
    }

    public void setVehicleValue(String vehicleValue) {
        this.vehicleValue = vehicleValue;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getInsuranceValidUpto() {
        return insuranceValidUpto;
    }

    public void setInsuranceValidUpto(Date insuranceValidUpto) {
        this.insuranceValidUpto = insuranceValidUpto;
    }

    public Date getFitnessValidUpto() {
        return fitnessValidUpto;
    }

    public void setFitnessValidUpto(Date fitnessValidUpto) {
        this.fitnessValidUpto = fitnessValidUpto;
    }

    public Date getTaxValidUpto() {
        return taxValidUpto;
    }

    public void setTaxValidUpto(Date taxValidUpto) {
        this.taxValidUpto = taxValidUpto;
    }

    public Date getPermitValidUpto() {
        return permitValidUpto;
    }

    public void setPermitValidUpto(Date permitValidUpto) {
        this.permitValidUpto = permitValidUpto;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTruckImg() {
        return truckImg;
    }

    public void setTruckImg(String truckImg) {
        this.truckImg = truckImg;
    }

    public String getRegCertificate() {
        return regCertificate;
    }

    public void setRegCertificate(String regCertificate) {
        this.regCertificate = regCertificate;
    }

    public String getInsuranceCertificate() {
        return insuranceCertificate;
    }

    public void setInsuranceCertificate(String insuranceCertificate) {
        this.insuranceCertificate = insuranceCertificate;
    }

    public String getEmissionCertificate() {
        return emissionCertificate;
    }

    public void setEmissionCertificate(String emissionCertificate) {
        this.emissionCertificate = emissionCertificate;
    }

    public String getFitnessCertificate() {
        return fitnessCertificate;
    }

    public void setFitnessCertificate(String fitnessCertificate) {
        this.fitnessCertificate = fitnessCertificate;
    }

    public String getRoadPermitCertificate() {
        return roadPermitCertificate;
    }

    public void setRoadPermitCertificate(String roadPermitCertificate) {
        this.roadPermitCertificate = roadPermitCertificate;
    }

    public String getTdsCertificate() {
        return tdsCertificate;
    }

    public void setTdsCertificate(String tdsCertificate) {
        this.tdsCertificate = tdsCertificate;
    }

    @XmlTransient
    public Collection<OrderTb> getOrderTbCollection() {
        return orderTbCollection;
    }

    public void setOrderTbCollection(Collection<OrderTb> orderTbCollection) {
        this.orderTbCollection = orderTbCollection;
    }

    public TruckTypesTb getTruckTypeId() {
        return truckTypeId;
    }

    public void setTruckTypeId(TruckTypesTb truckTypeId) {
        this.truckTypeId = truckTypeId;
    }

    public TruckModelTb getTruckModelId() {
        return truckModelId;
    }

    public void setTruckModelId(TruckModelTb truckModelId) {
        this.truckModelId = truckModelId;
    }

    public FuelTypeTb getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(FuelTypeTb fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public SysUsers getTruckOwnerId() {
        return truckOwnerId;
    }

    public void setTruckOwnerId(SysUsers truckOwnerId) {
        this.truckOwnerId = truckOwnerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (myTruckId != null ? myTruckId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MyTruckTb)) {
            return false;
        }
        MyTruckTb other = (MyTruckTb) object;
        if ((this.myTruckId == null && other.myTruckId != null) || (this.myTruckId != null && !this.myTruckId.equals(other.myTruckId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.MyTruckTb[ myTruckId=" + myTruckId + " ]";
    }
    
}
