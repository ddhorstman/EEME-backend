package com.davidhorstman.eeme.services;

import com.davidhorstman.eeme.models.Link;
import com.davidhorstman.eeme.views.EncodedLink;

import java.util.List;

public interface LinkServices {

    Link save(Link link);

    List<Link> findAll();

    Link findById(long id);

    Link findByEncodedId(String encoded);

    EncodedLink encode(Link link);
}
