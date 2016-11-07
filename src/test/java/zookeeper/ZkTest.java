package zookeeper;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by kobe on 2016/11/7.
 */
public class ZkTest {
    private ZkClient zk ;

    private String znode = "/myApp";

    @Before
    public void init(){
        zk = new ZkClient("205.209.188.103:2181,205.209.188.103:2182,205.209.188.103:2183");
    }

    @After
    public void dispose(){
        zk.close();
    }

    @Test
    public void testListener() throws InterruptedException {
        zk.subscribeDataChanges(znode, new IZkDataListener() {
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("data changed");
                System.out.println("node => " + dataPath);
                System.out.println("data =>" + data);
            }

            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("data deleted");
                System.out.println("node => " + dataPath);
            }
        });
        System.out.println("ready");

        while (true){
            TimeUnit.SECONDS.sleep(5);
        }
    }

    @Test
    public void testZkChange() throws InterruptedException {
        if(!zk.exists(znode)){
            zk.createPersistent(znode);
        }

        zk.writeData(znode, "1");
        zk.writeData(znode, "2");

        Thread.sleep(1000L);
        zk.delete(znode);
        zk.delete(znode);
    }
}
