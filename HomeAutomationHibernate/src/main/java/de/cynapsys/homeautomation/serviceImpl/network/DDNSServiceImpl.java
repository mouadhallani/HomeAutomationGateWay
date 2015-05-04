/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.serviceImpl.network;

import de.cynapsys.homeautomation.ddns.NoIP;
import de.cynapsys.homeautomation.entity.network.DdnsEntity;
import de.cynapsys.homeautomation.entity.network.UpnpEntity;
import de.cynapsys.homeautomation.service.network.DDNSService;
import java.util.List;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author mouadh
 */
public class DDNSServiceImpl implements DDNSService {

    static transient Session session;

    @Override
    public void saveConfiguration(DdnsEntity u) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void changeConfiguration(DdnsEntity u) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(u);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public DdnsEntity getConfiguration() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<DdnsEntity> ld = session.createCriteria(DdnsEntity.class).list();

        session.close();
        return ld.get(0);
    }

    @Override
    public void submitHostname(DdnsEntity d) {
//        NoIP n = new NoIP("anisjribi@gmail.com", "annous1992");
//        n.submitHostname("beity.ddns.net");
        NoIP n = new NoIP(d.getAccount(), d.getPassword());
        n.submitHostname(d.getHostname());
    }

}
