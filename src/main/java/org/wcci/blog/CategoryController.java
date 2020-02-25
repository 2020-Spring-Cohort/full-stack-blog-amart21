package org.wcci.blog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.print.DocFlavor;

@Controller
public class CategoryController {
    private CategoryStorage categoryStorage;
    public CategoryController(CategoryStorage categoryStorage){
        this.categoryStorage = categoryStorage;

//        @RequestMapping("/categories")
//        public String displayCategory(Model model){
//            model.addAttribute("categories", categoryStorage.findAllCategories());
//            return "categories-view";
//        }
    }
}
