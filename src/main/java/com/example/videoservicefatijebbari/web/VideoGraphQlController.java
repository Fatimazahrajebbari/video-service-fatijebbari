package com.example.videoservicefatijebbari.web;

import com.example.videoservicefatijebbari.Repositories.CreatorRepository;
import com.example.videoservicefatijebbari.Repositories.VideoRepository;
import com.example.videoservicefatijebbari.entities.creator;
import com.example.videoservicefatijebbari.entities.video;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.List;

public class VideoGraphQlController {
    private CreatorRepository creatorRepository;
    private VideoRepository videoRepository;

    VideoGraphQlController(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
    }

    @QueryMapping
    public List<video> videoList() {
        return videoRepository.findAll();
    }
    @QueryMapping
    public creator creatorById(@Argument Long id) {
        return creatorRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Creator %s not found",id)));
    }

}

