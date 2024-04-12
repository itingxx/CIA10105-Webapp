package ProductPicture;

import java.util.List;



public interface ProductPicture_interface {

    public void insert(ProductPictureVO productpicturevo);
    public void update(ProductPictureVO productpicturevo);
    public ProductPictureVO findByPrimaryKey(Integer pPicNo);
    public List<ProductPictureVO> getAll();
    public void delete(Integer pPicNo);
    
   
   
}
