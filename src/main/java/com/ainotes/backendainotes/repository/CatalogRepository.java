package com.ainotes.backendainotes.repository;

import com.ainotes.backendainotes.model.Catalog;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends CrudRepository<Catalog, Long> {
}
