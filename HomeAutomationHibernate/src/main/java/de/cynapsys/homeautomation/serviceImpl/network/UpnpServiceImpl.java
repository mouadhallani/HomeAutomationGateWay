/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.serviceImpl.network;

import de.cynapsys.homeautomation.entity.network.DdnsEntity;
import de.cynapsys.homeautomation.entity.network.UpnpEntity;
import de.cynapsys.homeautomation.service.network.UpnpService;
import static de.cynapsys.homeautomation.serviceImpl.network.DDNSServiceImpl.session;
import java.util.List;
import utils.HibernateUtil;

/**
 *
 * @author mouadh
 */
public class UpnpServiceImpl implements UpnpService{

    @Override
    public void addPort(UpnpEntity u) {
        
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();
        session.close();
        
    }

    @Override
    public void removePort(UpnpEntity u) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(u);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Integer> getAllPorts() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Integer> lp = session.createCriteria(UpnpEntity.class).list();
        session.close();
        return lp;
    }
    
}
