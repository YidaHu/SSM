package com.huyd.controller;

import com.huyd.model.Student;
import com.huyd.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Author: huyd
 * Date: 2017/8/13 22:34
 * Description:业务模块流程的控制
 */
@Controller
@RequestMapping("student")
public class StudentController {

    @Resource(name = "studentService")
    private StudentService studentService;

    //@ResponseBody(之前我因为加了这个注解，导致页面访问一直是406错误，注释了就好啦，具体为啥我暂时还不知道)
    @RequestMapping(value = "/getAllStudent", method = RequestMethod.GET)
    public ModelAndView getAllStudent() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("studentDisplay");
        mav.addObject("students", studentService.getAllStudent());
        return mav;
    }


    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("student", "command", new Student());
//        model.addAttribute("name", name);
//        model.addAttribute("age", age);
//        model.addAttribute("id", id);
//        return "student";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringWeb") Student student, ModelMap model) {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("result");
//        mav.addObject("students", student);
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        model.addAttribute("id", student.getId());
//        model.addAttribute("student", student);

        System.out.println("-->" + student.getName() + "-->" + student.getAge() + "-->" + student.getId());

        return "result";
    }

}