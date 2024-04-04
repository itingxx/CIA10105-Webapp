package dao;

import java.util.List;



public interface ProductPicture_interface {

    public void insert(ProductPictureVO productpicturevo);
    public void update(ProductPictureVO productpicturevo);
    public ProductPictureVO findByPrimaryKey(Integer productpicturevo);
    public List<ProductPictureVO> getAll();
    
   
   
}
