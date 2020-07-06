package com.example.demo.domain;

import com.example.demo.core.model.AbstractGeneratedIdAuditableTime;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "gpx_track")
public class GpxTrack extends AbstractGeneratedIdAuditableTime {

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Transient
    String downloadUrl;

    @Transient
    String fileName;

    @Lob
    @JsonIgnore
    private byte[] data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownloadUrl() {
        return String.format("%d/download", this.getId());
    }

    public String getFileName() {
        return this.getTitle() + ".gpx";
    }

    @Basic(fetch = FetchType.LAZY)
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public GpxTrack() {
    }

    public GpxTrack(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
