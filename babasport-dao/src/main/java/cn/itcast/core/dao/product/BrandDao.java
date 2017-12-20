package cn.itcast.core.dao.product;

import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.bean.product.BrandQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandDao {
    int deleteByPrimaryKey(Long brandId);

    int insert(Brand brand);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Long brandId);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

   /* int countSerchCountBrand(String brandName);

    List<Brand> serchBrandByName(@Param("brandName") String brandName, @Param("index") int index, @Param("pageSize") int pageSize);
*/

    //查询结果集
    public List<Brand> selectBrandListByQuery(BrandQuery brandQuery);
    //查询总条数
    public Integer selectCount(BrandQuery brandQuery);
}