package ProductPicture;

import ProductPicture.model.ProductPictureVO;

import java.util.List;



public interface ProductPicture_interface {

    public ProductPictureVO insert(ProductPictureVO productpicturevo);
    public ProductPictureVO update(ProductPictureVO productpicturevo);
    public ProductPictureVO findByPrimaryKey(Integer pPicNo);
    public List<ProductPictureVO> getAll();
    public void delete(Integer pPicNo);

    
   
   
}
