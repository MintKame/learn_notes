public class maxSub {
    //1.O(n^3)
    int solve1(int s[], int first, int last) {
        int ans = s[first];
        for (int i = first; i <= last; i++) {
            for (int j = i; j <= last; i++) {
                int temp = 0;
                for (int k = i; k <= j; k++) {
                    temp += s[k];
                }
                if (temp > ans) {
                    ans = temp;
                }
            }
        }
        return ans;
    }

    //2.O(n^2)
    int solve2(int s[], int first, int last) {
        int ans = s[first];
        for (int i = first; i <= last; i++) {
            int temp = 0;
            for (int j = i; j <= last; j++) {
                temp += s[j];
                if (temp > ans) {
                    ans = temp;
                }
            }
        }
        return ans;
    }

    //3.O(nlogn) divide & conquer
// T(N) = 2 * T(N/2) + c * N
    int max(int a, int b, int c) {
        return a > b ? (a > c ? a : c) : (b > c ? b : c);
    }

    int solve3(int[] s, int first, int last) {
        if (first == last) {
            if (s[first] > 0)
                return s[first];
            else
                return 0;
        }
        int center = (first + last) / 2;
        int lMax = solve3(s, first, center);
        int rMax = solve3(s, center + 1, last); //conside: only 2 elem
        int lBorderMax = 0, temp = 0;                //max Value when cross the border
        for (int i = center; i >= first; i--) {
            temp += s[i];
            if (temp > lBorderMax) {
                lBorderMax = temp;
            }
        }

        int rBorderMax = 0;
        temp = 0;
        for (int i = center + 1; i <= last; i++) {
            temp += s[i];
            if (temp > rBorderMax) {
                rBorderMax = temp;
            }
        }
        return max(lMax, rMax, lBorderMax + rBorderMax);
    }

    //4.O(n) online algo
    int solve4(int s[], int first, int last) {
        int ans = 0;
        for (int i = first; i <= last; i++) {
            ans += s[i];
            if (ans < 0)
                ans = 0;
        }
        return ans;
    }
}