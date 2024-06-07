package com.northcoders.record_shop.repository;

import com.northcoders.record_shop.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface RecordShopRepository extends CrudRepository<Album, Long> {
}
