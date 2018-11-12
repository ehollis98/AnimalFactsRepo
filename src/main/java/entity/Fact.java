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
    private String animalId;

    @Column(name = "fact")
    private String fact;

    public String getFact(int random) {

        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
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

    @Override
    public String toString() {
        return "Fact{" +
                "id=" + id +
                ", fact='" + fact + '\'' +
                '}';
    }


}
