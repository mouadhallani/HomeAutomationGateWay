/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.entity.network;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mouadh
 */
@Entity
@Table(name = "DdnsEntity")
public class DdnsEntity implements Serializable {
    
    private int id;
    private String account;
    private String password;
    private String hostname;

    public DdnsEntity() {
    }

    public DdnsEntity(int id,String account, String password, String hostname) {
        this.id=id;
        this.account = account;
        this.password = password;
        this.hostname = hostname;
    }

    @Id
    @Column(name = "`id`", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "`account`", nullable = true)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "`password`", nullable = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "`hostname`", nullable = true)
    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
    
    
    
}
