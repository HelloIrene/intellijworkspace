package ThreeBoolean;

public class Test {
    public static void main(String[] args) {
        int[] nums=new int[1000000];
        int s1=0;
        long s=System.nanoTime();
        for (int i=0;i<nums.length;i++) {
            s1+=nums[i];
        }
        System.out.println(System.nanoTime()-s);
        long s2 =System.nanoTime();
        for (int i=0;i<nums.length;i++) {
            s1=s1+nums[i];
        }
        System.out.println(System.nanoTime()-s2);
    }
}
