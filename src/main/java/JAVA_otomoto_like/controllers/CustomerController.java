package JAVA_otomoto_like.controllers;

import JAVA_otomoto_like.model.Customer;
import JAVA_otomoto_like.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String showList(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @GetMapping("/{id}/edit")
    public String showEditCustomer(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("customer", customerService.getCustomer(id));
        return "customer/edit";
    }

    @GetMapping("/register")
    public String showAddNewCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/register";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customer/list";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.delete(customer.getId());
        return "redirect:/customer/list";
    }
}
