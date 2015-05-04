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
        private List<String> values;
        
        private UpnpService upnpService = new UpnpServiceImpl();
        private UpnpEntity upnp;

    @PostConstruct
    public void init() {
        values = upnp.ge
    }

    public void submit() {
        // save values in database
    }

    public void extend() {
        values.add("");
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public List<String> getValues() {
        return values;
    }
    
}
