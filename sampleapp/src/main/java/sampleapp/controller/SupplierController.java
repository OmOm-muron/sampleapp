package sampleapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sampleapp.entity.Supplier;
import sampleapp.service.SupplierService;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("")
    public String getAllSuppliers(Model model) {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        model.addAttribute("suppliers", suppliers);
        return "suppliers/supplier-list";
    }

    @GetMapping("/{id}")
    public String getSupplierById(@PathVariable int id, Model model) {
        Supplier supplier = supplierService.getSupplierById(id);
        model.addAttribute("supplier", supplier);
        return "suppliers/supplier-detail";
    }

    @GetMapping("/add")
    public String showAddSupplierForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "suppliers/supplier-add";
    }

    @PostMapping("/add")
    public String addSupplier(@ModelAttribute Supplier supplier) {
        supplierService.addSupplier(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/{id}/update")
    public String showUpdateSupplierForm(@PathVariable int id, Model model) {
        Supplier supplier = supplierService.getSupplierById(id);
        model.addAttribute("supplier", supplier);
        return "suppliers/supplier-update";
    }

    @PostMapping("/{id}/update")
    public String updateSupplier(@PathVariable int id, @ModelAttribute Supplier supplier) {
        supplier.setId(id);
        supplierService.updateSupplier(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/{id}/delete")
    public String showDeleteSupplierForm(@PathVariable int id) {
        return "suppliers/supplier-delete";
    }
    
    @PostMapping("/{id}/delete")
    public String deleteSupplier(@PathVariable int id) {
        supplierService.deleteSupplier(id);
        return "redirect:/suppliers";
    }
}