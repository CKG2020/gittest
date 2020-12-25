package array;

public class RepeatNumber {
   public boolean choose(int [] nums,int length,int []after){
       for (int i = 0; i < length; i++) {
           while (i!=nums[i]){
               if (nums[i]==nums[nums[i]]){
                   after[i]=nums[i];
                   System.out.println(after[i]);
                   return true;
               }
               swap(nums,i,nums[i]);
           }
       }
       return  false;
   }
   public  void  swap(int []nums,int i,int j){
       int t=nums[i];
       nums[i]=nums[j];
       nums[j]=t;
   }
    public static void main(String[] args) {

        RepeatNumber repeatNumber = new RepeatNumber();
        int [] nums={2,4,5,6,4,1,3};
        int  [] after = new int[1];
        repeatNumber.choose(nums,nums.length,after);
    }

}
