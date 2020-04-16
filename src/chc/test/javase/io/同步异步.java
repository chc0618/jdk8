package chc.test.javase.io;


/**
 * 5、阻塞非阻塞与同步异步的区别？（故事篇）
 *
 * 理解同步阻塞、同步非阻塞、异步阻塞、异步阻塞、异步非阻塞
 *
 * 同步/异步关注的是消息通知的机制，而阻塞/非阻塞关注的是程序（线程）等待消息通知时的状态。
 *
 * 以小明下载文件打个比方，从这两个关注点来再次说明这两组概念，希望能够更好的促进大家的理解。
 *
 * 同步阻塞：小明一直盯着下载进度条，到 100% 的时候就完成。 - 同步体现在：等待下载完成通知。 - 阻塞体现在：等待下载完成通知过程中，不能做其他任务处理。
 *
 * 同步非阻塞：小明提交下载任务后就去干别的，每过一段时间就去瞄一眼进度条，看到 100% 就完成。 - 同步体现在：等待下载完成通知。 - 非阻塞体现在：等待下载完成通知过程中，去干别的任务了，只是时不时会瞄一眼进度条。【小明必须要在两个任务间切换，关注下载进度】
 *
 * 异步阻塞：小明换了个有下载完成通知功能的软件，下载完成就“叮”一声。不过小明不做别的事，仍然一直等待“叮”的声音。 - 异步体现在：下载完成“叮”一声通知。 - 阻塞体现在：等待下载完成“叮”一声通知过程中，不能做其他任务处理。
 *
 * 异步非阻塞：仍然是那个会“叮”一声的下载软件，小明提交下载任务后就去干别的，听到“叮”的一声就知道完成了。 - 异步体现在：下载完成“叮”一声通知。 - 非阻塞体现在：等待下载完成“叮”一声通知过程中，去干别的任务了，只需要接收“叮”声通知即可。【软件处理下载任务，小明处理其他任务，不需关注进度，只需接收软件“叮”声通知，即可】
 *
 * 也就是说，同步/异步是“下载完成消息”通知的方式（机制），而阻塞/非阻塞则是在等待“下载完成消息”通知过程中的状态（能不能干其他任务），在不同的场景下，同步/异步、阻塞/非阻塞的四种组合都有应用。
 *
 * 所以，综上所述，同步和异步仅仅是关注的消息如何通知的机制，而阻塞与非阻塞关注的是等待消息通知时的状态。也就是说，同步的情况下，是由处理消息者自己去等待消息是否被触发，而异步的情况下是由触发机制来通知处理消息者，所以在异步机制中，处理消息者和触发机制之间就需要一个连接的桥梁。在小明的例子中，这个桥梁就是软件“叮”的声音
 */
public class 同步异步 {
    public static void main(String[] args) {
        // 同步阻塞
        Integer synchronization = synchronization(1, 2);
        System.out.println(synchronization + "----同步阻塞");

        // 异步阻塞
        synchronization(new Monitor() {
            @Override
            public int returnMethod(Object obj) {
                System.out.println(obj + "---- 异步阻塞");
                return (int)obj;
            }
        }, 1, 2);

        // 异步阻塞2
        Monitor monitor = new Monitor() {
            @Override
            public int returnMethod(Object obj) {
                return (int)obj;
            }
        };
        synchronization(monitor, 1,2);

    }
    public static int synchronization(int a, int b){
        int c = a + b;
        return c;
    }
    public static int synchronization(Monitor monitor, int a, int b){
        int c = a + b;
        return monitor.returnMethod(c);
    }

    public static interface Monitor{
        int returnMethod(Object obj);
    }
}
