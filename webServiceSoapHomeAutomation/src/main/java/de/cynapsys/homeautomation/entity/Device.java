/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cynapsys.homeautomation.entity;

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

    public Device(Long id, String name, String description, int currentValue) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.currentValue = currentValue;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
    @ManyToOne(targetEntity = Room.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({
        @JoinColumn(name = "`Roomid`", referencedColumnName = "`id`", nullable = false)})
    @org.hibernate.annotations.LazyToOne(value = org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @XmlElement
    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns({
        @JoinColumn(name = "`Categoryid`", referencedColumnName = "`id`", nullable = false)})
    @org.hibernate.annotations.LazyToOne(value = org.hibernate.annotations.LazyToOneOption.NO_PROXY)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Device{" + "id=" + id + ", name=" + name + ", description=" + description + ", currentValue=" + currentValue + "}\n";
    }

}
