package com.example.artgallery.repository;

import org.springframework.stereotype.Repository;

import com.example.artgallery.model.Artist;
import com.example.artgallery.model.Gallery;
import java.util.List;

/**
 * GalleryRepository
 */
@Repository
public interface GalleryRepository {
    List<Gallery> getGalleries();
    Gallery addGallery(Gallery gallery);
    Gallery getGallery(int id);
    Gallery updateGallery(int id, Gallery gallery);
    void deleteGallery(int id);
    List<Artist> getGalleryArtists(int galleryId);
}