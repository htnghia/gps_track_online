package com.example.demo.service;

import com.example.demo.domain.Gpx;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface GpxService {
    Gpx uploadFile(String title, MultipartFile file) throws IOException;

    Page<Gpx> getAll(Pageable paging);
}
