/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.controller;


import com.fasterxml.jackson.annotation.JsonView;
import com.preduzece.dto.MemorandumDTO;
import com.preduzece.dto.StavkeMemorandumaDTO;
import com.preduzece.entity.Memorandum;
import com.preduzece.entity.StavkeMemoranduma;
import com.preduzece.entity.StavkeMemorandumaID;
import com.preduzece.service.MemorandumService;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roki
 */
@RestController
@RequestMapping("/memorandum")
@CrossOrigin
@JsonView
public class MemorandumController {

    @Autowired
    MemorandumService memorandumService;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "/all", method = GET)
    public List<MemorandumDTO> findAll() {
        List<Memorandum> memorandumi = memorandumService.findAll();

        List<MemorandumDTO> memorandumiDTO = new ArrayList<>();

        for (Memorandum memorandum : memorandumi) {
            memorandumiDTO.add(mapiraj(memorandum));
        }

        return memorandumiDTO;

    }

    @RequestMapping(value = "/{id}", method = GET)
    public MemorandumDTO findById(@PathVariable int id) {
        Memorandum memorandum = memorandumService.findById(id);
        MemorandumDTO memorandumDTO = mapiraj(memorandum);
        return memorandumDTO;
    }

    @RequestMapping(value = "delete/{id}", method = DELETE)
    public void delete(@PathVariable int id) {
        memorandumService.deleteById(id);
    }

    @RequestMapping(value = "/new", method = POST)
    public MemorandumDTO save(@RequestBody MemorandumDTO memorandumDTO) {
        System.out.println(memorandumDTO);
        Memorandum memorandum = modelMapper.map(memorandumDTO, Memorandum.class);
        for (StavkeMemoranduma stavkeMemoranduma : memorandum.getStavkeMemoranduma()) {
            stavkeMemoranduma.setId(new StavkeMemorandumaID(0, memorandumDTO.getStavkeMemoranduma().get(memorandum.getStavkeMemoranduma().indexOf(stavkeMemoranduma)).getRedniBroj().getRedniBroj()));
        }
        memorandum = memorandumService.saveOrUpdate(memorandum);
        return mapiraj(memorandum);
    }

    @RequestMapping(value = "/update/{id}", method = PUT)
    public MemorandumDTO update(@RequestBody MemorandumDTO memorandumDTO, @PathVariable int id) {
        Memorandum memorandum = modelMapper.map(memorandumDTO, Memorandum.class);

        if (memorandum.getStavkeMemoranduma() != null) {
            for (StavkeMemoranduma stavkeMemoranduma : memorandum.getStavkeMemoranduma()) {
                stavkeMemoranduma.setId(new StavkeMemorandumaID(id, memorandumDTO.getStavkeMemoranduma().get(memorandum.getStavkeMemoranduma().indexOf(stavkeMemoranduma)).getRedniBroj().getRedniBroj()));
            }
        }

        memorandum = memorandumService.saveOrUpdate(memorandum);
        return mapiraj(memorandum);
    }

    @RequestMapping(value = "/search", method = GET)
    public List<MemorandumDTO> search(@RequestParam(value = "id", required = false, defaultValue = "0") int id,
            @RequestParam(value = "datumOd", required = false) String datumOd,
            @RequestParam(value = "spediter", required = false) String spediter,
            @RequestParam(value = "status", required = false) String status) {

        List<Memorandum> memorandumi = memorandumService.search(id, datumOd, spediter, status);

        List<MemorandumDTO> memorandumiDTO = new ArrayList<>();

        for (Memorandum memorandum : memorandumi) {
            memorandumiDTO.add(mapiraj(memorandum));
        }

        return memorandumiDTO;
    }

    private MemorandumDTO mapiraj(Memorandum memorandum) {

        MemorandumDTO memorandumDTO = modelMapper.map(memorandum, MemorandumDTO.class);

        if (memorandum.getStavkeMemoranduma() != null) {
            for (StavkeMemorandumaDTO stavkeMemorandumaDTO : memorandumDTO.getStavkeMemoranduma()) {
                StavkeMemorandumaID redniBroj = memorandum.getStavkeMemoranduma().get(memorandumDTO.getStavkeMemoranduma()
                        .indexOf(stavkeMemorandumaDTO)).getId();
                stavkeMemorandumaDTO.setRedniBroj(redniBroj);
                stavkeMemorandumaDTO.setMemorandum(memorandumDTO);
            }
        }

        return memorandumDTO;
    }
}
