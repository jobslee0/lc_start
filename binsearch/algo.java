public int mySqrt(int x) {
    if (x == 0 || x == 1) {
        return x;
    }
    int l = 1, r = x, res = 0;
    while (l <= r) {
        int m = (l + r) / 2;
        // m^2==x 数据范围控制
        if (m == x / m) {
            return m;
        } else if (m > x / m) {
            r = m - 1;
        } else {
            l = m + 1;
            res = m;
        }
    }
    return res;
}

public boolean isPerfectSquare(int x) {
    int l = 1, r = x;
    while (l <= r) {
        int m = (l + r) / 2;
        if (m == x / m) {
            return true;
        } else if (m > x / m) {
            r = m - 1;
        } else {
            l = m + 1;
        }
    }
    return false;
}