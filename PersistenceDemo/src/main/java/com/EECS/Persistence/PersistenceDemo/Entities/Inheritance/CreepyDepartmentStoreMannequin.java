package com.EECS.Persistence.PersistenceDemo.Entities.Inheritance;

import javax.persistence.Entity;

@Entity
public class CreepyDepartmentStoreMannequin extends Humanoid{
    private boolean hasAHead;
    private MannequinShape mannequinShape;

    enum MannequinShape {
        LITHE, MUSCULUR, UNASSUMING;
    }

}
