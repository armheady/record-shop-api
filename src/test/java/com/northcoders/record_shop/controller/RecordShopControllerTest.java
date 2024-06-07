package com.northcoders.record_shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.record_shop.model.Album;
import com.northcoders.record_shop.model.Genre;
import com.northcoders.record_shop.service.RecordShopService;
import com.northcoders.record_shop.service.RecordShopServiceImpl;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
class RecordShopControllerTest {

    @Mock
    private RecordShopServiceImpl mockRecordShopServiceImpl;
    @InjectMocks
    private RecordShopController recordShopController;
    @Autowired
    private MockMvc mockMvcController;

    @BeforeEach
    public void setup() {
        mockMvcController = MockMvcBuilders.standaloneSetup(recordShopController).build();
    }

    @Test
    @DisplayName("GET/All Albums")
    void testGetAllAlbumsReturnAlbums() throws Exception {

        List<Album> albumsList = List.of(new Album(1L, "It was written", "Nas", 1994, Genre.HIPHOP, 5),
                new Album(2L, "Coloring Book", "Chance the rapper", 2016, Genre.HIPHOP, 110),
                new Album(3L, "ForestHill Drive", "J.Cole", 2014, Genre.HIPHOP, 100));

        when(mockRecordShopServiceImpl.getAllAlbums()).thenReturn(albumsList);
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/record-shop/"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].artist").value("Chance the rapper"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].name").value(albumsList.get(2).getName()));
    }

    // Verifies that an empty list of albums is returned when no albums are available
    @Test
    @DisplayName("GET/All Albums - Empty List")
    void testGetAllAlbumsReturnEmptyList() throws Exception {

        List<Album> emptyList = Collections.emptyList();

        when(mockRecordShopServiceImpl.getAllAlbums()).thenReturn(emptyList);
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/record-shop/"))
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

}

