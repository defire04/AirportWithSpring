package com.example.controllers;

import com.example.dao.FamilyDao;
import com.example.models.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/families")
public class FamilyController {
    private final FamilyDao familyDao;

    @Autowired
    public FamilyController(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("families", familyDao.index());
        return "families/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("family", familyDao.show(id));
        return "families/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("family") Family family) {
        return "families/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("family") @Valid Family family, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "families/new";
        }
        familyDao.save(family);
        return "redirect:/families";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("family", familyDao.show(id));
        return "families/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("family") @Valid Family family, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "families/edit";
        }
        familyDao.update(id, family);
        return "redirect:/families";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        familyDao.delete(id);
        return "redirect:/families";
    }
}