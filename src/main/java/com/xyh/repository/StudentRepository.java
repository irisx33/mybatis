package com.xyh.repository;

import com.xyh.entity.Student;

/**
 * @author xyh
 * @version 1.0
 */
public interface StudentRepository {
    public Student findById(Integer id);

}
