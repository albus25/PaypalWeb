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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Albus
 */
@Entity
@Table(name = "truck_model_tb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TruckModelTb.findAll", query = "SELECT t FROM TruckModelTb t"),
    @NamedQuery(name = "TruckModelTb.findByTruckModelId", query = "SELECT t FROM TruckModelTb t WHERE t.truckModelId = :truckModelId"),
    @NamedQuery(name = "TruckModelTb.findByTruckModelName", query = "SELECT t FROM TruckModelTb t WHERE t.truckModelName = :truckModelName"),
    @NamedQuery(name = "TruckModelTb.findByTruckHeight", query = "SELECT t FROM TruckModelTb t WHERE t.truckHeight = :truckHeight"),
    @NamedQuery(name = "TruckModelTb.findByTruckWidth", query = "SELECT t FROM TruckModelTb t WHERE t.truckWidth = :truckWidth"),
    @NamedQuery(name = "TruckModelTb.findByTruckLength", query = "SELECT t FROM TruckModelTb t WHERE t.truckLength = :truckLength"),
    @NamedQuery(name = "TruckModelTb.findByTruckWeight", query = "SELECT t FROM TruckModelTb t WHERE t.truckWeight = :truckWeight"),
    @NamedQuery(name = "TruckModelTb.findByTruckCbm", query = "SELECT t FROM TruckModelTb t WHERE t.truckCbm = :truckCbm"),
    @NamedQuery(name = "TruckModelTb.findByTruckEnabled", query = "SELECT t FROM TruckModelTb t WHERE t.truckEnabled = :truckEnabled"),
    @NamedQuery(name = "TruckModelTb.findByTruckImg", query = "SELECT t FROM TruckModelTb t WHERE t.truckImg = :truckImg"),
    @NamedQuery(name = "TruckModelTb.findByStatus", query = "SELECT t FROM TruckModelTb t WHERE t.status = :status")})
public class TruckModelTb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRUCK_MODEL_ID")
    private Integer truckModelId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "TRUCK_MODEL_NAME")
    private String truckModelName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRUCK_HEIGHT")
    private int truckHeight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRUCK_WIDTH")
    private int truckWidth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRUCK_LENGTH")
    private int truckLength;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRUCK_WEIGHT")
    private int truckWeight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRUCK_CBM")
    private int truckCbm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRUCK_ENABLED")
    private int truckEnabled;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "TRUCK_IMG")
    private String truckImg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private int status;
    @JoinColumn(name = "TRUCK_TYPE_ID", referencedColumnName = "TYPEID")
    @ManyToOne(optional = false)
    private TruckTypesTb truckTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "truckModel")
    private Collection<RequestOrderTb> requestOrderTbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "truckModelId")
    private Collection<MyTruckTb> myTruckTbCollection;

    public TruckModelTb() {
    }

    public TruckModelTb(Integer truckModelId) {
        this.truckModelId = truckModelId;
    }

    public TruckModelTb(Integer truckModelId, String truckModelName, int truckHeight, int truckWidth, int truckLength, int truckWeight, int truckCbm, int truckEnabled, String truckImg, int status) {
        this.truckModelId = truckModelId;
        this.truckModelName = truckModelName;
        this.truckHeight = truckHeight;
        this.truckWidth = truckWidth;
        this.truckLength = truckLength;
        this.truckWeight = truckWeight;
        this.truckCbm = truckCbm;
        this.truckEnabled = truckEnabled;
        this.truckImg = truckImg;
        this.status = status;
    }

    public Integer getTruckModelId() {
        return truckModelId;
    }

    public void setTruckModelId(Integer truckModelId) {
        this.truckModelId = truckModelId;
    }

    public String getTruckModelName() {
        return truckModelName;
    }

    public void setTruckModelName(String truckModelName) {
        this.truckModelName = truckModelName;
    }

    public int getTruckHeight() {
        return truckHeight;
    }

    public void setTruckHeight(int truckHeight) {
        this.truckHeight = truckHeight;
    }

    public int getTruckWidth() {
        return truckWidth;
    }

    public void setTruckWidth(int truckWidth) {
        this.truckWidth = truckWidth;
    }

    public int getTruckLength() {
        return truckLength;
    }

    public void setTruckLength(int truckLength) {
        this.truckLength = truckLength;
    }

    public int getTruckWeight() {
        return truckWeight;
    }

    public void setTruckWeight(int truckWeight) {
        this.truckWeight = truckWeight;
    }

    public int getTruckCbm() {
        return truckCbm;
    }

    public void setTruckCbm(int truckCbm) {
        this.truckCbm = truckCbm;
    }

    public int getTruckEnabled() {
        return truckEnabled;
    }

    public void setTruckEnabled(int truckEnabled) {
        this.truckEnabled = truckEnabled;
    }

    public String getTruckImg() {
        return truckImg;
    }

    public void setTruckImg(String truckImg) {
        this.truckImg = truckImg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public TruckTypesTb getTruckTypeId() {
        return truckTypeId;
    }

    public void setTruckTypeId(TruckTypesTb truckTypeId) {
        this.truckTypeId = truckTypeId;
    }

    @XmlTransient
    public Collection<RequestOrderTb> getRequestOrderTbCollection() {
        return requestOrderTbCollection;
    }

    public void setRequestOrderTbCollection(Collection<RequestOrderTb> requestOrderTbCollection) {
        this.requestOrderTbCollection = requestOrderTbCollection;
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
        hash += (truckModelId != null ? truckModelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TruckModelTb)) {
            return false;
        }
        TruckModelTb other = (TruckModelTb) object;
        if ((this.truckModelId == null && other.truckModelId != null) || (this.truckModelId != null && !this.truckModelId.equals(other.truckModelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TruckModelTb[ truckModelId=" + truckModelId + " ]";
    }
    
}
