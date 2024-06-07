package com.northcoders.record_shop.model;

import jakarta.persistence.*;
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

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String artist;
    private int releaseYear;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int stock;



}
