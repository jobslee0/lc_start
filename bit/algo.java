public int hammingWeight(int n) {
    int res = 0;
    while (n != 0) {
        n &= n - 1;
        res++;
    }
    return res;
}

public boolean isPowerOfTwo(int n) {
    return (n>0)&&!(n&(n-1));
}

public int[] countBits(int n) {
    int[] bits = new int[n+1];
    for (int i = 1; i <= n; i++) {
        bits[i] = bits[i & (i - 1)] + 1;
    }
    return bits;
}