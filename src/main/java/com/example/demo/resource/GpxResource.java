package com.example.demo.resource;

import com.example.demo.domain.Gpx;
import com.example.demo.resource.dto.RequestPagingDto;
import com.example.demo.service.GpxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController("/api/v1/gpx")
public class GpxResource {

    @Autowired
    GpxService gpxService;

    @PostMapping
    public ResponseEntity<Gpx> uploadFile(@RequestParam("file") MultipartFile file,
                                          @RequestParam String title) throws IOException {
        return ResponseEntity.ok(gpxService.uploadFile(title, file));
    }

    @GetMapping
    public ResponseEntity<Page<Gpx>> getListFile(RequestPagingDto pagingDto) {
        return ResponseEntity.ok(gpxService.getAll(pagingDto.getPageable()));
    }

}
