public class Main {

    public static void main(String[] args) {
        // First Attempt - What the README results are based on
        int answer = emod(5, 213962984, 658996103);
        System.out.println("Our A: " + answer);
        answer = emod(2, 28406022, 35530787);
        System.out.println("Our B: " + answer);
        answer = emod(28406022, 213962984, 35530787);
        System.out.println("Our Alice key: " + answer);
        answer = emod(213962984,28406022,658996103);
        System.out.println("Our Bob key: " + answer);

        // Second attempt
        /*
        int answer;
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
        if (b == 0) {
            return 1;
        } else if (b % 2 == 0) {
            int d = emod(a, b / 2, c);
            return ((d * d) % c);
        } else {
            return (((a % c) * emod(a, b - 1, c)) % c);
        }
    }
}
