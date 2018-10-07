package JAVA_otomoto_like.controllers;

import JAVA_otomoto_like.model.Customer;
import JAVA_otomoto_like.model.Vehicle;
import JAVA_otomoto_like.services.CustomerService;
import JAVA_otomoto_like.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;
    private final CustomerService customerService;

    @Autowired
    public VehicleController(VehicleService vehicleService, CustomerService customerService) {
        this.vehicleService = vehicleService;
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String showList(Model model) {
        List<Vehicle> vehicles = vehicleService.findAll();
        model.addAttribute("vehicles", vehicles);
        return "vehicle/list";
    }

    @GetMapping("/listmanager")
    public String showListManager(Model model) {
        List<Vehicle> vehicles = vehicleService.findAll();
        model.addAttribute("vehicles", vehicles);
        return "vehicle/listmanager";
    }

    @GetMapping("/{id}/edit")
    public String showEditVehicle(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("vehicle", vehicleService.getVehicle(id));
        return "vehicle/edit";
    }

    @GetMapping("/add")
    public String showAddVehicle(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicle/add";
    }

    @PostMapping("/save")
    public String addVehicle(@ModelAttribute("vehicle") Vehicle vehicle) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Customer username = customerService.getByUsername(name);
        vehicle.setOwner(username);
        vehicleService.save(vehicle);
        return "redirect:/vehicle/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable("id") Integer id) {
        vehicleService.delete(vehicleService.getVehicle(id));
        return "redirect:/vehicle/listmanager";
    }
}
