package com.example.demo.reposistory;

import com.example.demo.domain.Gpx;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GpxReposistory extends PagingAndSortingRepository<Gpx, Long> {
}
