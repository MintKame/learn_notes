package com.yz.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
    /*
    ! 需配置：HiddenHttpMethodFilter（见 web.xml）
        查所有：/student       GET
        增：    /student       POST
        删：    /student/{id}  DELETE
        改：    /student       PUT
     */
    @Autowired
    StudentDao studentDao;

    @RequestMapping(value = "student", method = RequestMethod.GET)
    String getAll(Model model){
        model.addAttribute("studentList", studentDao.getAll());
        return "student_list";
    }

    @RequestMapping(value = "student", method = RequestMethod.POST)
    String add(Student student){
        studentDao.save(student);
        return "redirect:/";
    }

    @RequestMapping(value = "student/{id}", method = RequestMethod.DELETE)
    String deleteById(@PathVariable("id") Integer id){
        studentDao.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "student", method = RequestMethod.PUT)
    String update(Student student){
        studentDao.save(student);
        return "redirect:/";
    }
}
