package com.huyd.controller;

import com.huyd.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: huyd
 * Date: 2017/8/16 21:59
 * Description:
 */
@Controller
public class UserController {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView user() {
        User user = new User();
        user.setFavoriteFrameworks((new String[]{"Spring MVC", "Struts 2"}));
        user.setGender("M");
        ModelAndView modelAndView = new ModelAndView("user", "command", user);
        return modelAndView;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("SpringWeb") User user,
                          ModelMap model) {
        model.addAttribute("username", user.getUsername());//文本框，用户名
        model.addAttribute("password", user.getPassword());//密码框，密码
        model.addAttribute("address", user.getAddress());//文本域，地址
        model.addAttribute("receivePaper", user.isReceivePaper());//复选框，是否订阅
        model.addAttribute("favoriteFrameworks", user.getFavoriteFrameworks());//多选框，喜欢的框架
        model.addAttribute("gender", user.getGender());//单选按钮，性别
        model.addAttribute("favoriteNumber", user.getFavoriteNumber());//多项单选按钮，喜欢的数字
        model.addAttribute("country", user.getCountry());//下拉选项，所在的国家
        model.addAttribute("skills", user.getSkills());//列表多选框，技术
        return "userlist";
    }

    /**
     * 多选框
     *
     * @return
     */
    @ModelAttribute("webFrameworkList")
    public List<String> getWebFrameworkList() {
        List<String> webFrameworkList = new ArrayList<String>();
        webFrameworkList.add("Spring MVC");
        webFrameworkList.add("Struts 1");
        webFrameworkList.add("Struts 2");
        webFrameworkList.add("Apache Hadoop");
        return webFrameworkList;
    }

    /**
     * 单选按钮
     *
     * @return
     */
    @ModelAttribute("numbersList")
    public List<String> getNumbersList() {
        List<String> numbersList = new ArrayList<String>();
        numbersList.add("1");
        numbersList.add("2");
        numbersList.add("3");
        numbersList.add("4");
        return numbersList;
    }

    /**
     * 下拉框
     *
     * @return
     */
    @ModelAttribute("countryList")
    public Map<String, String> getCountryList() {
        Map<String, String> countryList = new HashMap<String, String>();
        countryList.put("US", "United States");
        countryList.put("CH", "China");
        countryList.put("SG", "Singapore");
        countryList.put("MY", "Malaysia");
        return countryList;
    }

    /**
     * 列表多选框
     *
     * @return
     */
    @ModelAttribute("skillsList")
    public Map<String, String> getSkillsList() {
        Map<String, String> skillList = new HashMap<String, String>();
        skillList.put("Hibernate", "Hibernate");
        skillList.put("Spring", "Spring");
        skillList.put("Apache Hadoop", "Apache Hadoop");
        skillList.put("Struts", "Struts");
        return skillList;
    }

}