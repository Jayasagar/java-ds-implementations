package codility;

/**
 * Created by jayasagar on 11/11/2016.
 */
public class Solution {

    static int solution(int n) {
        int[] d = new int[32];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p < 1 + l; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 955;
        //System.out.print(solution(2147483647));
        System.out.print(solution(1));
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
