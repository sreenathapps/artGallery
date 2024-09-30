package com.example.artgallery.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.example.artgallery.model.Artist;
import com.example.artgallery.model.Gallery;
import com.example.artgallery.repository.ArtistJpaRepository;
import com.example.artgallery.repository.ArtistRepository;
import com.example.artgallery.repository.GalleryJpaRepository;

/**
 * ArtistJpaService
 */
@Repository
public class ArtistJpaService implements ArtistRepository {
    @Autowired
    private ArtistJpaRepository artistJpaRepository;
    @Autowired
    private GalleryJpaRepository galleryJpaRepository;

    @Override
    public List<Artist> getArtists() {
        return artistJpaRepository.findAll();
    }

    @Override
    public Artist addArtist(Artist artist) {
        List<Integer> galleryIds = new ArrayList<>();
        for(Gallery g: artist.getGalleries()) {
            galleryIds.add(g.getGalleryId());
        }
        List<Gallery> galleries = galleryJpaRepository.findAllById(galleryIds);
        if (galleries.size() != galleryIds.size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        artist.setGalleries(galleries);
        return artistJpaRepository.save(artist);
    }

    @Override
    public Artist getArtist(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getArtist'");
    }

    @Override
    public Artist updateArtist(int id, Artist gallery) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateArtist'");
    }

    @Override
    public void deleteArtist(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteArtist'");
    }

    
}