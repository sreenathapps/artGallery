package com.example.artgallery.repository;

import org.springframework.stereotype.Repository;

import com.example.artgallery.model.Artist;

import java.util.*;
/**
 * ArtistRepository
 */
@Repository
public interface ArtistRepository {
    List<Artist> getArtists();
    Artist addArtist(Artist artist);
    Artist getArtist(int id);
    Artist updateArtist(int id, Artist gallery);
    void deleteArtist(int id);
}