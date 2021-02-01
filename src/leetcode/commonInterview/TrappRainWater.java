package leetcode.commonInterview;

// 42 ����ˮ
// labuladong 5.3
public class TrappRainWater {
    //����¼��
    public int trap1(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int[] l_max = new int[n]; // �洢������
        int[] r_max = new int[n]; // �洢�Ҳ����
        l_max[0] = height[0];
        r_max[n-1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(l_max[i - 1], height[i]);
        }
        for (int i = n-2; i >= 0; i--) {
            r_max[i] = Math.max(r_max[i + 1], height[i]);
        }
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += Math.min(l_max[i], r_max[i]) - height[i];
        }
        System.out.println(sum);
        return sum;
    }
    // ˫ָ�뷨
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int l_max = 0; // �洢������
        int r_max = 0; // �洢�Ҳ����
        int left = 0;
        int right = n-1;
        int sum = 0;
        while (left <= right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);

            if(l_max < r_max) {
                sum += l_max - height[left];
                left++;
            } else {
                sum += r_max - height[right];
                right--;
            }
        }
        System.out.println(sum);
        return sum;
    }
}
