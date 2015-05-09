/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.controller;

import de.cynapsys.homeautomation.entity.network.UpnpEntity;
import de.cynapsys.homeautomation.service.network.UpnpService;
import de.cynapsys.homeautomation.serviceImpl.network.UpnpServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;

/**
 *
 * @author mouadh
 */
@ManagedBean
@ViewScoped
public class upnpBean {
    
    static transient Session session;
        private List<UpnpEntity> values;
        
        private final UpnpService upnpService = new UpnpServiceImpl();
        private UpnpEntity upnp;

    @PostConstruct
    public void init() {
        values = upnpService.getAllPorts();
        upnp = new UpnpEntity();
    }

    public void submit(int port) {

            if (upnpService.getUpnpByPort(port) == null){
                upnpService.addPort(port);
                upnp=new UpnpEntity(port);
                upnpService.addPort(upnp);
            }

        
    }
    
    public String portStatus(int port){
        return upnpService.getPortStatus(port);
    }

    public void extend() {
        values.add(new UpnpEntity());
    }

    public void setValues(List<UpnpEntity> values) {
        this.values = values;
    }

    public List<UpnpEntity> getValues() {
        return values;
    }

    public UpnpEntity getUpnp() {
        return upnp;
    }

    public void setUpnp(UpnpEntity upnp) {
        this.upnp = upnp;
    }
    
    
    
}
