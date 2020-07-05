package com.example.demo.service.impl;

import com.example.demo.domain.Gpx;
import com.example.demo.reposistory.GpxReposistory;
import com.example.demo.service.GpxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class GpxServiceImpl implements GpxService {

    @Autowired
    GpxReposistory gpxReposistory;

    @Override
    public Gpx uploadFile(String title, MultipartFile file) throws IOException {
        Gpx gpx = new Gpx();
        gpx.setTitle(title);
        gpx.setData(file.getBytes());
        return gpxReposistory.save(gpx);
    }

    @Override
    public Page<Gpx> getAll(Pageable paging) {
        return gpxReposistory.findAll(paging);
    }
}
