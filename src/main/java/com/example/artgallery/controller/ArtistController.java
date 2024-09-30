package com.example.artgallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.artgallery.model.Art;
import com.example.artgallery.model.Artist;
import com.example.artgallery.model.Gallery;
import com.example.artgallery.service.ArtistJpaService;
import org.springframework.web.bind.annotation.RequestParam;




/**
 * ArtistController
 */
@RestController
public class ArtistController {
    @Autowired
    private ArtistJpaService artistJpaService;

    @GetMapping("/galleries/artists")
    public List<Artist> getArtists() {
        return artistJpaService.getArtists();
    }
    @PostMapping("/galleries/artists")
    public Artist addArtist(@RequestBody Artist artist) {
        return artistJpaService.addArtist(artist);
    }
    @GetMapping("/galleries/artists/{id}")
    public Artist getArtist(@PathVariable int id) {
        return artistJpaService.getArtist(id);
    }
    @PutMapping("/galleries/artists/{id}")
    public Artist updateArtist(@PathVariable int id, @RequestBody Artist artist) {
        return artistJpaService.updateArtist(id, artist);
    }
    @DeleteMapping("/galleries/artists/{id}")
    public void deleteArtist(@PathVariable int id) {
        artistJpaService.deleteArtist(id);
    }
    @GetMapping("/artist/{id}/art")
    public List<Art> getArtistArts(@PathVariable int id) {
        return artistJpaService.getArtistArts(id);
    }
    @GetMapping("/artist/{id}/galleries")
    public List<Gallery> getArtistGalleries(@PathVariable int id) {
        return artistJpaService.getArtistGalleries(id);
    }
    
    

}