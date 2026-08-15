class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int half = (n1+n2+1)/2;
        int low = 0, high = n1;

        while(low <= high){
            int i = low + (high-low)/2;
            int j = half - i;

            int maxLeftA = i >= 1 ? nums1[i-1] : Integer.MIN_VALUE;
            int minRightA = i == n1 ? Integer.MAX_VALUE: nums1[i];

            int maxLeftB = j >= 1 ? nums2[j-1]: Integer.MIN_VALUE;
            int minRightB = j == n2 ? Integer.MAX_VALUE: nums2[j];

            if(maxLeftA <= minRightB && maxLeftB <= minRightA){
                if((n1+n2)%2 != 0){
                    return Math.max(maxLeftA, maxLeftB);
                }else return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB))/2.0;
            }else if(maxLeftA > minRightB){
                high = i-1;
            }else low = i+1;
        }


        return -1;
    }
}