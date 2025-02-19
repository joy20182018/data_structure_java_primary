

public class BSTSET<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    public BSTSET(){
        bst = new BST<>();
    }

    @Override
    public int getSize(){
        return bst.size();
    }

    @Override
    public boolean isEmpty(){
        return bst.isEmpty();
    }

    @Override
    public void add(E e){
        bst.add(e);
    }

    @Override
    public void remove(e E) {
        return;
    }

    @Override
    public boolean contains(E e){
        return bst.contains(e);
    }
}
