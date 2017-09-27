package com.huyd.service.impl;

import com.huyd.dao.BookDao;
import com.huyd.model.Book;
import com.huyd.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: huyd
 * Date: 2017/9/10 20:07
 * Description:
 */
@Service
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //注入Service依赖
    @Autowired
    private BookDao bookDao;

    /**
     * 查询一本图书
     *
     * @param bookId
     * @return
     */
    public Book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    /**
     * 查询所有图书
     *
     * @return
     */
    public List<Book> getList() {
        return bookDao.queryAll(0, 100);
    }
}