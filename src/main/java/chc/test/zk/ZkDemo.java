package chc.test.zk;

import org.apache.zookeeper.*;

import java.io.IOException;

public class ZkDemo {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        // 创建一个与服务器的连接
        ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 60000, new Watcher() {
            // 监控所有被触发的事件
            // 当对目录节点监控状态打开时，一旦目录节点的状态发生变化，Watcher 对象的 process 方法就会被调用。
            public void process(WatchedEvent watchedEvent) {
                System.out.println("监控到节点发生变化 ： " + watchedEvent.getType() + " 节点路径 ： " + watchedEvent.getPath());
            }
        });

        //查看根结点 并监控子节点变化
        System.out.println("查看根节点 ls / ： " + zooKeeper.getChildren("/", true) );


        if(zooKeeper.exists("/newNode/codeNode", true) == null){

            zooKeeper.create("/newNode/codeNode", "codeNode".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("创建节点 /newNode/codeNode");
            //查看节点数据
            System.out.println(new String(zooKeeper.getData("/newNode/codeNode", true, null)));

            //
            System.out.println("查看根节点" + zooKeeper.getChildren("/" , true));
        }

        // 修改节点数据
        if (zooKeeper.exists("/newNode/codeNode", true) != null) {
            // 给 path 设置数据，可以指定这个数据的版本号，如果 version 为 -1 怎可以匹配任何版本
            zooKeeper.setData("/newNode/codeNode", "changed".getBytes(), -1);
            // 查看/newNode/codeNode节点数据
            // 获取这个 path 对应的目录节点存储的数据，数据的版本等信息可以通过 stat 来指定，同时还可以设置是否监控这个目录节点数据的状态
            System.out.println("get /newNode/codeNode => " + new String(zooKeeper.getData("/newNode/codeNode", false, null)));
        }
        // 删除节点
        if (zooKeeper.exists("/newNode/codeNode", true) != null) {
            // 删除 path 对应的目录节点，version 为 -1 可以匹配任何版本，也就删除了这个目录节点所有数据
            zooKeeper.delete("/newNode/codeNode", -1);
//            zooKeeper.delete("/newNode", -1);
            // 查看根节点
            System.out.println("ls / => " + zooKeeper.getChildren("/", true));
        }
        // 关闭连接
        zooKeeper.close();

    }
}
