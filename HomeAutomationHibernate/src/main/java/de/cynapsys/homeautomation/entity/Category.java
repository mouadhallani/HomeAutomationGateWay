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
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Category")
@XmlRootElement(name = "Category")
public class Category implements Serializable {



    private Long id;
    private String name;
    private String description;

    
    private List<Device> devices;

    public Category(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    

    public Category() {
    }

    @Id
    @Column(name = "`id`", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(fetch = FetchType.EAGER,cascade={CascadeType.ALL})
    @JoinColumn(name="category_id")
    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", description=" + description + ", devices=" + devices + '}'+"\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.description);
        hash = 13 * hash + Objects.hashCode(this.devices);
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
        final Category other = (Category) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.devices, other.devices)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    

}
