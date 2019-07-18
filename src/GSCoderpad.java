import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/*
4. https://www.geeksforgeeks.org/trapping-rain-water/  - 2 times
5. Given array of students and their marks in different subjects. Find maximum average of the student.{“James”, “70”}, {“Fernando”, “90”}, {“Nick”, “60”}, {“James”, “10”} Ans should be name = Fernando, max avg =90
6. Write a function to check if the input number is a power of 10
8. Given an array of integers and a sum, output the number of pairs whose addition is equal to the given sum - 2 times
12. Count no. of ways to reach nth stair from the bottom. Can take 1, 2 or 3 steps at a time. https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
15. A car has to be given on rent. Different people come and ask for it for interval [s,e] and offer some price p. To whom shall the car be given in order to earn maximum.
16. I don’t remember the question exactly, but logic of the problem was BFS.
17. You have been given two arrays, find the dot product for it.
18. Find min length of subarray whose sum equal to k
 */

public class GSCoderpad {

    /*
    11. Given a matrix of positive integers/points. We have to start from lower left corner and reach the upper right corner.
    Our path should be such that we fetch maximum points. Only two movements are allowed- up and right,
    i.e. from a cell (R, C), you can either go to (R, C+1) or (R-1, C)
     */
    public int takeMax(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == matrix.length - 1) dp[i][j] = j == 0 ? matrix[i][j] : dp[i][j - 1] + matrix[i][j];
                else if (j == 0) dp[i][j] = dp[i + 1][j] + matrix[i][j];
                else dp[i][j] = Integer.max(dp[i][j - 1], dp[i + 1][j]) + matrix[i][j];
            }
        }
        return dp[0][matrix[0].length - 1];
    }

    @Test
    public void testTakeMax() {
        assertEquals(2, new GSCoderpad().takeMax(new int[][]{{0, 0, 0}, {0, 0, 1}, {0, 0, 1}}));
        assertEquals(4, new GSCoderpad().takeMax(new int[][]{{1, 1, 0}, {1, 0, 0}, {1, 0, 0}}));
        assertEquals(1, new GSCoderpad().takeMax(new int[][]{{0, 0, 0}, {0, 0, 0}, {1, 0, 0}}));
        assertEquals(11, new GSCoderpad().takeMax(new int[][]{{4, 1}, {5, 5}}));
    }

    //9. https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
    public int[] revreseArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    @Test
    public void testReverseArray() {
        assertArrayEquals(new int[]{3, 2, 1}, new GSCoderpad().revreseArray(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{3, 2}, new GSCoderpad().revreseArray(new int[]{2, 3}));
        assertArrayEquals(new int[]{3}, new GSCoderpad().revreseArray(new int[]{3}));
        assertArrayEquals(new int[]{}, new GSCoderpad().revreseArray(new int[]{}));
    }

    //7. A robot can only move in four directions , UP(U), DOWN(D),LEFT(L),RIGHT(R). Given a string consisting of instructions to move, output the co-ordinates of robot after the executing the instructions. Initial position of robot is at origin(0,0).
    public int[] moveRobot(String s) {
        int x = 0, y = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'U':
                    y++;
                    break;

                case 'D':
                    y--;
                    break;

                case 'L':
                    x--;
                    break;

                case 'R':
                    x++;
                    break;

                default:
            }
        }
        return new int[]{x, y};
    }

    @Test
    public void testRobot() {
        assertArrayEquals(new int[]{0, 0}, new GSCoderpad().moveRobot("abcd"));
        assertArrayEquals(new int[]{0, 0}, new GSCoderpad().moveRobot("ULDR"));
        assertArrayEquals(new int[]{0, 0}, new GSCoderpad().moveRobot("URDL"));
        assertArrayEquals(new int[]{0, 0}, new GSCoderpad().moveRobot(""));
        assertArrayEquals(new int[]{0, 0}, new GSCoderpad().moveRobot("RDLU"));
        assertArrayEquals(new int[]{2, 0}, new GSCoderpad().moveRobot("RR"));
    }

    //10. aaabbcddddde -> a3b2c1d5e1 https://www.geeksforgeeks.org/run-length-encoding
    public String rle(String s) {
        if (s == null || s.length() == 0) return "";
        int temp = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) temp++;
            else {
                sb.append(s.charAt(i - 1)).append(temp);
                temp = 1;
            }
        }
        sb.append(s.charAt(s.length() - 1)).append(temp);
        return sb.toString();
    }

    @Test
    public void rleTest() {
        assertEquals(new GSCoderpad().rle("abcd"), "a1b1c1d1");
        assertEquals(new GSCoderpad().rle("a"), "a1");
        assertEquals(new GSCoderpad().rle("aaa"), "a3");
        assertEquals(new GSCoderpad().rle("aabbcdde"), "a2b2c1d2e1");
    }

    //14. Find smallest element in sorted rotated array
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }

    @Test
    public void findMinTest() {
        assertEquals(new GSCoderpad().findMin(new int[]{3, 4, 5, 1, 2}), 1);
        assertEquals(new GSCoderpad().findMin(new int[]{1, 2, 3, 4}), 1);
        assertEquals(new GSCoderpad().findMin(new int[]{2, 3, 4, 1}), 1);
        assertEquals(new GSCoderpad().findMin(new int[]{1}), 1);
        assertEquals(new GSCoderpad().findMin(new int[]{2, 1}), 1);
    }

    //3. https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
    public String largest(List<String> nums) {
        nums.sort((o1, o2) -> {
            long a = Long.parseLong(o1 + o2);
            long b = Long.parseLong(o2 + o1);
            return (int) (b - a);
        });
        StringBuilder ans = new StringBuilder();
        for (String num : nums) {
            ans.append(num);
        }
        return ans.toString();
    }

    @Test
    public void largestTest() {
        //54, 546, 548, 60
        List<String> list1 = Arrays.asList("54", "546", "548", "60");
        assertEquals("6054854654", new GSCoderpad().largest(list1));

        //1, 34, 3, 98, 9, 76, 45, 4
        List<String> list2 = Arrays.asList("1", "34", "3", "98", "9", "76", "45", "4");
        assertEquals("998764543431", new GSCoderpad().largest(list2));
    }

    //1. https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character - 2 times
    //2. https://www.geeksforgeeks.org/maximum-consecutive-repeating-character-string/
    public char longestRepeatingChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        int index = 0;
        int lcr = 1;
        int temp = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) temp++;
            else temp = 1;
            if (temp > lcr) {
                lcr = temp;
                index = i;
            }
        }
        return s.charAt(index);
    }

    @Test
    public void lcrTest() {
        assertEquals(' ', new GSCoderpad().longestRepeatingChar(""));
        assertEquals('d', new GSCoderpad().longestRepeatingChar("aaabccdddd"));
        assertEquals('a', new GSCoderpad().longestRepeatingChar("aabc"));
        assertEquals('a', new GSCoderpad().longestRepeatingChar("adbce"));
        assertEquals('b', new GSCoderpad().longestRepeatingChar("aabbbaa"));
        assertEquals(' ', new GSCoderpad().longestRepeatingChar(null));
        assertEquals(' ', new GSCoderpad().longestRepeatingChar(""));
    }
}
