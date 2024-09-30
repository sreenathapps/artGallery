package com.example.artgallery.repository;

import org.springframework.stereotype.Repository;

import com.example.artgallery.model.Art;
import com.example.artgallery.model.Artist;
import com.example.artgallery.model.Gallery;

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
    List<Art> getArtistArts(int artistId);
    List<Gallery> getArtistGalleries(int artistId);
}