package com.lvxiao.zookeeper.watcher;

import com.lvxiao.zookeeper.ZookeeperConnection;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.HashMap;
import java.util.List;

/**
 * @author lvxiao
 * @version V1.0
 * @date 2019/10/25 10:41 上午
 */
public class WatcherLearn {
    public static void main(String[] args) throws KeeperException, InterruptedException {
        ZooKeeper zooKeeper = ZookeeperConnection.getConnection();
        // 定义父子类节点路径
        String rootPath = "/nodeRoot2";
        String child1Path = rootPath + "/nodeChildren1";
        String child2Path = rootPath + "/nodeChildren2";

        zooKeeper.create(rootPath, "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zooKeeper.create(child1Path, "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zooKeeper.create(child2Path, "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        List<String> children = zooKeeper.getChildren(rootPath, true);

        Stat stat =  zooKeeper.exists(child1Path,true); //注册监听

        zooKeeper.delete(child1Path,0);

        children.forEach(System.out::println);

//        zooKeeper.create("/create-test", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT); //创建节点
//        Stat stat =  zooKeeper.exists("/create-test",true); //注册监听
//        zooKeeper.delete("/create-test",stat.getVersion());
        zooKeeper.close();
    }
}
