package com.kuang.controller;

import com.kuang.mapper.DepartmentMapper;
import com.kuang.mapper.EmployeeMapper;
import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeCotroller {
    /*
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //显示员工列表
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "/emp/list";
    }

    //跳转增加员工页面
    @GetMapping("/getemp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getAllDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    //增加后跳转回list
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("save employee:"+employee);
        employeeDao.addEmployee(employee);
        return "redirect:/emps";
    }

    //跳转到修改员工页面
    @GetMapping("/emp/{id}")
    public String toUpdate(@PathVariable("id")Integer id, Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);

        Collection<Department> departments = departmentDao.getAllDepartments();
        model.addAttribute("departments",departments);
        return "emp/update";
    }


    //员工信息修改
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.addEmployee(employee);
        return "redirect:/emps";
    }

    //员工删除页面
    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    //登出
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }*/

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    //显示员工列表
    @RequestMapping("/emps")
    public String list(Model model){
        List<Employee> employees = employeeMapper.getAllEmployee();
        for (Employee employee : employees) {
        }
        model.addAttribute("emps",employees);
        return "/emp/list";
    }

    //跳转增加员工页面
    @GetMapping("/getemp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentMapper.queryDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    //增加后跳转回list
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("employee->"+employee);
        employeeMapper.insertEmp(employee);
        return "redirect:/emps";
    }


    //跳转到修改员工页面
    @GetMapping("/emp/{id}")
    public String toUpdate(@PathVariable("id")Integer id,Model model){
        Employee employee = employeeMapper.getEmployeeById(id);
        System.out.println(employee);
        model.addAttribute("emp",employee);

        Collection<Department> departments = departmentMapper.queryDepartments();
        model.addAttribute("departments",departments);
        return "emp/update";
    }


    //员工信息修改
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeMapper.updateEmp(employee);
        return "redirect:/emps";
    }


    //员工删除页面
    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeMapper.deleteEmp(id);
        return "redirect:/emps";
    }


    //登出
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";

    }
}
