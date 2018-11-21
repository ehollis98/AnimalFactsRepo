package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * The type Fact.
 */
@Entity(name = "Fact")
@Table(name ="facts")
public class Fact {

    /**
     * Instantiates a new Fact.
     */
    public Fact() {
    }

    /**
     * Instantiates a new Fact.
     *
     * @param fact the animal
     */
    public Fact(String fact) {
        this.fact = fact;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @ManyToOne
    @JoinColumn(name="animalId",referencedColumnName="id")
    private Animal animal;



    @Column(name = "fact")
    private String fact;

    /**
     * Gets fact.
     *
     * @return the fact
     */
    public String getFact() {

        return fact;
    }

    /**
     * Get animal animal.
     *
     * @return the animal
     */
    public Animal getAnimal(){
        return animal;
    }

    /**
     * Sets fact.
     *
     * @param fact the fact
     */
    public void setFact(String fact) {
        this.fact = fact;
    }

    @Override
    public String toString() {
        return "Fact{" +
                "id=" + id +
                ", fact='" + fact + '\'' +
                '}';
    }


}
