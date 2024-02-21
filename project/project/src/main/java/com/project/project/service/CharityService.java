package com.project.project.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.project.model.charity;
import com.project.project.repository.CharityRepo;
@Service
public class CharityService {
    @Autowired
    private final CharityRepo pr;
    public CharityService(CharityRepo pr) {
        this.pr = pr;
    }
    public charity create(charity obj)
    {
        return pr.save(obj);
    }
    public List<charity> getAll()
    {
        return pr.findAll();
    }
    public charity getById(int id)
    {
        return pr.findById(id).orElse(null);
    }
    public void delete(int id) {
        pr.deleteById(id);

  }
  public charity update(charity obj) {
      return pr.save(obj);
  }
}