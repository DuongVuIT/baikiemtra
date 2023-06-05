package baikiemtra.baikiemtra.service;


import baikiemtra.baikiemtra.entity.Product;
import baikiemtra.baikiemtra.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class ProductService {
 @Autowired
    private ProductRepository productRepository;
 public List<Product> listAll(){
     return productRepository.findAll();
 }
 public void save(Product product){
     productRepository.save(product);

 }
 public Product get(Integer id){
     return productRepository.findById(id).get();
 }
 public void delete(Integer id){
     productRepository.deleteById(id);
 }
}
