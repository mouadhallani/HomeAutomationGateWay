/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.service.network;

import de.cynapsys.homeautomation.entity.network.DdnsEntity;
import de.cynapsys.homeautomation.entity.network.UpnpEntity;

/**
 *
 * @author mouadh
 */
public interface DDNSService {
    
    public void saveConfiguration(DdnsEntity d);
    public void changeConfiguration(DdnsEntity d);
    public DdnsEntity getConfiguration();
    public void submitHostname(DdnsEntity d);
    
    
}
