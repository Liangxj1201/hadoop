package com.xj;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;

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

        configuration.set("fs.defaultFS","hdfs://localhost:9000");

        // 2 获取文件系统
        FileSystem fs = null;
        try {
            fs = FileSystem.get(configuration);
            fs.mkdirs(new Path("/xjliang2"));
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
}
