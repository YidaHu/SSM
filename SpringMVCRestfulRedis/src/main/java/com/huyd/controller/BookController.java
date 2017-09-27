package com.huyd.controller;

import com.alibaba.fastjson.JSON;
import com.huyd.model.Book;
import com.huyd.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: huyd
 * Date: 2017/9/10 20:16
 * Description:
 */
@Controller
@RestController
@RequestMapping("/book")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    private String list(Model model) {
        List<Book> list = bookService.getList();
        model.addAttribute("list", list);
//        return "list";
        return serialize(list);
    }

    @RequestMapping(value = "/{bookid}/detail", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    private String detail(@PathVariable("bookid") Long bookid, Model model) {
        if (bookid == null) {
            return "redirect:/book/list";
        }
        Book book = bookService.getById(bookid);
        if (book == null) {
            return "forward:/book/list";
        }
        model.addAttribute("book", book);
//        return "detail";
        return serialize(book);
    }

    public static <T> String serialize(T object) {
        return JSON.toJSONString(object);
    }


}