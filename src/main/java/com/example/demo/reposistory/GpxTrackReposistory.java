package com.example.demo.reposistory;

import com.example.demo.domain.GpxTrack;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GpxTrackReposistory extends PagingAndSortingRepository<GpxTrack, Long> {
}
