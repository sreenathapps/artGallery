package com.example.artgallery.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.artgallery.model.Artist;
import com.example.artgallery.model.Gallery;
import com.example.artgallery.repository.ArtistJpaRepository;
import com.example.artgallery.repository.GalleryJpaRepository;
import com.example.artgallery.repository.GalleryRepository;

/**
 * GalleryJpaService
 */
@Service
public class GalleryJpaService implements GalleryRepository{
    @Autowired
    private GalleryJpaRepository galleryRepository;

    @Autowired
    private ArtistJpaRepository artistJpaRepository;

    @Override
    public List<Gallery> getGalleries() {
        return galleryRepository.findAll();
    }

    @Override
    public Gallery addGallery(Gallery gallery) {
        try {
            List<Integer> artistIds = new ArrayList<>();
            for (Artist artist : gallery.getArtists()) {
                artistIds.add(artist.getArtistId());
            }
            List<Artist> artists = artistJpaRepository.findAllById(artistIds);

            if (artistIds.size() != artists.size()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
            
            gallery.setArtists(artists);

            for(Artist a: artists) {
                a.getGalleries().add(gallery);
            };
            Gallery savedGallery = galleryRepository.save(gallery);
            artistJpaRepository.saveAll(artists);

            return savedGallery;
            

        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Gallery getGallery(int id) {
        return galleryRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
            );
    }

    @Override
    public Gallery updateGallery(int id, Gallery gallery) {
        Gallery newGallery = galleryRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
            );
        if (gallery.getGalleryName() != null) {
            newGallery.setGalleryName(gallery.getGalleryName());
        }
        if (gallery.getLocation() != null) {
            newGallery.setLocation(gallery.getLocation());
        }
        if (gallery.getArtists() != null) {
            List<Artist> oldArtists = newGallery.getArtists();
            for (Artist artist : oldArtists) {
                artist.getGalleries().remove(newGallery);
            }
            artistJpaRepository.saveAll(oldArtists);

            List<Integer>  artistIds = new ArrayList<>();
            for(Artist a: gallery.getArtists()) {
                artistIds.add(a.getArtistId());
            }
            List<Artist> artists = artistJpaRepository.findAllById(artistIds);
            if (artists.size() != artistIds.size()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
            for (Artist artist : artists) {
                artist.getGalleries().add(newGallery);
            }

            artistJpaRepository.saveAll(artists);

            newGallery.setArtists(artists);
        }
        
        return galleryRepository.save(newGallery);
    }

    @Override
    public void deleteGallery(int id) {
        Gallery gallery = galleryRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        for (Artist a : gallery.getArtists()) {
            a.getGalleries().remove(gallery);
        }
        artistJpaRepository.saveAll(gallery.getArtists());
        galleryRepository.deleteById(id);

        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
    @Override
    public List<Artist> getGalleryArtists(int galleryId) {
        Gallery gallery = galleryRepository.findById(galleryId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return gallery.getArtists();
    }

    
}