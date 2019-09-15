/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.controller;

import com.preduzece.dto.SpediterDTO;
import com.preduzece.entity.Spediter;
import com.preduzece.service.SpediterService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.util.ParallelSorter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roki
 */
@RestController
@RequestMapping("/spediter")
@CrossOrigin
public class SpediterController {

    @Autowired
    SpediterService spediterService;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "/all", method = GET)
    public List<SpediterDTO> findAll() {

        List<Spediter> spediteri = spediterService.findAll();
        List<SpediterDTO> spediteriDTO = spediteri.stream()
                .map(s -> modelMapper.map(s, SpediterDTO.class))
                .collect(Collectors.toList());
        return spediteriDTO;
    }

    @RequestMapping(value = "/{id}", method = GET)
    public SpediterDTO findById(@PathVariable int id) {

        Spediter spediter = spediterService.findById(id);
        SpediterDTO spediterDTO = modelMapper.map(spediter, SpediterDTO.class);
        return spediterDTO;
    }

    @RequestMapping(value = "/new", method = POST)
    public Spediter save(@RequestBody SpediterDTO spediterDTO) {
        Spediter spediter = modelMapper.map(spediterDTO, Spediter.class);
        spediterService.saveOrUdate(spediter);
        return spediter;
    }

    @RequestMapping(value = "/update", method = PUT)
    public Spediter update(@RequestBody SpediterDTO spediterDTO) {

        Spediter spediter = modelMapper.map(spediterDTO, Spediter.class);
        spediterService.saveOrUdate(spediter);
        return spediter;
    }

    @RequestMapping(value = "/delete/{id}", method = DELETE)
    public void delete(@PathVariable int id) {
        spediterService.delete(id);
    }

    @RequestMapping(value = "/search", method = GET)
    public List<SpediterDTO> search(@RequestParam(value = "id", required = false, defaultValue = "0") int id,
            @RequestParam(value = "naziv", required = false) String naziv,
            @RequestParam(value = "adresa", required = false) String adresa,
            @RequestParam(value = "telefon", required = false) String telefon,
            @RequestParam(value = "pib", required = false) String pib) {

        List<Spediter> spediteri = spediterService.search(id, naziv, adresa, telefon, pib);
        List<SpediterDTO> spediteriDTO = spediteri.stream()
                .map(s -> modelMapper.map(s, SpediterDTO.class))
                .collect(Collectors.toList());
        return spediteriDTO;
    }
}
