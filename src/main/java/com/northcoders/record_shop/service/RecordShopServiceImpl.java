package com.northcoders.record_shop.service;

import com.northcoders.record_shop.model.Album;
import com.northcoders.record_shop.repository.RecordShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
@Service
public class RecordShopServiceImpl implements RecordShopService {

    @Autowired
    RecordShopRepository recordShopRepository;


    @Override
    public List<Album> getAllAlbums() {
        List<Album> Albums = new ArrayList<>();
        recordShopRepository.findAll().forEach(album -> Albums.add(album));
        return null;
    }
}
