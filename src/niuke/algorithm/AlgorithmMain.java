package niuke.algorithm;

public class AlgorithmMain {
    private Sort sort = new Sort();
    public void solution(){
        Dynamic();
    }
    public void GetLeastNumbers_Solution(){
        int [] a = {4,5,1,6,2,7,3,8};
        System.out.println(sort.GetLeastNumbers_Solution(a,4));
    }

    public void Dynamic(){
        Dynamic dynamic = new Dynamic();
        int [] a = {6,-3,-2,7,-15,1,2,2};
        System.out.println(dynamic.FindGreatestSumOfSubArray(a));
        int [] b = {-2,-8,-1,-5,-9};
        System.out.println(dynamic.FindGreatestSumOfSubArray(b));
        int [] c = {1,2};
        System.out.println(dynamic.FindGreatestSumOfSubArray(c));
    }
}
