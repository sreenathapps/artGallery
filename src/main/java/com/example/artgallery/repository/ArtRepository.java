package com.example.artgallery.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.artgallery.model.Art;
import com.example.artgallery.model.Artist;

/**
 * ArtRepository
 */
@Repository
public interface ArtRepository {
    List<Art> getArts();
    Art getArt(int id);
    Art addArt(Art art);
    Art updateArt(int id, Art art);
    void deleteArt(int id);
    Artist getArtArtist(int artId);
}