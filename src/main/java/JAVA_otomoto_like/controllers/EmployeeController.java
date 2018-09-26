package JAVA_otomoto_like.controllers;

import JAVA_otomoto_like.model.Employee;
import JAVA_otomoto_like.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employers")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String showList(Model model) {
        List<Employee> employers = employeeService.findAll();
        model.addAttribute("employers", employers);
        return "employers/list";
    }

    @GetMapping("/{id}/edit")
    public String showEditEmployee(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("employee", employeeService.getEmployee(id));
        return "employers/edit";
    }

    @GetMapping("/add")
    public String showAddEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employers/edit";
    }

    @PostMapping("/save")
    public String addVehicle(@ModelAttribute("vehicle") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employers/list";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@ModelAttribute("vehicle") Employee employee) {
        employeeService.delete(employee);
        return "redirect:/employers/list";
    }

}
