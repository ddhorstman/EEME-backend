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
    public Link findByEncodedId(String encoded) {
        long linkId = Link.decode(encoded);
        return findById(linkId);
    }

    @Override
    public EncodedLink encode(Link link) {
        EncodedLink el = new EncodedLink();
        el.setOriginalUrl(link.getTarget());
        String encodedUrl = Link.encode(link.getId());
        encodedUrl = "http://localhost:2019/links/decode/" + encodedUrl;
        el.setEncodedUrl(encodedUrl);
        return el;
    }
}
