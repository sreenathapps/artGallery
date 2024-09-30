package com.example.artgallery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.artgallery.model.Artist;
import com.example.artgallery.repository.ArtistRepository;

/**
 * ArtJpaService
 */
@Service
public class ArtJpaService implements ArtistRepository {

    @Override
    public List<Artist> getArtists() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getArtists'");
    }

    @Override
    public Artist addArtist(Artist artist) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addArtist'");
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