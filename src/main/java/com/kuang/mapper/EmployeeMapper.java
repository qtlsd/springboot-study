package com.kuang.mapper;

import com.kuang.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
//@Repository
public interface EmployeeMapper {
    //得到所有员工
    List<Employee> getAllEmployee();

    //通过id得到员工
    Employee getEmployeeById(int id);

    //增
    int insertEmp(Employee employee);

    //删
    int deleteEmp(int id);

    //改
    int updateEmp(Employee employee);

}
