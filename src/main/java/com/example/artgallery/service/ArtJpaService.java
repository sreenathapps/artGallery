package com.example.artgallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.artgallery.model.Art;
import com.example.artgallery.model.Artist;
import com.example.artgallery.repository.ArtJpaRepository;
import com.example.artgallery.repository.ArtRepository;
import com.example.artgallery.repository.ArtistJpaRepository;

/**
 * ArtJpaService
 */
@Service
public class ArtJpaService implements ArtRepository {
    @Autowired
    private ArtJpaRepository artJpaRepository;
    @Autowired
    private ArtistJpaRepository artistJpaRepository;

    @Override
    public List<Art> getArts() {
        return artJpaRepository.findAll();
    }

    @Override
    public Art getArt(int id) {
        Art art = artJpaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return art;
    }

    @Override
    public Art addArt(Art art) {
        int artistId = art.getArtist().getArtistId();
        art.setArtist(artistJpaRepository.findById(artistId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST)));
        return artJpaRepository.save(art);
    }

    @Override
    public Art updateArt(int id, Art art) {
        Art newArt = artJpaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (art.getTheme() != null) {
            newArt.setTheme(art.getTheme());
        }
        if (art.getArtTitle() != null) {
            newArt.setArtTitle(art.getArtTitle());
        }
        if (art.getArtist() != null) {
            newArt.setArtist(artistJpaRepository.findById(art.getArtist().getArtistId()).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        }
        return artJpaRepository.save(newArt);
    }

    @Override
    public void deleteArt(int id) {
        try {
            artJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Artist getArtArtist(int artId) {
        return artJpaRepository.findById(artId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)).getArtist();
    }

}