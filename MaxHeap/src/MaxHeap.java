public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    // 使用heapify将一个数组初始化为一个最大堆
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i --)
            siftDown(i);
    }

    // 返回堆中的元素个数
    public int size(){
        return data.getSize();
    }

    // 返回一个布尔值，表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父节点的索引
    private int parent(int index){
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn`t have parent");
        return (index - 1 ) / 2;
    }

    // 返回一个完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }


    // 向堆中添加一个新的元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }
    // 堆的上浮
    private void siftUp(int k){
        // 先按照数组的方式加入元素
        // 发现加入的元素比其父亲节点要大，则与父节点进行交换顺序
        // 一直这样比较下去
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }


    // 看一下此时最大堆中的最大值
    public E findMax(){
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty");

        return data.get(0);
    }

    // 取出堆中最大值
    public E extractMax(){
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    private void siftDown(int k){

        while (leftChild(k) < data.getSize()){

            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
                j = rightChild(k);
            // data[j]是leftChild和rightChild中的最大值

            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;

            data.swap(k, j);
            k = j;
        }
    }

    // 取出堆中最大值，并且替换成元素e
    public E replace(E e){

        E ret = findMax();

        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
