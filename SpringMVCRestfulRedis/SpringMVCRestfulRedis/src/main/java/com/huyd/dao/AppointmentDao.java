package com.huyd.dao;

import com.huyd.model.Appointment;
import org.apache.ibatis.annotations.Param;

/**
 * Author: huyd
 * Date: 2017/9/11 18:44
 * Description:
 */
public interface AppointmentDao {
    /**
     * 插入预约图书记录
     *
     * @param bookid
     * @param studentid
     * @return 插入的行数
     */
    int insertAppointment(@Param("bookid") long bookid, @Param("studentid") long studentid);

    /**
     * 通过主键查询预约图书记录，并且携带图书实体
     *
     * @param bookid
     * @param studentid
     * @return
     */
    Appointment queryByKeyWithBook(@Param("bookid") long bookid, @Param("studentid") long studentid);

}