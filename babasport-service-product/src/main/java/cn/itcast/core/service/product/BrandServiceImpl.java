package cn.itcast.core.service.product;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.bean.product.BrandQuery;
import cn.itcast.core.dao.product.BrandDao;
import com.itcast.core.pub.MessageCode;
import com.itcast.core.pub.Page;
import com.itcast.core.pub.ServiceException;
import com.itcast.core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by liyan on 2017/8/2.
 */

@Service("brandService")
@Transactional
public class BrandServiceImpl implements  BrandService{

    @Autowired
    private BrandDao brandDao;

    //查询分页对象
    public Pagination selectPaginationByQuery(String brandName,Byte isDisplay,Integer pageNo){
        BrandQuery brandQuery = new BrandQuery();
        //当前页
        brandQuery.setPageNo(Pagination.cpn(pageNo));


        StringBuilder params = new StringBuilder();

        //条件
        if(null != brandName){
            brandQuery.setBrandName(brandName);
            params.append("brandName=").append(brandName);
        }
        if(null != isDisplay){
            brandQuery.setIsDisplay(isDisplay);
            params.append("&isDisplay=").append(isDisplay);
        }else{
            brandQuery.setIsDisplay((byte)1);
            params.append("&isDisplay=").append(1);
        }

        Pagination pagination = new Pagination(
                brandQuery.getPageNo(),
                brandQuery.getPageSize(),
                brandDao.selectCount(brandQuery)
        );
        //设置结果集
        pagination.setList(brandDao.selectBrandListByQuery(brandQuery));
        //分页展示
        String url = "/babasportconsole/brand/list.do";

        pagination.pageView(url, params.toString());

        return pagination;
    }

    @Override
    public void saveBrand( Brand brand) {
        brandDao.insert(brand);
    }

    @Override
    public Brand getBrandById(Long brandId) {
        Brand brand = brandDao.selectByPrimaryKey(brandId);
        return brand;
    }

}
