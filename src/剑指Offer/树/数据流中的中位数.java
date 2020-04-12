package 剑指Offer.树;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 梦仙尘
 * @create 2020-03-31 16:48
 */
public class 数据流中的中位数 {
    /**
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
     * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
     * 那么中位数就是所有数值排序之后中间两个数的平均值。
     * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
     */
    //小顶堆
    //优先队列默认为升序
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    //大顶堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            //降序，从大到小
            return o2 - o1;
        }
    });

    //记录偶数个还是奇数个
    int count = 0;
    //每次插入小顶堆的是当前大顶堆中最大的数
    //每次插入大顶堆的是当前小顶堆中最小的数
    //这样保证小顶堆中的数永远大于等于大顶堆中的数
    //排序后顺序是从大到小，那么小顶堆代表数据流后半部分，大顶堆代表数据流前半部分
    //所以要保证小顶堆中的数永远大于等于大顶堆中的数
    //中位数就可以方便地从两者的根结点中获取了
    public void Insert(Integer num) {
        //个数为偶数的话，则先插入到大顶堆，然后将大顶堆中最大的数插入小顶堆中
        if(count % 2 == 0){
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        }else{
            //个数为奇数的话，则先插入到小顶堆，然后将小顶堆中最小的数插入大顶堆中
            minHeap.offer(num);//向优先队列中插入元素
            int min = minHeap.poll();//检索并删除此队列的头，如果此队列为空，则返回 null 。
            maxHeap.offer(min);
        }
        count++;
    }
    public Double GetMedian() {
        //当前为偶数个，则取小顶堆和大顶堆的堆顶元素求平均
        if(count % 2 == 0){
            return new Double(minHeap.peek() + maxHeap.peek())/2;
        }else{
            //当前为奇数个，则直接从小顶堆中取元素即可
            return new Double(minHeap.peek());
        }
    }
}
