package com.xyh.repository;

import com.xyh.entity.People;

import java.util.List;

/**
 * @author xyh
 * @version 1.0
 */
public interface PeopleRepository {
    public int save(People people);
    public int deleteById(Integer id);
    public int update(People people);
    public People findById(Integer id);
    public List<People> findAll();
    public People findByIdAndName(Integer id, String name);
    public Integer count();
    public String findNameById(Integer id);
}
