package com.EECS.Persistence.PersistenceDemo.Entities.Inheritance;

import com.EECS.Persistence.PersistenceDemo.Entities.Outfit;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="humanoid_type",
        discriminatorType = DiscriminatorType.INTEGER)
public abstract class Humanoid {
    @Id
    @GeneratedValue
    Long id;

    @OneToMany(mappedBy = "humanoid")
    List<Outfit> outfits;

}
