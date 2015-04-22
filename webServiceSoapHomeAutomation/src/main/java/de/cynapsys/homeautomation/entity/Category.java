package de.cynapsys.homeautomation.entity;

/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 *
 * This is an automatic generated file. It will be regenerated every time you
 * generate persistence class.
 *
 * Modifying its content may cause the program not work, or your work may lost.
 */
/**
 * Licensee: Faculty of informatics, Burapha University 01 License Type:
 * Purchased
 */
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "`Category`")
@XmlRootElement(name = "Category")
public class Category implements Serializable {



    private Long id;
    private String name;
    private String description;

    
    private java.util.Set devices = new java.util.HashSet();

    public Category(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Category() {
    }

    @Id
    @Column(name = "`id`", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "`name`", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`description`", nullable = true, length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "category", targetEntity = Device.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    public Set getDevices() {
        return devices;
    }

    public void setDevices(Set devices) {
        this.devices = devices;
    }

}
