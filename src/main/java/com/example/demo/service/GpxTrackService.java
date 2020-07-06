package com.example.demo.service;

import com.example.demo.domain.GpxTrack;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface GpxTrackService {

    GpxTrack uploadFile(GpxTrack gpxTrack, MultipartFile file) throws IOException;

    Page<GpxTrack> findAll(Pageable paging);

    GpxTrack getById(Long id);

    Resource getResource(Long id);
}
