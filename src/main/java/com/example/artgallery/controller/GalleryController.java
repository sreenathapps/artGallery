package com.example.artgallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.artgallery.model.Artist;
import com.example.artgallery.model.Gallery;
import com.example.artgallery.service.GalleryJpaService;


/**
 * GalleryController
 */
@RestController
public class GalleryController {
    @Autowired
    private GalleryJpaService galleryJpaService;

    @GetMapping("/galleries")
    public java.util.List<Gallery> getMethodName() {
        return galleryJpaService.getGalleries();
    }

    @PostMapping("/galleries")
    public Gallery addGallery(@RequestBody Gallery gallery) {
        return galleryJpaService.addGallery(gallery);
    }

    @GetMapping("/galleries/{id}")
    public Gallery getGallery(@PathVariable int id) {
        return galleryJpaService.getGallery(id);
    }
    
    @PutMapping("/galleries/{id}")
    public Gallery updateGallery(@PathVariable int id, @RequestBody Gallery gallery) {
        return galleryJpaService.updateGallery(id, gallery);
    }
    @DeleteMapping("/galleries/{id}")
    public void deleteGallery(@PathVariable int id) {
        galleryJpaService.deleteGallery(id);
    }
    @GetMapping("/galleries/{id}/artists")
    public java.util.List<Artist> getGalleryArtists(@PathVariable int id) {
        return galleryJpaService.getGalleryArtists(id);
    }
    
}