package pl.mcx.lombok.academy.jpa;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AccessVersion extends Version {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "door_id")
    private Door door;

    @Builder
    public AccessVersion(final ZonedDateTime endValidTime, final Employee employee, final Door door) {
        super(endValidTime);
        this.employee = employee;
        this.door = door;
    }
}
