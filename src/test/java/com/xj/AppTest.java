package com.xj;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {

        // 1 创建配置信息对象
        Configuration configuration = new Configuration();

        configuration.set("fs.defaultFS","hdfs://10.122.152.50:9000","liangxiaojun");


        // 2 获取文件系统
        FileSystem fs = null;
        try {
            fs = FileSystem.get(configuration);
            fs.mkdirs(new Path("/user/liangxiaojun"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 3 打印文件系统
        //System.out.println(fs.toString());

    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void hadoopMkdir()
    {

        // 1 创建配置信息对象
        Configuration configuration = new Configuration();

        //configuration.set("fs.defaultFS","hdfs://10.122.152.50:9000","liangxiaojun");
        // 2 获取文件系统
        FileSystem fs = null;
        try {
            fs = FileSystem.get(new URI("hdfs://10.122.152.50:9000"),configuration,"hadoop");
            fs.mkdirs(new Path("/user/liangxiaojun"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
