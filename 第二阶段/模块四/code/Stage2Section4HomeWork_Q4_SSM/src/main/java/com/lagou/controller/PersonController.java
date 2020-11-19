package com.lagou.controller;

import com.lagou.domain.Person;
import com.lagou.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Administrator
 */

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    //    查询所有用户

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Person> list = personService.findAll();
        model.addAttribute("list", list);

        return "list";
    }

    // 添加用户

    @RequestMapping("/save")
    public String save (Person person){
        personService.save(person);
        // 跳转到findAll方法 ，重新查询数据库进行数据展示
        return "redirect:/person/findAll";
    }

    // 根据ID查询账户信息 完成账户回显

    @RequestMapping("/findById")
    public String findById (Integer personId, Model model){
        Person person = personService.findById(personId);
        // 存入model中
        model.addAttribute("person", person);
        // 视图跳转
        return "update";
    }


}
