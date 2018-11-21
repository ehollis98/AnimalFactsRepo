package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * The type Animal.
 */
@Entity(name = "Animal")
@Table(name ="animal")
public class Animal {

    /**
     * Instantiates a new Animal.
     */
    public Animal() {
    }

    /**
     * Instantiates a new Animal.
     *
     * @param animal the animal
     */
    public Animal(String animal) {
        this.animal = animal;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "animal")
    private String animal;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Fact> fact = new HashSet<>();

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", animal='" + animal + '\'' +
                '}';
    }

    /**
     * Get animal string.
     *
     * @return the string
     */
    public String getAnimal(){
        return animal;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets fact.
     *
     * @return the fact
     */
    public Set<Fact> getFact() {
        return fact;
    }

}
