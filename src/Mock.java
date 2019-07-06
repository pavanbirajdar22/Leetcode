/*
12
push 4
pop
push 3
push 5
push 2
inc 3 1
pop
push 1
inc 2 2
push 4
pop
pop
 */

public class Mock {
    static void superStack(String[] operations) {
        long[] a = new long[2_00_001];
        long[] b = new long[2_00_001];
        int top = -1;

        for (int i = 0; i < operations.length; i++) {
            String s = operations[i];
            if (s.startsWith("push")) {
                String[] s1 = s.split(" ");
                top++;
                a[top] = Long.parseLong(s1[1]);
                System.out.println(a[top] + b[top]);
            } else if (s.startsWith("pop")) {
                String[] s2 = s.split(" ");
                if (top != 0) b[top - 1] += b[top];
                a[top] = 0;
                b[top] = 0;
                top--;
                if (top == -1) System.out.println("EMPTY");
                else {
                    System.out.println(a[top] + b[top]);
                }
            } else {
                String[] s3 = s.split(" ");
                int num = Integer.parseInt(s3[1]) - 1;
                b[num] += Integer.parseInt(s3[2]);
                System.out.println(a[top] + b[top]);
            }
        }
    }
}
