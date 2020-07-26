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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Albus
 */
@Entity
@Table(name = "user_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserGroup.findAll", query = "SELECT u FROM UserGroup u"),
    @NamedQuery(name = "UserGroup.findByUserGroupId", query = "SELECT u FROM UserGroup u WHERE u.userGroupId = :userGroupId")})
public class UserGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USER_GROUP_ID")
    private Integer userGroupId;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private SysUsers userId;
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")
    @ManyToOne(optional = false)
    private GroupMaster groupId;

    public UserGroup() {
    }

    public UserGroup(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public Integer getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public SysUsers getUserId() {
        return userId;
    }

    public void setUserId(SysUsers userId) {
        this.userId = userId;
    }

    public GroupMaster getGroupId() {
        return groupId;
    }

    public void setGroupId(GroupMaster groupId) {
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userGroupId != null ? userGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserGroup)) {
            return false;
        }
        UserGroup other = (UserGroup) object;
        if ((this.userGroupId == null && other.userGroupId != null) || (this.userGroupId != null && !this.userGroupId.equals(other.userGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.UserGroup[ userGroupId=" + userGroupId + " ]";
    }
    
}
