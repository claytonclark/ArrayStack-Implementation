import java.util.Arrays;
import java.util.EmptyStackException;

public class ResizeableArrayStack<T> implements StackInterface<T> {
    private T[] stack; // Array of stack entries
    private int topIndex; // Index of top entry
    private static final int DEFAULT_CAP = 50;

    public ResizeableArrayStack(){
        this(DEFAULT_CAP);
    }// end constructor

    public ResizeableArrayStack(int cap){
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[cap];
        stack = tempStack;
        topIndex = -1;
    }// end constructor

    @Override
    public void push(T newEntry) {
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    } // end push

    private void ensureCapacity() {
        if(topIndex >= stack.length -1) { // if array is full, double its size
            int newLength = 2*stack.length;
            stack = Arrays.copyOf(stack, newLength);
        }// end if
    }// end ensureCapacity

    @Override
    public T pop() {
        if(isEmpty())
            throw new EmptyStackException();
        else{
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        }
    }// end pop

    @Override
    public T peek() {
        if(isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    }// end peek

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }// end isEmpty

    @Override
    public void clear() {
        while(topIndex > -1){
            stack[topIndex] = null;
            topIndex--;
        }
    }//end clear
}// end ResizeableArrayStack
