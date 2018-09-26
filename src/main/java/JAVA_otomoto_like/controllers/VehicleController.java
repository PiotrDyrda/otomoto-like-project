package JAVA_otomoto_like.controllers;

import JAVA_otomoto_like.model.Vehicle;
import JAVA_otomoto_like.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/list")
    public String showList(Model model) {
        List<Vehicle> vehicles = vehicleService.findAll();
        model.addAttribute("vehicles", vehicles);
        return "vehicle/list";
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
        vehicleService.save(vehicle);
        return "redirect:/vehicle/list";
    }

    @PostMapping("/delete")
    public String deleteVehicle(@ModelAttribute("vehicle") Vehicle vehicle) {
        vehicleService.delete(vehicle);
        return "redirect:/vehicle/list";
    }
}
