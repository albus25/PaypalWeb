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
import javax.persistence.Lob;
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
@Table(name = "request_order_tb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestOrderTb.findAll", query = "SELECT r FROM RequestOrderTb r"),
    @NamedQuery(name = "RequestOrderTb.findById", query = "SELECT r FROM RequestOrderTb r WHERE r.id = :id"),
    @NamedQuery(name = "RequestOrderTb.findByFreightWeight", query = "SELECT r FROM RequestOrderTb r WHERE r.freightWeight = :freightWeight"),
    @NamedQuery(name = "RequestOrderTb.findByFreightAmount", query = "SELECT r FROM RequestOrderTb r WHERE r.freightAmount = :freightAmount"),
    @NamedQuery(name = "RequestOrderTb.findByStatus", query = "SELECT r FROM RequestOrderTb r WHERE r.status = :status"),
    @NamedQuery(name = "RequestOrderTb.findByPickupDate", query = "SELECT r FROM RequestOrderTb r WHERE r.pickupDate = :pickupDate"),
    @NamedQuery(name = "RequestOrderTb.findByPickupTime", query = "SELECT r FROM RequestOrderTb r WHERE r.pickupTime = :pickupTime"),
    @NamedQuery(name = "RequestOrderTb.findByReceiverEmail", query = "SELECT r FROM RequestOrderTb r WHERE r.receiverEmail = :receiverEmail"),
    @NamedQuery(name = "RequestOrderTb.findByReceiverMobile", query = "SELECT r FROM RequestOrderTb r WHERE r.receiverMobile = :receiverMobile"),
    @NamedQuery(name = "RequestOrderTb.findByRequestDate", query = "SELECT r FROM RequestOrderTb r WHERE r.requestDate = :requestDate"),
    @NamedQuery(name = "RequestOrderTb.findByRequestUpdateDate", query = "SELECT r FROM RequestOrderTb r WHERE r.requestUpdateDate = :requestUpdateDate")})
public class RequestOrderTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FREIGHT_WEIGHT")
    private double freightWeight;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "FEIGHT_DESCRIPTION")
    private String feightDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FREIGHT_AMOUNT")
    private double freightAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PICKUP_DATE")
    @Temporal(TemporalType.DATE)
    private Date pickupDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PICKUP_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pickupTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "RECEIVER_EMAIL")
    private String receiverEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "RECEIVER_MOBILE")
    private String receiverMobile;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "RECEIVER_ADDRESS")
    private String receiverAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQUEST_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQUEST_UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestUpdateDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestOrderId")
    private Collection<RequestQuoteTb> requestQuoteTbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestId")
    private Collection<OrderTb> orderTbCollection;
    @JoinColumn(name = "CARGO_OWNER_ID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private SysUsers cargoOwnerId;
    @JoinColumn(name = "COMMODITY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CommodityTb commodityId;
    @JoinColumn(name = "DEPARTURE_POINT", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private LocationTb departurePoint;
    @JoinColumn(name = "ENDING_POINT", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private LocationTb endingPoint;
    @JoinColumn(name = "TRUCK_TYPE", referencedColumnName = "TYPEID")
    @ManyToOne(optional = false)
    private TruckTypesTb truckType;
    @JoinColumn(name = "TRUCK_MODEL", referencedColumnName = "TRUCK_MODEL_ID")
    @ManyToOne(optional = false)
    private TruckModelTb truckModel;

    public RequestOrderTb() {
    }

    public RequestOrderTb(Integer id) {
        this.id = id;
    }

    public RequestOrderTb(Integer id, double freightWeight, String feightDescription, double freightAmount, int status, Date pickupDate, Date pickupTime, String receiverEmail, String receiverMobile, String receiverAddress, Date requestDate, Date requestUpdateDate) {
        this.id = id;
        this.freightWeight = freightWeight;
        this.feightDescription = feightDescription;
        this.freightAmount = freightAmount;
        this.status = status;
        this.pickupDate = pickupDate;
        this.pickupTime = pickupTime;
        this.receiverEmail = receiverEmail;
        this.receiverMobile = receiverMobile;
        this.receiverAddress = receiverAddress;
        this.requestDate = requestDate;
        this.requestUpdateDate = requestUpdateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getFreightWeight() {
        return freightWeight;
    }

    public void setFreightWeight(double freightWeight) {
        this.freightWeight = freightWeight;
    }

    public String getFeightDescription() {
        return feightDescription;
    }

    public void setFeightDescription(String feightDescription) {
        this.feightDescription = feightDescription;
    }

    public double getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(double freightAmount) {
        this.freightAmount = freightAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getRequestUpdateDate() {
        return requestUpdateDate;
    }

    public void setRequestUpdateDate(Date requestUpdateDate) {
        this.requestUpdateDate = requestUpdateDate;
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

    public SysUsers getCargoOwnerId() {
        return cargoOwnerId;
    }

    public void setCargoOwnerId(SysUsers cargoOwnerId) {
        this.cargoOwnerId = cargoOwnerId;
    }

    public CommodityTb getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(CommodityTb commodityId) {
        this.commodityId = commodityId;
    }

    public LocationTb getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(LocationTb departurePoint) {
        this.departurePoint = departurePoint;
    }

    public LocationTb getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(LocationTb endingPoint) {
        this.endingPoint = endingPoint;
    }

    public TruckTypesTb getTruckType() {
        return truckType;
    }

    public void setTruckType(TruckTypesTb truckType) {
        this.truckType = truckType;
    }

    public TruckModelTb getTruckModel() {
        return truckModel;
    }

    public void setTruckModel(TruckModelTb truckModel) {
        this.truckModel = truckModel;
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
        if (!(object instanceof RequestOrderTb)) {
            return false;
        }
        RequestOrderTb other = (RequestOrderTb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.RequestOrderTb[ id=" + id + " ]";
    }
    
}
