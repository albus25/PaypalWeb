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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Albus
 */
@Entity
@Table(name = "order_tb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderTb.findAll", query = "SELECT o FROM OrderTb o"),
    @NamedQuery(name = "OrderTb.findByOrderId", query = "SELECT o FROM OrderTb o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "OrderTb.findByDistance", query = "SELECT o FROM OrderTb o WHERE o.distance = :distance"),
    @NamedQuery(name = "OrderTb.findByFuelCost", query = "SELECT o FROM OrderTb o WHERE o.fuelCost = :fuelCost"),
    @NamedQuery(name = "OrderTb.findByTollTax", query = "SELECT o FROM OrderTb o WHERE o.tollTax = :tollTax"),
    @NamedQuery(name = "OrderTb.findByGstRate", query = "SELECT o FROM OrderTb o WHERE o.gstRate = :gstRate"),
    @NamedQuery(name = "OrderTb.findByAdditionalCost", query = "SELECT o FROM OrderTb o WHERE o.additionalCost = :additionalCost"),
    @NamedQuery(name = "OrderTb.findByTotalFreightRate", query = "SELECT o FROM OrderTb o WHERE o.totalFreightRate = :totalFreightRate"),
    @NamedQuery(name = "OrderTb.findByTotalAmount", query = "SELECT o FROM OrderTb o WHERE o.totalAmount = :totalAmount"),
    @NamedQuery(name = "OrderTb.findByStatus", query = "SELECT o FROM OrderTb o WHERE o.status = :status")})
public class OrderTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ORDER_ID")
    private Integer orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISTANCE")
    private double distance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FUEL_COST")
    private double fuelCost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOLL_TAX")
    private double tollTax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GST_RATE")
    private double gstRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADDITIONAL_COST")
    private double additionalCost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_FREIGHT_RATE")
    private double totalFreightRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_AMOUNT")
    private double totalAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderid")
    private Collection<PaymentTb> paymentTbCollection;
    @JoinColumn(name = "REQUEST_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RequestOrderTb requestId;
    @JoinColumn(name = "TRUCK_OWNER_ID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private SysUsers truckOwnerId;
    @JoinColumn(name = "TRUCK_ID", referencedColumnName = "MY_TRUCK_ID")
    @ManyToOne(optional = false)
    private MyTruckTb truckId;
    @JoinColumn(name = "DRIVER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private DriverTb driverId;

    public OrderTb() {
    }

    public OrderTb(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderTb(Integer orderId, double distance, double fuelCost, double tollTax, double gstRate, double additionalCost, double totalFreightRate, double totalAmount, int status) {
        this.orderId = orderId;
        this.distance = distance;
        this.fuelCost = fuelCost;
        this.tollTax = tollTax;
        this.gstRate = gstRate;
        this.additionalCost = additionalCost;
        this.totalFreightRate = totalFreightRate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public double getTollTax() {
        return tollTax;
    }

    public void setTollTax(double tollTax) {
        this.tollTax = tollTax;
    }

    public double getGstRate() {
        return gstRate;
    }

    public void setGstRate(double gstRate) {
        this.gstRate = gstRate;
    }

    public double getAdditionalCost() {
        return additionalCost;
    }

    public void setAdditionalCost(double additionalCost) {
        this.additionalCost = additionalCost;
    }

    public double getTotalFreightRate() {
        return totalFreightRate;
    }

    public void setTotalFreightRate(double totalFreightRate) {
        this.totalFreightRate = totalFreightRate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<PaymentTb> getPaymentTbCollection() {
        return paymentTbCollection;
    }

    public void setPaymentTbCollection(Collection<PaymentTb> paymentTbCollection) {
        this.paymentTbCollection = paymentTbCollection;
    }

    public RequestOrderTb getRequestId() {
        return requestId;
    }

    public void setRequestId(RequestOrderTb requestId) {
        this.requestId = requestId;
    }

    public SysUsers getTruckOwnerId() {
        return truckOwnerId;
    }

    public void setTruckOwnerId(SysUsers truckOwnerId) {
        this.truckOwnerId = truckOwnerId;
    }

    public MyTruckTb getTruckId() {
        return truckId;
    }

    public void setTruckId(MyTruckTb truckId) {
        this.truckId = truckId;
    }

    public DriverTb getDriverId() {
        return driverId;
    }

    public void setDriverId(DriverTb driverId) {
        this.driverId = driverId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderTb)) {
            return false;
        }
        OrderTb other = (OrderTb) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.OrderTb[ orderId=" + orderId + " ]";
    }
    
}
