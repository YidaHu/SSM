package com.huyd.service;

import com.huyd.dao.StudentDao;
import com.huyd.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: huyd
 * Date: 2017/8/13 22:36
 * Description:业务模块的逻辑应用设计
 */
@Service("studentService")
public class StudentService {
    @Resource(name = "studentDao")
    private StudentDao dao;

    /**
     * 获取学生
     *
     * @return
     */
    public List<Student> getAllStudent() {
        return dao.findAll();
    }

}