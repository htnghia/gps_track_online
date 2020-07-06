package com.example.demo.service.impl;

import com.example.demo.domain.GpxTrack;
import com.example.demo.reposistory.GpxTrackReposistory;
import com.example.demo.controller.exception.NotFoundException;
import com.example.demo.service.GpxTrackService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class GpxTrackServiceImplTest {

    static String TEST_TITLE = "title";
    static String TEST_DESCRIPTION = "description";
    static byte[] TEST_DATA = new byte[2];
    static Long TEST_ID = 1l;

    @TestConfiguration
    static class GpxTrackServiceImplTestContextConfiguration {
        @Bean
        public GpxTrackService gpxTrackService() {
            return new GpxTrackTrackServiceImpl();
        }
    }

    @Autowired
    GpxTrackService gpxTrackService;

    @MockBean
    GpxTrackReposistory gpxTrackReposistory;

    MultipartFile mockMultipartFile = mock(MultipartFile.class);

    @Before
    public void setUp() throws IOException {
        when(mockMultipartFile.getBytes()).thenReturn(TEST_DATA);
    }

    @Test
    public void uploadFileSuccess_shouldSaveAndReturnCorrectData_WhenSuccess() throws IOException {
        GpxTrack inputGpxTrack = new GpxTrack(TEST_TITLE, TEST_DESCRIPTION);
        when(gpxTrackReposistory.save(inputGpxTrack)).thenReturn(inputGpxTrack);

        GpxTrack result = gpxTrackService.uploadFile(inputGpxTrack, mockMultipartFile);

        ArgumentCaptor<GpxTrack> argumentCaptor = ArgumentCaptor.forClass(GpxTrack.class);
        verify(gpxTrackReposistory, times(1))
                .save(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue()).isEqualToIgnoringNullFields(inputGpxTrack);
        assertThat(argumentCaptor.getValue().getData()).isEqualTo(TEST_DATA);
        assertThat(result).isEqualTo(inputGpxTrack);
    }

    @Test(expected = NotFoundException.class)
    public void getById_shouldThrowException_WhenNotFound() {
        when(gpxTrackReposistory.findById(TEST_ID)).thenReturn(Optional.empty());

        gpxTrackService.getById(TEST_ID);
    }

    @Test
    public void getById_shouldReturnResult_WhenSuccess() {
        GpxTrack gpxTrack = new GpxTrack(TEST_TITLE, TEST_DESCRIPTION);
        gpxTrack.setData(TEST_DATA);
        when(gpxTrackReposistory.findById(TEST_ID)).thenReturn(Optional.of(gpxTrack));

        GpxTrack actual = gpxTrackService.getById(TEST_ID);
        assertThat(actual).isEqualTo(gpxTrack);
    }

    @Test(expected = NotFoundException.class)
    public void getResource_shouldThrowException_WhenNotFound() {
        when(gpxTrackReposistory.findById(TEST_ID)).thenReturn(Optional.empty());

        gpxTrackService.getResource(TEST_ID);
    }

    @Test
    public void getResource_shouldReturnCorrectData_WhenSuccess() throws IOException {
        GpxTrack gpxTrack = new GpxTrack(TEST_TITLE, TEST_DESCRIPTION);
        gpxTrack.setData(TEST_DATA);
        when(gpxTrackReposistory.findById(TEST_ID)).thenReturn(Optional.of(gpxTrack));

        Resource actual = gpxTrackService.getResource(TEST_ID);

        assertThat(actual.getFilename()).isEqualTo(gpxTrack.getFileName());
        assertThat(actual.getInputStream().readAllBytes()).isEqualTo(TEST_DATA);
    }
}
