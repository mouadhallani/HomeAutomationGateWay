/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author mouadh
 */

@Entity
@Table(name="`Room`")

public class Room {
    
    Long id;
    String name;
    String description;
    Set<Device> devices;

    public Room() {
        devices = new HashSet<>();
    }

    public Room(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.devices = new HashSet<>();
    }

    @XmlElement
    @Column(name = "`id`", nullable = false)	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    @Column(name="`name`", nullable=true, length=50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    @Column(name="`description`", nullable=true, length=50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    @OneToMany(mappedBy="room", targetEntity=Device.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }
    
    

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }
    
    
}
