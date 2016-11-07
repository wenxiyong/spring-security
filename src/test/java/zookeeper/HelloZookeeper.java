package zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by kobe on 2016/11/7.
 */
public class HelloZookeeper {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = new ZooKeeper("205.209.188.103:2181", 300000, new DemoWatcher());
        String znode = "/app1";
        Stat stat = zk.exists(znode, false);
        if(stat == null){
            String createResult = zk.create(znode, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(createResult);
        }
        byte[] b = zk.getData(znode, false, stat);
        System.out.println(new String(b));
        zk.close();
    }

    @Test
    public void testzkClient(){
        ZkClient zkClient = new ZkClient("205.209.188.103:2181,205.209.188.103:2182,205.209.188.103:2183");
        String znode = "/app2";
        if (!zkClient.exists(znode)){
            zkClient.createPersistent(znode, "hello zkClient");
        }
        System.out.println(zkClient.readData(znode));
    }
}
