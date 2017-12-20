package cn.itcat.common.fdfs;

/**
 * Created by liyan on 2017/8/17.
 */


import org.apache.commons.io.FilenameUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;
/**
 *
上传图片

 */
public class FastDFSUtils {

    public static String uploadPic(byte[] pic,String name,long size){

        //1.读取配置文件
        ClassPathResource resource = new ClassPathResource("fdfs_client.conf");
   String path=null;
        try {
             ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());

            //获取老大服务
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer=null;
            StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
            String ext = FilenameUtils.getExtension(name);  //获取文件的后缀名

            NameValuePair[] meta_list = new NameValuePair[3];  //文件描述
            meta_list[0] = new NameValuePair("fileName",name);
            meta_list[1]=new NameValuePair("fileExt",ext);
            meta_list[2]=new NameValuePair("fileSize",String.valueOf(size));
            path = storageClient1.upload_file1(pic, ext, meta_list);//获取文件路径
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  path;
    }
}
