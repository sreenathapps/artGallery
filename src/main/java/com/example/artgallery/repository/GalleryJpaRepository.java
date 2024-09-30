package com.example.artgallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.artgallery.model.Gallery;

/**
 * GalleryJpaRepository
 */
@Repository
public interface GalleryJpaRepository  extends JpaRepository<Gallery, Integer> {    
}