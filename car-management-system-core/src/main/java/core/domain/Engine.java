package core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ENGINES")
@Getter
@Setter
@NoArgsConstructor
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String type;

    private String engineVolume;

    private String engineLayoutType;

    private String torque;

    private String power;

    @OneToOne(mappedBy = "engine")
    private Car car;

    public Engine(String type, String engineVolume, String engineLayoutType, String torque, String power) {
        this.type = type;
        this.engineVolume = engineVolume;
        this.engineLayoutType = engineLayoutType;
        this.torque = torque;
        this.power = power;
    }
}
