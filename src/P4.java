public class P4 {
    public static void main(String[] args) {
        new P4().findMedianSortedArrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{7, 8});
        new P4().findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4});
        new P4().findMedianSortedArrays(new int[]{1}, new int[]{});
        new P4().findMedianSortedArrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{});
        new P4().findMedianSortedArrays(new int[]{-1, 1, 3, 5}, new int[]{0, 2, 4, 6});
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        int medPos;

        if (a == 0) {
            medPos = b / 2;
            if (b % 2 == 0) return ((nums2[medPos] + nums2[medPos - 1]) / 2.0);
            return nums2[medPos];
        }

        if (b == 0) {
            medPos = a / 2;
            if (a % 2 == 0) return ((nums1[medPos] + nums1[medPos - 1]) / 2.0);
            return nums1[medPos];
        }

        // 4 + 4 / 2 = 4
        // 1 + 2 / 2 = 1
        int i = 0;
        int j = 0;
        medPos = (a + b) / 2;
        while ((i + j + 2) != medPos) {
            if (i + 1 == a) j++;
            else if (j + 1 == b) i++;
            else if (nums1[i] > nums2[j]) j++;
            else i++;
        }

        System.out.println(i + " - " + j);

        return 0;
    }
}
