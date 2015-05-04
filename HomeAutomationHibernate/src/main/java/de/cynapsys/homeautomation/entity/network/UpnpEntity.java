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

/**
 *
 * @author mouadh
 */
@Entity
public class UpnpEntity implements Serializable {
    
    
    private int port;

    public UpnpEntity(int port) {
        this.port = port;
    }

    public UpnpEntity() {
    }

    @Id
    @Column(name = "`port`", nullable = false)
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    
}
