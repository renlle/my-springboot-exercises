package com.szs.springboot04.controller;

import com.szs.springboot04.dao.DepartmentDao;
import com.szs.springboot04.dao.EmployeeDao;
import com.szs.springboot04.entities.Department;
import com.szs.springboot04.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
/**
 *@Author SongZeShan
 *@Email renlle@qq.com
 *@Create ${DATE} ${TIME}
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    /**
     * 1.查询所有的员工,返回到列表页面
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        /**
         * 1.查询所有的员工,返回列表页面
         */
        model.addAttribute("emps",employees);

        //thymeleaf 默认就会拼串
        // public static final String DEFAULT_PREFIX = "classpath:/templates/xxx";
        //public static final String DEFAULT_SUFFIX = ".html";
        return "emp/list";
    }

    /**
     * 2.来到员工添加页面
     * @param model
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到员工添加页面 ,查出所有的部门在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    /**
     * 3.员工添加         --get查看,post创建,put更新,delete删除--
     * springMVC 自动将请求参数和入参对象的属性进行一一绑定,
     *  要求请求参数的名字和javabean入参的对象里面的属性名是一致的!
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //保存员工
        employeeDao.save(employee);
        //返回到员工列表 ,重定向redirect 或者 forward
        return "redirect:/emps";
    }

    /**             --get查看,post创建,put更新,delete删除--
     * 4.查出当前员工,在页面回显,进而修改员工信息页面 (使用同一修改页面)
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面,add.html 是一个修改添加二合一的页面
        return "/emp/add.html";
    }

    /**                     --get查看,post提交创建,put更新修改,delete删除--
     * 5: 员工修改,修改后还跳回员工列表页面
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public  String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 6: 员工删除
     * @param id
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
