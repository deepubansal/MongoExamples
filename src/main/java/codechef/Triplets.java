package codechef;

public class Triplets {

    public static void main(String[] args) {

         int s[] = {-1, 0, 1, 2, -1, -4};
         sort(s);
         printArray(s);
//        int s[] = { -4, -1, -1, 0, 1, 2 };
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= 0) break;
            if (i > 0 && s[i-1] == s[i]) continue;
            for (int j = i + 1; j < s.length; ++j) {
                if (s[i] + s[j] > 0 ) break;
                if (j > i + 1 && s[j-1] == s[j] ) continue;
                for (int k = j + 1; k < s.length; ++k) {
                    if (-(s[i] + s[j]) < s[k] ) break;
                    if (k > j + 1 && s[k-1] == s[k]) continue;
                    if (s[k] == -(s[i] + s[j])) {
                        System.out.println(s[i] + " " + s[j] + " " + s[k]);
                    }
                }
            }
        }
    }

    private static void printArray(int[] s) {
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

    private static void sort(int[] s) {
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length - i - 1; j++) {
                if (s[j] > s[j + 1]) {
                    int temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                }
            }
        }

    }

}
