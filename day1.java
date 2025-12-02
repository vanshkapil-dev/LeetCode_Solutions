class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] arr=new int[nums1.length+nums2.length];
        int i1=0;
        int i2=0;
        int i=0;
        double median=0;
        while(i1<nums1.length && i2<nums2.length){
            if(nums1[i1]<nums2[i2]){
                arr[i]=nums1[i1];
                i1++;
                i++;

            }
            else{
                arr[i]=nums2[i2];
                i2++;
                i++;
            }
        }
        if(i1<nums1.length){
            for(int i3=i1;i3<nums1.length;i3++){
                arr[i]=nums1[i3];
                i++;
            }
        }
        if(i2<nums2.length){
            for(int i3=i2;i3<nums2.length;i3++){
                arr[i]=nums2[i3];
                i++;
            }

        }
        //even haiii
        if(arr.length%2==0){
            int left=0;
            int right=arr.length-1;
            int mid=left+(right-left)/2;
            median=((double)(arr[mid]+arr[mid+1]))/2;

        }
        else{
            int left=0;
            int right=arr.length-1;
            int mid=left+(right-left)/2;
            median=(double)arr[mid];

        }

        
        return median;
    


        
    }
}