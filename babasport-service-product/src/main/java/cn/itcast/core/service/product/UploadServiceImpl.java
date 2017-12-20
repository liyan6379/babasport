package cn.itcast.core.service.product;

import cn.itcat.common.fdfs.FastDFSUtils;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/17.
 */
@Service("uploadService")
public class UploadServiceImpl implements  UploadService {


    @Override
    public String uploadPic(byte[] pic, String name, long size) {
        return FastDFSUtils.uploadPic(pic, name, size);
    }
}
