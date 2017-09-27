package com.huyd.dao;

import com.huyd.model.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: huyd
 * Date: 2017/9/10 19:43
 * Description:
 */
public interface BookDao {

    /**
     * 通过ID查询单本图书
     *
     * @param bookid
     * @return
     */
    Book queryById(long bookid);

    /**
     * 查询所有图书
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return
     */
    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 减少馆藏数量
     *
     * @param bookid
     * @return 如果影响行数等于>1，表示更新的记录行数
     */
    int reduceNumber(long bookid);

}