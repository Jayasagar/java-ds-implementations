package codility;

// For example, number 9 has binary representation 1001 and contains a binary gap of length 2
class BinaryGap {
    public static int solution(int N) {
        // write your code in Java SE 8
        if (N < 0 || N > Integer.MAX_VALUE) {
            return -1;
        }

        if (N == 1 || N == 0) {
            return 0;
        }

        String bits = Integer.toBinaryString(N);
        System.out.println("binary" + bits);

        int result = 0;
        int temp = 0;

        for (char bit : bits.toCharArray()) {
            if ('0' == bit) {
                temp = temp + 1;
            }

            if ('1' == bit && temp > result) {
                result = temp;
                temp = 0;
            } else {
                temp = 0;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int input = 561892;

        System.out.print(solution(input));
    }
}