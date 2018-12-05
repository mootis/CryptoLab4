public class Main {

    public static void main(String[] args) {
        int answer;

        /*
        // Final attempt - secret a = 1234, b = 5678
        answer = emod(2, 1234, 35530787);
        System.out.println("A: " + answer);
        answer = emod(5, 5678, 658996103);
        System.out.println("B: " + answer);
        */

        // First Attempt - What the README results are based on


        // A = (ourG ^ ourA) % ourP
        // (2, 213962984, 35530787)
        answer = emod(5, 213962984, 658996103);
        System.out.println("Our A: " + answer);

        // B = (theirG ^ ourB) % theirP
        // (5, 28406022, 658996103)
        answer = emod(2, 28406022, 35530787);
        System.out.println("Our B: " + answer);

        // This does not seem right
        answer = emod(28406022, 213962984, 35530787);
        System.out.println("Our Alice key: " + answer);

        // This does not seem right
        answer = emod(213962984,28406022,658996103);
        System.out.println("Our Bob key: " + answer);


        // Second attempt
        /*
        answer = emod(2,1234,35530787);
        System.out.println("Our A: " + answer);
        answer = emod(5,5678,658996103);
        System.out.println("Our B: " + answer);
        answer = emod(213962984,5678,658996103);
        System.out.println(answer);
        answer = emod(28406022,1234,35530787);
        System.out.println(answer);
        */
    }

    public static int emod(int a, int b, int c) {
        // Second attempt
        /*
        int res = 1;
        a = a % c;
        while(b > 0) {
            if ((b & 1) == 1) {
                res = ((res * a) % c);
            }
            b = b >> 1;
            a = ((a * a) % c);
        }
        return res;
        */

        // First attempt

        if (b == 0) {
            return 1;
        } else if (b % 2 == 0) {
            int d = emod(a, b / 2, c);
            return ((d * d) % c);
        } else {
            return (((a % c) * emod(a, b - 1, c)) % c);
        }

    }

    // Pollard's Rho method - a = alpha, b = beta
    public int[] pr(int a, int b) {
        int[] answer = {0, 0, 0, 0};
        boolean notComplete = true;
        while (notComplete) {
            // i_1
            answer[0] = newValue;

            // j_1
            answer[1] = newValue;

            // i_2
            answer[2] = newValue;

            // j_2
            answer[3] = newValue;

            // Complete checker
            if ((a ^ answer[0] * b ^ answer[1]) == (a ^ answer[2] * b ^ answer[3])) {
                notComplete = false;
            }
        }
        return answer;
    }

    /*
    // Baby step giant step where a is generator g and b is the prime number p
    public int bsgs(int a, int b) {
        int[] alpha;
        double m = Math.sqrt(b);
        int g;

        int[] array = new int[b];
        for (int i = 0; i < b; i++) {
            array[i] = i;
        }

        int answer = (b(a ^ (-m))^g);
    }
    */
}
