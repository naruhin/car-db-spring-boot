package core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DEALERS")
@Getter
@Setter
@NoArgsConstructor
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToOne(cascade=CascadeType.MERGE, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "dealer", fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH)
    private Set<Car> cars;


    public Dealer(String name) {
        this.name = name;
    }


}
