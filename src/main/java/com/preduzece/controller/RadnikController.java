/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.controller;

import com.preduzece.dto.RadnikDTO;
import com.preduzece.entity.Radnik;
import com.preduzece.service.RadnikService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roki
 */
@RestController
@RequestMapping("/radnik")
@CrossOrigin
public class RadnikController {

    @Autowired
    RadnikService radnikService;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "/all", method = GET)
    public List<RadnikDTO> findAll() {
        List<Radnik> radnici = radnikService.findAll();

        List<RadnikDTO> radniciDTO = radnici.stream()
                .map(radnik -> modelMapper.map(radnik, RadnikDTO.class))
                .collect(Collectors.toList());

        return radniciDTO;

    }

    @RequestMapping(value = "/{id}", method = GET)
    public RadnikDTO findById(@PathVariable int id) {
        Radnik radnik = radnikService.findById(id);
        RadnikDTO radnikDTO = modelMapper.map(radnik, RadnikDTO.class);
        return radnikDTO;
    }

    @RequestMapping(value = "/new", method = POST)
    public void save(@RequestBody RadnikDTO radnikDTO) {
        Radnik radnik = modelMapper.map(radnikDTO, Radnik.class);
        radnikService.saveOrUpdate(radnik);
    }

    @RequestMapping(value = "/update", method = PUT)
    public Radnik update(@RequestBody RadnikDTO radnikDTO) {
        Radnik radnik = modelMapper.map(radnikDTO, Radnik.class);
        radnikService.saveOrUpdate(radnik);
        return radnik;
    }

    @RequestMapping(value = "/delete/{id}", method = DELETE)
    public void delete(@PathVariable int id) {
        radnikService.delete(id);
    }

}
