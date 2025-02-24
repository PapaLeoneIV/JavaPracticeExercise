package it.tdgc.turnstile.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "/add",
    consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @GetMapping("/idu")
    public void getEmployee(@RequestParam Long id) {
        employeeService.getEmployee(id);
    }

    @GetMapping("/greeting")
    public String hello(Model model) {
        model.addAttribute("message", "Welcome to our website!");
        return "index"; // Thymeleaf template name (greeting.html)    }
    }
}
