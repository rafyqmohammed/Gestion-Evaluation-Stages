package com.example.demo.Dto;

import java.time.LocalDate;

public class PeriodeDto {

    private LocalDate db;
    private LocalDate df;

    public PeriodeDto() {
    }
    public PeriodeDto(LocalDate db, LocalDate df) {
        this.db = db;
        this.df = df;
    }
    public LocalDate getDb() {
        return db;
    }
    public void setDb(LocalDate db) {
        this.db = db;
    }
    public LocalDate getDf() {
        return df;
    }
    public void setDf(LocalDate df) {
        this.df = df;
    }

}
