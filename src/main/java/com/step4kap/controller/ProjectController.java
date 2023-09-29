package com.step4kap.controller;

import com.step4kap.dao.EmployeeInfoDAO;
import com.step4kap.dao.ProjectDAO;
import com.step4kap.db.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private final EmployeeInfoDAO employeeInfoDAO = new EmployeeInfoDAO();

    @Autowired
    private final ProjectDAO projectDAO = new ProjectDAO();

    @GetMapping("/projects")
    public String projectsListPage(Model model) {
        List<Project> projects = (List<Project>) projectDAO.getAll();
        model.addAttribute("projects", projects);
        return "projects";
    }

    @GetMapping("/project")
    public String placePage(@RequestParam(name = "projectId") Integer projectId, Model model) {
        Project project = projectDAO.getById(projectId);

        if (project == null) {
            model.addAttribute("error_msg", "В базе нет проекта с Id = " + projectId);
            return "errorPage";
        }

        model.addAttribute("project", project);
        model.addAttribute("employeeInfoService", employeeInfoDAO);
        model.addAttribute("projectService", projectDAO);
        return "project";
    }

    @GetMapping("/editProject")
    public String editProjectPage(@RequestParam(name = "C", required = false) Integer projectId, Model model) {
        if (projectId == null) {
            model.addAttribute("project", new Projet());
            return "editProject";
        }

        Project project = projectDAO.getById(projectId);

        if (project == null) {
            model.addAttribute("error_msg", "В базе нет проекта с Id = " + projectId);
            return "errorPage";
        }

        model.addAttribute("project", project);
        return "editProject";
    }

    @PostMapping("/saveProject")
    public String savePlacePage(@RequestParam(name = "projectId") Integer projectId,
                                @RequestParam(name = "projectName") String placeName,
                                @RequestParam(name = "projectStart") String projectStart,
                                @RequestParam(name = "projectEnd") String projectEnd,
                                Model model) {

        Project project = new Project(projectId, placeName, projectStart, projectEnd);
        projectDAO.save(project);

        return String.format("redirect:/project?projectId=%d", project.getId());
    }

    @PostMapping("/removeProject")
    public String removePlacePage(@RequestParam(name = "projectId") Integer projectId) {
        projectDAO.deleteById(projectId);
        return "redirect:/projects";
    }
}