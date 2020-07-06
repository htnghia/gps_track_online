package com.example.demo.controller;

import com.example.demo.domain.GpxTrack;
import com.example.demo.controller.dto.RequestPagingDto;
import com.example.demo.service.GpxTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/gpx-track")
public class GpxTrackController {

    @Autowired
    GpxTrackService gpxTrackService;

    @PostMapping
    public ResponseEntity<GpxTrack> uploadFile(@RequestParam("file") MultipartFile file,
                                               @RequestParam String title,
                                               @RequestParam String description) throws IOException {
        GpxTrack gpxTrack = new GpxTrack(title, description);
        return ResponseEntity.ok(gpxTrackService.uploadFile(gpxTrack, file));
    }

    @GetMapping
    public ResponseEntity<Page<GpxTrack>> findAll(RequestPagingDto pagingDto) {
        return ResponseEntity.ok(gpxTrackService.findAll(pagingDto.getPageable()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GpxTrack> getById(@PathVariable Long id) {
        return ResponseEntity.ok(gpxTrackService.getById(id));
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<Resource> download(@PathVariable Long id) throws IOException {
        Resource resource = gpxTrackService.getResource(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDisposition(
                ContentDisposition.builder("attachment").filename(resource.getFilename()).build()
        );
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

}
