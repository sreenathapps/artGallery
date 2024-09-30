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
import com.example.artgallery.service.ArtJpaService;




/**
 * ArtController
 */
@RestController
public class ArtController {
    @Autowired
    private ArtJpaService artJpaService;

    @GetMapping("/galleries/artists/arts")
    public List<Art> getArts() {
        return artJpaService.getArts();
    }
    @GetMapping("/galleries/artists/arts/{id}")
    public Art getArt(@PathVariable int id) {
        return artJpaService.getArt(id);
    }
    @PostMapping("/galleries/artists/arts")
    public Art addArt(@RequestBody Art art) {
        return artJpaService.addArt(art);
    }
    @PutMapping("/galleries/artists/arts/{id}")
    public Art updateArt(@PathVariable int id, @RequestBody Art art) {
        return artJpaService.updateArt(id, art);
    }
    @DeleteMapping("/galleries/artists/arts/{id}")
    public void deleteArt(@PathVariable int id) {
        artJpaService.deleteArt(id);
    }
    @GetMapping("arts/{id}/artist")
    public Artist getArtist(@PathVariable int id) {
        return artJpaService.getArtArtist(id);
    }
    
    
    
}