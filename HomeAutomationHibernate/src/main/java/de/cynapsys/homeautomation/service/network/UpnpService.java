/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.service.network;

import de.cynapsys.homeautomation.entity.network.UpnpEntity;
import java.util.List;

/**
 *
 * @author mouadh
 */
public interface UpnpService {
    
    public void addPort(UpnpEntity u);
    public void removePort(UpnpEntity u);
    public List<UpnpEntity> getAllPorts();
    public UpnpEntity getUpnpByPort(int port);
    public String getPortStatus(int port);
    public void addPort(int port);
    
}
