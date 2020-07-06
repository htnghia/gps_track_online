package com.example.demo.controller;

import com.example.demo.core.model.FileNameAwareByteArrayResource;
import com.example.demo.service.GpxTrackService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(GpxTrackController.class)
public class GpxTrackResourceTest {

    static Long TEST_ID = 1l;
    static byte[] TEST_DATA = new byte[2];
    static String TEST_FILE_NAME = "test file name.gpx";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    GpxTrackService gpxTrackService;

    @Test
    public void download_shouldReturnCorrectDataAndFileName_whenSuccess() throws Exception {
        when(gpxTrackService.getResource(TEST_ID)).thenReturn(new FileNameAwareByteArrayResource(TEST_FILE_NAME, TEST_DATA));

        mockMvc.perform(MockMvcRequestBuilders.get(
                "/api/v1/gpx-track/{id}/download", 1))
                .andExpect(status().isOk())
                .andExpect(content().bytes(TEST_DATA))
                .andExpect(header().string("Content-Disposition",
                        String.format("attachment; filename=\"%s\"", TEST_FILE_NAME)));
    }
}
