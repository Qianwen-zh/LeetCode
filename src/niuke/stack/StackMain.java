package niuke.stack;

public class StackMain {
    public boolean IsPopOrder(){
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,1,2};
        StackHandle stackHandle = new StackHandle();
        return stackHandle.IsPopOrder(pushA,popA);
    }
}
