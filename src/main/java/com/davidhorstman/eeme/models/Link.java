package com.davidhorstman.eeme.models;

import com.davidhorstman.eeme.utils.Encoder;

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

    private static char[] glyphs = {'e', 'm', 'E', 'M'};

    public static long decode(String encoded) {
        return Encoder.decode(encoded, glyphs);
    }

    public static String encode(long id) {
        return Encoder.encode(id, glyphs);
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
