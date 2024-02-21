package com.project.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.project.model.charity;
import com.project.project.service.CharityService;
@RestController
public class CharityController {
    @Autowired
    private final CharityService ps;
    public CharityController(CharityService ps) {
        this.ps = ps;
    }

    @PostMapping("/api/product/add")
    public ResponseEntity<charity> create(@RequestBody charity obj)
    {
        return new ResponseEntity<>(ps.create(obj),HttpStatus.CREATED);
    }
    @GetMapping("/api/product")
    public ResponseEntity<List<charity>> getAll()
    {
        return new ResponseEntity<>(ps.getAll(),HttpStatus.OK);
    }
    @GetMapping("/api/product/{productId}")
    public ResponseEntity<charity> getById(@PathVariable int productId)
    {
        charity obj = ps.getById(productId);
            return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @PutMapping("/api/charity/update/{charityId}")
    public ResponseEntity<charity> update(@PathVariable int charityId, @RequestBody charity obj) {
        charity existingCharity = ps.getById(charityId);
        if (existingCharity != null) {
            obj.setId(charityId); 
            ps.create(obj); 
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/charity/delete/{charityId}")
    public ResponseEntity<Void> delete(@PathVariable int charityId) {
        charity existingCharity = ps.getById(charityId);
        if (existingCharity != null) {
            ps.delete(charityId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
