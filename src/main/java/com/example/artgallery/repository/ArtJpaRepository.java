package com.example.artgallery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.artgallery.model.Art;
import com.example.artgallery.model.Artist;

/**
 * ArtJpaRepository
 */
@Repository
public interface ArtJpaRepository extends JpaRepository<Art, Integer>{
    List<Art> findByArtist(Artist artist);
}