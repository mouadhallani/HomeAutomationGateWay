/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author mouadh
 */

@Entity
@Table(name="`Room`")

public class Room implements Serializable {
    
    Long id;
    String name;
    String description;
    List<Device> devices= new ArrayList<>();

    public Room() {
        
    }

    public Room(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @XmlElement
    @Column(name = "`id`", nullable = false)	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)	
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
    @OneToMany(fetch = FetchType.EAGER,cascade={CascadeType.ALL})
    @JoinColumn(name="room_id")
    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
    
    

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", name=" + name + ", description=" + description + '}'+"\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }

        return true;
    }

}
