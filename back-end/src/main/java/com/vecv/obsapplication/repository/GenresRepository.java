package com.vecv.obsapplication.repository;

import com.vecv.obsapplication.models.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepository extends JpaRepository<Genres,Long> {
}
