package pl.mcx.lombok.academy.jpa;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "accessVersions")
@EqualsAndHashCode(exclude = "accessVersions")
public class Door {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "door")
    private Set<AccessVersion> accessVersions;

    private String number;
}
