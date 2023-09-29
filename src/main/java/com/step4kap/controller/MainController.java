package com.step4kap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = { "/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/allEmployeeInfos" )
    public String allEmployeeInfos() {
        return "employeeInfos";
    }


    @RequestMapping(value = "/allProjects" )
    public String allProjects() {
        return "projects";
    }


    @RequestMapping(value = "/allPolicies" )
    public String allPolicies() {
        return "policies";
    }
}