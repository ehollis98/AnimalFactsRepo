package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The type Animal.
 */
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

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", animal='" + animal + '\'' +
                '}';
    }
}
