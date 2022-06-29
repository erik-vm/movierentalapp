package com.example.fujitsuexercise.omdbapi;

import lombok.Data;

import java.util.Date;

@Data
public class OMDbMovie {

    private String imdbID;
    private String title;
    private String year;
    private String released;
    private String director;
    private String actors;
    private String plot;
    private String genre;

}
