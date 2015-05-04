/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.controller;

import de.cynapsys.homeautomation.entity.network.DdnsEntity;
import de.cynapsys.homeautomation.service.network.DDNSService;
import de.cynapsys.homeautomation.serviceImpl.network.DDNSServiceImpl;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author mouadh
 */
@ManagedBean
@SessionScoped
public class DdnsBean {
    
    private DdnsEntity ddns;
    private final DDNSService ddnsService = new DDNSServiceImpl();

    @PostConstruct
    public void init(){
        ddns= ddnsService.getConfiguration();
    }
    
    public void connexion (){
        ddnsService.submitHostname(ddns);
    }
    
    public void setConfiguration(){
        ddns.setId(1);
        ddnsService.changeConfiguration(ddns);
    }
    
    public DdnsEntity getDdns() {
        return ddns;
    }

    public void setDdns(DdnsEntity ddns) {
        this.ddns = ddns;
    }
    
    
    
}
