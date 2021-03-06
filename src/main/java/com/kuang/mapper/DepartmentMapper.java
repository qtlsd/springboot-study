package com.kuang.mapper;

import com.kuang.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Mapper
//@Repository
public interface DepartmentMapper {
    //查询所有部门
    Collection<Department> queryDepartments();

    //通过id得到部门
    Department getDepartmentById(int id);
}
