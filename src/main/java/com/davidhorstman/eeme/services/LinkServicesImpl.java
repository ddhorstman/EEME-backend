package com.davidhorstman.eeme.services;

import com.davidhorstman.eeme.models.Link;
import com.davidhorstman.eeme.repositories.LinksRepository;
import com.davidhorstman.eeme.views.EncodedLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("linkServices")
public class LinkServicesImpl implements LinkServices {

    @Autowired
    LinksRepository linksRepository;

    @Override
    public Link save(Link link) {
        return linksRepository.save(link);
    }

    @Override
    public List<Link> findAll() {
        List<Link> list = new ArrayList<>();
        linksRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Link findById(long id) {
        return linksRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Could not find link with id '" + id + "'.")
        );
    }

    @Override
    public EncodedLink findByEncodedId(String encoded) {
        long linkId = EncodedLink.decode(encoded);
        Link link = findById(linkId);
        EncodedLink el = new EncodedLink();
        el.setTarget(link.getTarget());
        el.setId(linkId);
        el.setEncodedPath(encoded);
        return el;
    }

    @Override
    public EncodedLink encode(Link link) {
        EncodedLink el = new EncodedLink();
        String encodedUrl = EncodedLink.encode(link.getId());
        el.setId(link.getId());
        el.setTarget(link.getTarget());
        el.setEncodedPath(encodedUrl);
        return el;
    }
}
