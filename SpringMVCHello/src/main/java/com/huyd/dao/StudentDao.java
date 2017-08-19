package com.huyd.dao;

import com.huyd.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: huyd
 * Date: 2017/8/13 22:37
 * Description:数据持久层
 */
@Repository("studentDao")
public class StudentDao {
    /**
     * 获取学生
     *
     * @return
     */
    public List<Student> findAll() {
        List<Student> all = new ArrayList<Student>();
        all.add(new Student("1", "tom", 18, true));
        all.add(new Student("2", "cat", 28, true));
        all.add(new Student("3", "lxk", 18, true));
        all.add(new Student("4", "cms", 18, true));
        return all;
    }
}