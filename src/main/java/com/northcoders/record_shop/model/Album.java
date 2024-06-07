package com.northcoders.record_shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Album")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    private Long id;
    private String name;
    private String artist;
    private int releaseYear;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int stock;



}
