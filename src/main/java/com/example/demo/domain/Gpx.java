package com.example.demo.domain;

import com.example.demo.core.model.AbstractGeneratedIdAuditableTime;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "gpx_track")
public class Gpx extends AbstractGeneratedIdAuditableTime {

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Lob
    @JsonIgnore
    private byte[] data;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic(fetch = FetchType.LAZY)
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
