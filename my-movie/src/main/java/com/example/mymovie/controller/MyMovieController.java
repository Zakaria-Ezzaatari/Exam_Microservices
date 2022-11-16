package com.example.mymovie.controller;

import com.example.mymovie.model.Acteur;
import com.example.mymovie.model.Film;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "MyMovieController", description = "REST Apis related to Film and Actor Entities!!!!")

@RestController

public class MyMovieController
{
    List<Acteur> acteurs = new ArrayList<Acteur>();
    {
        acteurs.add(new Acteur("nom11","prenom"));
        acteurs.add(new Acteur("nom1","prenom1"));
        acteurs.add(new Acteur("nom2","prenom2"));
    }

    List<Film> films = new ArrayList<Film>();
    {
        films.add(new Film("titre11","realiseur", acteurs.get(0),"2022"));
        films.add(new Film("titre2","realiseur2", acteurs.get(1),"2022"));
        films.add(new Film("titre3","realiseur3", acteurs.get(2),"2021"));
    }

    @ApiOperation(value = "Get list of Actors in the System ", response = Iterable.class, tags = "getActeurs")

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping(value = "/getActeurs")
    public List<Acteur> getActeurs() {
        return acteurs;
    }

    @ApiOperation(value = "Get specific Actor in the System by Name", response = Acteur.class, tags = "getActeur")

    @GetMapping(value = "/getActeur/{nom}")
    public Acteur getActeur(@PathVariable(value = "nom") String name) {
        return acteurs.stream().filter(x -> x.getNom().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
    }


    @ApiOperation(value = "Get list of Actors in the System that starred in a specific Film", response = Iterable.class, tags = "getActorsByFilm")

    @GetMapping(value = "/getActeursByFilm/{film}")
    public List<Acteur> getActorsByFilm(@PathVariable(value = "film") String film) {
        System.out.println("Searching Actors starring in  : " + film);
        List<Acteur> ActorsByFilm = acteurs.stream().filter(x -> x.getFilmographie().get("titre").equalsIgnoreCase(film))
                .collect(Collectors.toList());
        System.out.println(ActorsByFilm);
        return ActorsByFilm;
    }

    @ApiOperation(value = "Get list of Films in the System ", response = Iterable.class, tags = "getFilms")

    @GetMapping(value = "/getFilms")
    public List<Film> getFilms() {
        return films;
    }

    @ApiOperation(value = "Get a specific Film in the System by its title", response = Film.class, tags = "getFilms")

    @GetMapping(value = "/getFilm/{titre}")
    public Film getFilm(@PathVariable(value = "titre") String name) {
        return films.stream().filter(x -> x.getTitre().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get list of Films in the System that cam out a specific year", response = Iterable.class, tags = "getFilmsByActeur")

    @GetMapping(value = "/getFilmsByDate/{date}")
    public List<Film> getFilmsByActeur(@PathVariable(value = "date") String date) {
        System.out.println("Searching Films that came out in  : " + date);
        List<Film> FilmsByDate = films.stream().filter(x -> x.getDate().equalsIgnoreCase(date))
                .collect(Collectors.toList());
        System.out.println(FilmsByDate);
        return FilmsByDate;
    }






}
