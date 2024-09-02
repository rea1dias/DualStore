package com.example.DualStore.Controller;

import com.example.DualStore.Model.Category;
import com.example.DualStore.Service.CategoryService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ssl.SslProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.ObjectUtils;

import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/loadAddProduct")
    public String loadAddProduct() {
        return "admin/add_product";
    }

    @GetMapping("/category")
    public String category() {
        return "admin/category";
    }


    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category, @RequestParam("file") MultipartFile file, HttpSession session) {

        String imageName = file != null ? file.getOriginalFilename(): "default.jpg";

        category.setImageName(imageName);

        // Проверка, существует ли категория
        Boolean existCategory = categoryService.existCategory(category.getName());

        if (existCategory) {
            // Установка сообщения об ошибке в сессию
            session.setAttribute("errorMsg", "Category Name already exists");
        } else {
            // Сохранение категории
            Category saveCategory = categoryService.saveCategory(category);

            // Проверка успешности сохранения
            if (saveCategory == null) {
                // Установка сообщения об ошибке в сессию
                session.setAttribute("errorMsg", "Not Saved! Internal server error");
            } else {
                // Установка сообщения об успехе в сессию
                session.setAttribute("succMsg", "Saved successfully");
            }
        }

        // Перенаправление на страницу категорий
        return "redirect:/category";
    }



}
