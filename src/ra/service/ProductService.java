package ra.service;

import ra.config.IOFile;
import ra.model.Product;

import java.util.List;

public class ProductService implements IGenericSevice<Product,Integer>{
    private IOFile<Product> productData;
    private List<Product> listProducts;
    public ProductService() {
        this.productData = new IOFile<>();
        this.listProducts= productData.readFromFile(IOFile.PRODUCT_PATH);
    }
    @Override
    public List<Product> findAll() {
        return listProducts;
    }

    @Override
    public void save(Product product) {
        if(findById(product.getId())==null){
            // thêm mới
            listProducts.add(product);
        }else {
            // cập nhât
            listProducts.set(listProducts.indexOf(findById(product.getId())),product);
        }
        // lưu sự thayddooir vào file
        productData.writeToFile(listProducts,IOFile.PRODUCT_PATH);
    }

    @Override
    public void delete(Integer integer) {
        listProducts.remove(findById(integer));
        productData.writeToFile(listProducts,IOFile.PRODUCT_PATH);
    }

    @Override
    public Product findById(Integer integer) {
        for (Product pro :listProducts) {
            if(pro.getId() == integer){
                return pro;
            }
        }
        return null;
    }
    // id tự tăng
    public int getNewId(){
        int maxId =0;
        for (Product pro :listProducts) {
            if(pro.getId() > maxId){
                maxId = pro.getId();
            }
        }
        return maxId+1;
    }
}
