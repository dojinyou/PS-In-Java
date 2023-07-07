package problemsolving.programmers.kakao.blind_recruitment_22;


/**
 * 프로그래머스 Lv.2 / 92335 / k진수에서 소수 개수 구하기<br/>
 * <a href="https://school.programmers.co.kr/learn/courses/30/lessons/92335">문제 링크</a><br/>
 * solve: 40분
 */

public class Solution2 {
    public int solution(int n, int k) {
        int count = 0;
        String kNum = tenToK(n, k);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < kNum.length(); i++) {
            char kChar = kNum.charAt(i);
            if (kChar == '0' && sb.length() == 0) {
                continue;
            }
            if (kChar == '0' && sb.length() > 0) {
                double localNum = Double.parseDouble(sb.toString());
                if (isPrimeNumber(localNum)) {
                    count++;
                }
                sb.setLength(0);
                continue;
            }
            sb.append(kChar);
        }

        if (sb.length() > 0) {
            double localNum = Double.parseDouble(sb.toString());
            if (isPrimeNumber(localNum)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrimeNumber(double localNum) {
        if (localNum <= 1 || localNum % 2 == 0) {
            return false;
        }

        if (localNum == 2 || localNum == 3) {
            return true;
        }

        for (int i = 3; i <= Math.sqrt(localNum); i += 2) {
            if (localNum % i == 0) {
                return false;
            }
        }
        return true;
    }

    private String tenToK(int n, int k) {
        int share = n;
        StringBuilder sb = new StringBuilder();

        while (share >= k) {
            int remainder = share % k;
            sb.append(remainder);
            share = share / k;
        }
        sb.append(share);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        var sol = new Solution2();
        sol.solution(437674, 3);
    }
}
