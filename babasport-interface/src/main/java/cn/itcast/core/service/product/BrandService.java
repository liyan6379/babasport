package cn.itcast.core.service.product;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.bean.product.BrandQuery;
import com.itcast.core.pub.Page;

import java.util.List;

/**
 * Created by liyan on 2017/8/2.
 */
public interface BrandService {


   // Page<Brand> serchBrandByName(String brandName, String pageNoStr) throws  Exception;

    Pagination selectPaginationByQuery(String brandName, Byte isDisplay, Integer pageNo);

    void saveBrand(Brand brand);

    Brand getBrandById(Long brandId);
}
