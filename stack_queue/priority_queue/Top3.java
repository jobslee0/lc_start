package priority_queue;

import java.util.*;

public class Top3 {
    public static void main(String[] args) {
        Map<String, Integer> countMap = new HashMap<>();
        countMap.put("A", 1);
        countMap.put("B", 2);
        countMap.put("C", 3);
        countMap.put("D", 4);
        countMap.put("E", 5);
        countMap.put("F", 6);
        System.out.println(countMap);
        // 创建一个优先队列，使用自定义比较器来实现最大堆的效果
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue().compareTo(a.getValue()) // 降序排序
        );
        // 将所有条目添加到优先队列中
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            pq.offer(entry);
        }
        // 提取前3个条目
        List<Map.Entry<String, Integer>> top3Words = new ArrayList<>();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            top3Words.add(pq.poll());
        }
        System.out.println(top3Words);
    }
}
