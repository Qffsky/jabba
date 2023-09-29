package com.step4kap.controller;

import com.step4kap.dao.EmployeeInfoDAO;
import com.step4kap.dao.PolicyDAO;
import com.step4kap.dao.ProjectDAO;
import com.step4kap.db.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PolicyController {

    @Autowired
    private final EmployeeInfoDAO employeeInfoDAO = new EmployeeInfoDAO();

    @Autowired
    private final ProjectDAO projectDAO = new ProjectDAO();

    @Autowired
    private final PolicyDAO policyDAO = new PolicyDAO();

    @GetMapping("/employeeInfos")
    public String peopleListPage(Model model) {
        List<EmployeeInfo> employeeInfos = (List<EmployeeInfo>) employeeInfoDAO.getAll();
        model.addAttribute("employeeInfo", employeeInfos);
        model.addAttribute("employeeInfoService", employeeInfoDAO);
        return "employeeInfos";
    }

    @GetMapping("/employeeInfo")
    public String personPage(@RequestParam(name = "employeeInfoId") Integer employeeInfoId, Model model) {
        EmployeeInfo person = employeeInfoDAO.getById(employeeInfoId);

        if (person == null) {
            model.addAttribute("error_msg", "В базе нет служащего с Id = " + employeeInfoId);
            return "errorPage";
        }

        model.addAttribute("person", person);
        model.addAttribute("employeeInfoService", employeeInfoDAO);
        model.addAttribute("projectService", projectDAO);
        model.addAttribute("policyService", policyDAO);
        return "employeeInfo";
    }

    @GetMapping("/editEmployeeInfo")
    public String editPersonPage(@RequestParam(name = "employeeInfoId", required = false) Integer employeeInfoId, Model model) {
        if (employeeInfoId == null) {
            model.addAttribute("employeeInfo", new EmployeeInfo());
            model.addAttribute("employeeInfoService", employeeInfoDAO);
            return "editEmployeeInfo";
        }

        EmployeeInfo employeeInfo = employeeInfoDAO.getById(employeeInfoId);

        if (employeeInfo == null) {
            model.addAttribute("error_msg", "В базе нет служащего с Id = " + employeeInfoId);
            return "errorPage";
        }

        model.addAttribute("person", employeeInfo);
        model.addAttribute("personService", employeeInfoDAO);
        return "editEmployeeInfo";
    }

    @PostMapping("/saveEmployeeInfo")
    public String savePersonPage(@RequestParam(name = "employeeInfoId") Integer employeeInfoId,
                                 @RequestParam(name = "fullname") String fullname,
                                 @RequestParam(name = "homeaddress") String address,
                                 @RequestParam(name = "education") String education,
                                 @RequestParam(name = "workexperience") String workexperience,
                                 @RequestParam(name = "jobtitle") String jobtitle,
                                 @RequestParam(name = "salary") Integer salary,
                                 Model model) {
        EmployeeInfo employeeInfo = employeeInfoDAO.getById(employeeInfoId);

        if (employeeInfo != null) {
            employeeInfo.setFullname(fullname);
            employeeInfo.setHomeAddress(address);
            employeeInfo.setEducation(education);
            employeeInfo.setWorkExperience(workexperience);
            employeeInfo.setSalary(salary);
        } else {
            employeeInfo = new EmployeeInfo(employeeInfoId, fullname, address, education, workexperience, jobtitle, salary);
        }

        model.addAttribute("error_msg", "Данные не сохранены");
        return "errorPage";
    }

    @PostMapping("/removeEmployeeInfo")
    public String removePersonPage(@RequestParam(name = "employeeInfoId") Integer employeeInfoId) {
        employeeInfoDAO.deleteById(employeeInfoId);
        return "redirect:/employeeInfos";
    }
}