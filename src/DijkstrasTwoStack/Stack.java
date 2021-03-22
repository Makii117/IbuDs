package DijkstrasTwoStack;

public class Stack<Item> {

    @SuppressWarnings("unchecked")
    private Item[] N = (Item[]) new Object[1];

    private int len=0;

    public boolean isEmpty(){
        return len==0;
    }

    public int size(){
        return len;
    }

    @SuppressWarnings("unchecked")

    //povecava velicinu stacka
    private void resize(int capacity){
        Item[] copy=(Item[]) new Object[capacity];
        for(int i= 0; i<len;i++){
            copy[i]=N[i];
        }
        N=copy;
    }
    //pusha value na vrh stacka
    public void push(Item item){
        if(len==N.length) {
            resize(2 * N.length);
        }
        N[len++]=item;
    }

    //popa value sa vrha stacka
    public Item pop(){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Stack is empty");

        }
        Item item= N[len-1];
        N[len-1]=null;
        len--;
        if(len>0 && len==N.length/4){
            resize(N.length/2);
        }
        return item;
    }

}
