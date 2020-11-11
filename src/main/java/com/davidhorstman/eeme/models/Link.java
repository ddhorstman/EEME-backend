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

    public static long decode(String encoded) {
        return Long.parseLong(encoded);
    }

    public static String encode(long id) {
        return "" + id + "";
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
