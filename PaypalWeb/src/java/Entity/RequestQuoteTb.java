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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Albus
 */
@Entity
@Table(name = "request_quote_tb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestQuoteTb.findAll", query = "SELECT r FROM RequestQuoteTb r"),
    @NamedQuery(name = "RequestQuoteTb.findById", query = "SELECT r FROM RequestQuoteTb r WHERE r.id = :id"),
    @NamedQuery(name = "RequestQuoteTb.findByQuoteAmount", query = "SELECT r FROM RequestQuoteTb r WHERE r.quoteAmount = :quoteAmount"),
    @NamedQuery(name = "RequestQuoteTb.findByStatus", query = "SELECT r FROM RequestQuoteTb r WHERE r.status = :status"),
    @NamedQuery(name = "RequestQuoteTb.findByBidAmount", query = "SELECT r FROM RequestQuoteTb r WHERE r.bidAmount = :bidAmount")})
public class RequestQuoteTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUOTE_AMOUNT")
    private Double quoteAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private int status;
    @Column(name = "BID_AMOUNT")
    private Double bidAmount;
    @JoinColumn(name = "REQUEST_ORDER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RequestOrderTb requestOrderId;
    @JoinColumn(name = "TRUCK_OWNER_ID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private SysUsers truckOwnerId;

    public RequestQuoteTb() {
    }

    public RequestQuoteTb(Integer id) {
        this.id = id;
    }

    public RequestQuoteTb(Integer id, int status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuoteAmount() {
        return quoteAmount;
    }

    public void setQuoteAmount(Double quoteAmount) {
        this.quoteAmount = quoteAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public RequestOrderTb getRequestOrderId() {
        return requestOrderId;
    }

    public void setRequestOrderId(RequestOrderTb requestOrderId) {
        this.requestOrderId = requestOrderId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestQuoteTb)) {
            return false;
        }
        RequestQuoteTb other = (RequestQuoteTb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.RequestQuoteTb[ id=" + id + " ]";
    }
    
}
