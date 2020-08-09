package com.zalagaitis.springjacksonxmlparser.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String date;
    @Column
    private double impression;
    @Column
    private int clicks;
    @Column
    private BigDecimal earning;

    public Report() {
    }

    public Report(int id, String date, double impression, int clicks, BigDecimal earning) {
        this.id = id;
        this.date = date;
        this.impression = impression;
        this.clicks = clicks;
        this.earning = earning;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getImpression() {
        return impression;
    }

    public void setImpression(double impression) {
        this.impression = impression;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public BigDecimal getEarning() {
        return earning;
    }

    public void setEarning(BigDecimal earning) {
        this.earning = earning;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", date=" + date +
                ", impression=" + impression +
                ", clicks=" + clicks +
                ", earning=" + earning +
                '}';
    }
}
