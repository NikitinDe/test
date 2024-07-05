package org.example.testovoe.modelDto;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;

    }

    public Role( String name) {

        this.name = "ROLE_"+name;
    }
}


