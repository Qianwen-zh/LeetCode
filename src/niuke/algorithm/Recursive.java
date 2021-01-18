package niuke.algorithm;

//递归
public class Recursive {
    //    我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
    // 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
    //    * * * *
    //    * * * *
    //    n=1  :  1
    //    n=2  :  2
    //    n=3  :  第一个竖着放 f(n-1)  第一个横着放 1
    //    n=3  :  第一个竖着放 f(n-1)  第一个横着放 f(n-2)
    public int RectCover(int target) {
        if(target < 1){
            return 0;
        }else if(target <= 2){
            return target;
        }else {
            return RectCover(target-1) + RectCover(target-2);
        }
    }
}
