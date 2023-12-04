package com.example.videoservicefatijebbari.Repositories;


import com.example.videoservicefatijebbari.entities.video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository  extends JpaRepository<video,Long> {


    List<video> findAll();


}