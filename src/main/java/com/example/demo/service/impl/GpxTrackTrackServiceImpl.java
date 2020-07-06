package com.example.demo.service.impl;

import com.example.demo.core.model.FileNameAwareByteArrayResource;
import com.example.demo.domain.GpxTrack;
import com.example.demo.reposistory.GpxTrackReposistory;
import com.example.demo.controller.exception.NotFoundException;
import com.example.demo.service.GpxTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class GpxTrackTrackServiceImpl implements GpxTrackService {

    @Autowired
    GpxTrackReposistory gpxTrackReposistory;

    @Override
    public GpxTrack uploadFile(GpxTrack gpxTrack, MultipartFile file) throws IOException {
        gpxTrack.setData(file.getBytes());
        return gpxTrackReposistory.save(gpxTrack);
    }

    @Override
    public Page<GpxTrack> findAll(Pageable paging) {
        return gpxTrackReposistory.findAll(paging);
    }

    @Override
    public GpxTrack getById(Long id) {
        Optional<GpxTrack> gpx = gpxTrackReposistory.findById(id);
        if (gpx.isEmpty()) {
            throw new NotFoundException("Not found gpx with id: " + id);
        }
        return gpx.get();
    }

    @Override
    public Resource getResource(Long id) {
        GpxTrack gpxTrack = this.getById(id);
        return new FileNameAwareByteArrayResource(gpxTrack.getFileName(), gpxTrack.getData());
    }
}
