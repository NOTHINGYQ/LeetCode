class Solution {
    //滑动窗口题，但用到了双优先级队列
    public double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dh = new DualHeap(k);
        for(int i = 0; i < k; i ++){
            dh.insert(nums[i]);
        }
        double[] ans = new double[nums.length - k + 1];
        ans[0] = dh.getMedian();
        for(int i = k; i < nums.length; i ++){
            dh.insert(nums[i]);
            dh.erase(nums[i - k]);
            ans[i - k + 1] =  dh.getMedian();
        }
        return ans;
    }

}
class DualHeap{
    //large heap
    private PriorityQueue<Integer> small;
    //small heap
    private PriorityQueue<Integer> large;
    //哈希表，记录 延迟删除  的元素， key为元素，value为需要删除的次数
    private Map<Integer, Integer> delayed;

    private int k;
    //small and large 包含当前的元素个数，需要扣除被 延迟删除 的元素
    private int smallSize, largeSize;

    public DualHeap(int k){
        this.small = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer num1, Integer num2){
                return num2.compareTo(num1);
            }
        });
        this.large = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer num1, Integer num2){
                return num1.compareTo(num2);
            }
        });
        this.delayed = new HashMap<Integer, Integer>();
        this.k = k;
        this.smallSize = 0;
        this.largeSize = 0;
    }

    public double getMedian(){
        return (k & 1) == 1 ? small.peek() : ((double) small.peek() + large.peek())/ 2;
    }

    public void insert(int num){
        if(small.isEmpty() || num <= small.peek()){
            small.offer(num);
            smallSize++;
        }else{
            large.offer(num);
            largeSize++;
        }
        makeBalance();
    }

    public void erase(int num){
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);
        if(num <= small.peek()){
            smallSize --;
            if(num == small.peek()){
                prune(small);
            }
        }else{
            largeSize --;
            if(num == large.peek()){
                prune(large);
            }
        }
        makeBalance();
    }

    //不断弹出heap的堆顶元素，并且更新哈希表
    private void prune(PriorityQueue<Integer> heap){
        while(!heap.isEmpty()){
            int num = heap.peek();
            if(delayed.containsKey(num)){
                delayed.put(num, delayed.get(num) - 1);
                if(delayed.get(num) == 0){
                    delayed.remove(num);
                }
                heap.poll();
            }else{
                break;
            }
        }
    }

    //调整small和large中的元素个数，使得二者的元素个数满足要求
    private void makeBalance(){
        if(smallSize > largeSize + 1){
            // small is 2 larger than large
            large.offer(small.poll());
            smallSize --;
            largeSize ++;
            prune(small);
        }else if(smallSize < largeSize){
            // large is one larger than small
            small.offer(large.poll());
            smallSize ++;
            largeSize --;
            prune(large);
        }
    }
}