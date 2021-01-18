package niuke.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Sort {
    /**
     * 堆排序
     * 输入n个整数，找出其中最小的K个数。
     * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     * [4,5,1,6,2,7,3,8]      10  0
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
            ArrayList list = new ArrayList();
            if(input.length==0 || k ==0){
                return list;
            }
            PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for(int i=0;i<input.length;i++){
                if(maxHeap.size()!=k){
                    maxHeap.offer(input[i]);
                }else if(maxHeap.peek()>input[i]){
                    maxHeap.poll();
                    maxHeap.offer(input[i]);
                }
            }
            for(Integer i : maxHeap){
                list.add(i);
            }
            return list;
        }

}
