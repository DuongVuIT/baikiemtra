package baikiemtra.baikiemtra.controller;

import baikiemtra.baikiemtra.entity.Product;
import baikiemtra.baikiemtra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public String viewAllProduct(Model model){
        List<Product> listProduct = productService.listAll();
        model.addAttribute("products",listProduct);
        return "product/index";
    }
    @GetMapping("/new")
    public String showNewProduct(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "product/new_product";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute ("product") Product product){
        productService.save(product);
        return "redirect:/products";
    }
    @GetMapping("/edit/{id}")
    public String showEditProductPage(@PathVariable("id") Integer id,Model model){
        Product product = productService.get(id);
        if(product == null){
            return "not found";
        }else {

            model.addAttribute("product",product);
            return "product/edit";
        }

    }
    @GetMapping("/delete/{id}")
        public String deleteProduct(@PathVariable("id") Integer id){
            Product product = productService.get(id);
            if(product == null){
                return "notfound";
            }else{
                 productService.delete(id);
                return "redirect:/products";
            }
    }
}
