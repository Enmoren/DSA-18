public class FirstFailingVersion {

    public static long firstBadVersion(long n, IsFailingVersion isBadVersion) {
        long low = 0;
        long high = n;
        long mid;
        while (low < high) {
            mid = (high + low) / 2;
            if (isBadVersion.isFailingVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
