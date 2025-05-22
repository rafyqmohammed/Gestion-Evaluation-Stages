package com.example.demo.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

@Embeddable
public class AppreciationId {
    private Long tuteurId;
    private  PeriodeId periodeId;

    public AppreciationId() {}

    public AppreciationId(Long tuteurId, PeriodeId periodeId) {
        this.tuteurId = tuteurId;
        this.periodeId = periodeId;
    }

    public Long getTuteurId() {
        return tuteurId;
    }

    public void setTuteurId(Long tuteurId) {
        this.tuteurId = tuteurId;
    }

    public PeriodeId getPeriodeId() {
        return periodeId;
    }

    public void setPeriodeId(PeriodeId periodeId) {
        this.periodeId = periodeId;
    }

    @Override
    public String toString() {
        return "AppreciationId{" +
                "tuteurId=" + tuteurId +
                ", periodeId=" + periodeId +
                '}';
    }
}
