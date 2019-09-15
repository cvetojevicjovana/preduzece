/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.controller;

import com.preduzece.dto.VrstaOvlascenjaDTO;
import com.preduzece.entity.VrstaOvlascenja;
import com.preduzece.service.VrstaOvlascenjaService;
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
@RequestMapping("/vrstaovlascenja")
@CrossOrigin
public class VrstaOvlascenjaController {

    @Autowired
    VrstaOvlascenjaService vrstaOvlascenjaService;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "/all", method = GET)
    public List<VrstaOvlascenjaDTO> findAll() {
        List<VrstaOvlascenja> vrsteOvlascenja = vrstaOvlascenjaService.findAll();

        List<VrstaOvlascenjaDTO> vrsteOvlascenjaDTO = vrsteOvlascenja.stream()
                .map(vo -> modelMapper.map(vo, VrstaOvlascenjaDTO.class))
                .collect(Collectors.toList());

        return vrsteOvlascenjaDTO;

    }

    @RequestMapping(value = "/{id}", method = GET)
    public VrstaOvlascenjaDTO findById(@PathVariable int id) {
        VrstaOvlascenja vrstaOvlascenja = vrstaOvlascenjaService.findById(id);
        VrstaOvlascenjaDTO vrstaOvlascenjaDTO = modelMapper.map(vrstaOvlascenja, VrstaOvlascenjaDTO.class);
        return vrstaOvlascenjaDTO;
    }

    @RequestMapping(value = "/new", method = POST)
    public void save(@RequestBody VrstaOvlascenjaDTO vrstaOvlascenjaDTO) {
        VrstaOvlascenja vrstaOvlascenja = modelMapper.map(vrstaOvlascenjaDTO, VrstaOvlascenja.class);
        vrstaOvlascenjaService.saveOrUpdate(vrstaOvlascenja);
    }

    @RequestMapping(value = "/update", method = PUT)
    public VrstaOvlascenja update(@RequestBody VrstaOvlascenjaDTO vrstaOvlascenjaDTO) {
        VrstaOvlascenja vrstaOvlascenja = modelMapper.map(vrstaOvlascenjaDTO, VrstaOvlascenja.class);
        vrstaOvlascenjaService.saveOrUpdate(vrstaOvlascenja);
        return vrstaOvlascenja;
    }

    @RequestMapping(value = "/delete/{id}", method = DELETE)
    public void delete(@PathVariable int id) {
        vrstaOvlascenjaService.delete(id);
    }
}
