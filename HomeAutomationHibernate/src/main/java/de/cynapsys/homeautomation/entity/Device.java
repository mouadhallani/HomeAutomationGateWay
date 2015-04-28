/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author mouadh
 */
@Entity
@Table(name = "`Device`")
@XmlRootElement(name = "device")
public class Device {

    Long id;
    String name;
    String description;
    int currentValue;
    Room room;
    Category category;

    public Device() {
    }

    public Device(String name, String description, int currentValue) {
        this.name = name;
        this.description = description;
        this.currentValue = currentValue;
    }
    
    

    public Device(Long id, String name, String description, int currentValue) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.currentValue = currentValue;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    @Column(name = "`name`", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    @Column(name = "`description`", nullable = true, length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    @Column(name = "`currentValue`", nullable = true, length = 50)
    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    @XmlElement
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="room_id", 
                insertable=false, updatable=false, 
                nullable=true)
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @XmlElement
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", 
                insertable=false, updatable=false, 
                nullable=true)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Device{" + "id=" + id + ", name=" + name + ", description=" + description + ", currentValue=" + currentValue + '}'+"\n";
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + this.currentValue;
        hash = 97 * hash + Objects.hashCode(this.room);
        hash = 97 * hash + Objects.hashCode(this.category);
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
        final Device other = (Device) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (this.currentValue != other.currentValue) {
            return false;
        }
        if (!Objects.equals(this.room, other.room)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        return true;
    }
    
    
    

}
