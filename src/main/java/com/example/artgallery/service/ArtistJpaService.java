package com.example.artgallery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.artgallery.model.Art;
import com.example.artgallery.model.Artist;
import com.example.artgallery.model.Gallery;
import com.example.artgallery.repository.ArtJpaRepository;
import com.example.artgallery.repository.ArtistJpaRepository;
import com.example.artgallery.repository.ArtistRepository;
import com.example.artgallery.repository.GalleryJpaRepository;

/**
 * ArtistJpaService
 */
@Service
public class ArtistJpaService implements ArtistRepository {
    @Autowired
    private ArtistJpaRepository artistJpaRepository;
    @Autowired
    private GalleryJpaRepository galleryJpaRepository;
    @Autowired
    private ArtJpaRepository artJpaRepository;

    @Override
    public List<Artist> getArtists() {
        return artistJpaRepository.findAll();
    }

    @Override
    public Artist addArtist(Artist artist) {
        List<Integer> galleryIds = new ArrayList<>();
        for (Gallery g : artist.getGalleries()) {
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
        return artistJpaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Artist updateArtist(int id, Artist artist) {
        Artist newArtist = artistJpaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (artist.getArtistName() != null) {
            newArtist.setArtistName(artist.getArtistName());
        }
        if (artist.getGenre() != null) {
            newArtist.setGenre(artist.getGenre());
        }
        if (artist.getGalleries() != null) {
            List<Integer> galleryIds = new ArrayList<>();
            for (Gallery g : artist.getGalleries()) {
                galleryIds.add(g.getGalleryId());
            }

            List<Gallery> galleries = galleryJpaRepository.findAllById(galleryIds);
            if (galleries.size() != galleryIds.size()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            newArtist.setGalleries(galleries);
        }

        return artistJpaRepository.save(newArtist);
    }

    @Override
    public void deleteArtist(int id) {
        Artist artist = artistJpaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        for (Gallery gallery : artist.getGalleries()) {
            gallery.getArtists().remove(artist);
        }
        galleryJpaRepository.saveAll(artist.getGalleries());

        List<Art> arts = artJpaRepository.findByArtist(artist);
        for (Art art : arts) {
            art.setArtist(null);
        }
        artJpaRepository.saveAll(arts);

        artistJpaRepository.deleteById(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public List<Art> getArtistArts(int artistId) {
        Artist artist = artistJpaRepository.findById(artistId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return artJpaRepository.findByArtist(artist);
    }

    @Override
    public List<Gallery> getArtistGalleries(int artistId) {
        Artist artist = artistJpaRepository.findById(artistId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return artist.getGalleries();
    }

}