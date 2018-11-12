package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Random;

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

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", animal='" + animal + '\'' +
                '}';
    }

    /**
     * Gets random number.
     *
     * @return the random number
     */
    public int getRandomFact() {


        Random rand = new Random();

        int  random = rand.nextInt(61) + 1;


        return random;
    }
}
