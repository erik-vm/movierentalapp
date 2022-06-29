package com.example.fujitsuexercise.omdbapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "omdbapiplaceholder", url = "http://www.omdbapi.com/?apikey=d78ee6be&")
public interface OMDbAPIPlaceHolder {

    @GetMapping("i={imdbId}")
    OMDbMovie getMovieByIMDbId(@PathVariable("imdbId") String imdbId);

    @GetMapping("t={title}")
    OMDbMovie getMovieByTitle(@PathVariable("title") String title);

    @GetMapping("t={title}&y={year}")
    OMDbMovie getMovieByTitleAndYear(@PathVariable("title") String title, @PathVariable("year") Long year);

}
