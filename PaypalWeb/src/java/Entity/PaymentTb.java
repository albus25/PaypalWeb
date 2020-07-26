/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Albus
 */
@Entity
@Table(name = "payment_tb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentTb.findAll", query = "SELECT p FROM PaymentTb p"),
    @NamedQuery(name = "PaymentTb.findById", query = "SELECT p FROM PaymentTb p WHERE p.id = :id"),
    @NamedQuery(name = "PaymentTb.findByAmount", query = "SELECT p FROM PaymentTb p WHERE p.amount = :amount"),
    @NamedQuery(name = "PaymentTb.findByOrderDate", query = "SELECT p FROM PaymentTb p WHERE p.orderDate = :orderDate")})
public class PaymentTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private double amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @JoinColumn(name = "ORDERID", referencedColumnName = "ORDER_ID")
    @ManyToOne(optional = false)
    private OrderTb orderid;

    public PaymentTb() {
    }

    public PaymentTb(Integer id) {
        this.id = id;
    }

    public PaymentTb(Integer id, double amount, Date orderDate) {
        this.id = id;
        this.amount = amount;
        this.orderDate = orderDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderTb getOrderid() {
        return orderid;
    }

    public void setOrderid(OrderTb orderid) {
        this.orderid = orderid;
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
        if (!(object instanceof PaymentTb)) {
            return false;
        }
        PaymentTb other = (PaymentTb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PaymentTb[ id=" + id + " ]";
    }
    
}
