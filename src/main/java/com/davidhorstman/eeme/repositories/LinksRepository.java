package com.davidhorstman.eeme.repositories;

import com.davidhorstman.eeme.models.Link;
import org.springframework.data.repository.CrudRepository;

public interface LinksRepository extends CrudRepository<Link, Long> {
}
