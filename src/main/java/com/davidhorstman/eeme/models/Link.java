package com.davidhorstman.eeme.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @NotEmpty(message = "You must include a 'target' for the shortened link")
    private String target;

    public Link() {
    }

    public Link(@NotEmpty(message = "You must include a 'target' for the shortened link") String target) {
        this.target = target;
    }

    public Link(long id, @NotEmpty(message = "You must include a 'target' for the shortened link") String target) {
        this.id = id;
        this.target = target;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
