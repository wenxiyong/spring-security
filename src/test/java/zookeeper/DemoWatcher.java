package zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * Created by kobe on 2016/11/7.
 */
public class DemoWatcher implements Watcher {
    public void process(WatchedEvent watchedEvent) {
        System.out.println("hello process");
        System.out.println("path:" + watchedEvent.getPath());
         System.out.println("type:" + watchedEvent.getType());
         System.out.println("stat:" + watchedEvent.getState());
    }
}
