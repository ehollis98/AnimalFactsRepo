package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Random;

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

    @Column(name = "animalId")
    private int animalId;

    @Column(name = "fact")
    private String fact;

    public String getFact() {

        return fact;
    }
    public int getAnimalId() {

        return animalId;
    }



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
