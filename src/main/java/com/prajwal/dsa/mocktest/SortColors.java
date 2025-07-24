package com.prajwal.dsa.mocktest;

public class SortColors {
    public void sortColors(int[] nums) {
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                int temp=nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                low++;
                mid++;
            }else if(nums[mid]==1){ mid++;}
            else if(nums[mid]==2){
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        SortColors s = new SortColors();
        s.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}