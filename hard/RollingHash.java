import java.util.HashSet;
import java.util.Set;

public class RollingHash {
    public static void main(String[] args){
        String s = "banana";
        String ans = longestDupSubstring(s);
        System.out.println(ans);
    }
    public static String longestDupSubstring(String s) {
        int l = 1, r = s.length();
        while(l <= r){
            int mid = (l + r)/2;
            if(search(s, mid) != -1) l = mid + 1;
            else r = mid - 1;
        }
        int i = search(s, l - 1);
        if(i == -1) return "";
        return s.substring(i, i + l - 1);
    }
    public static int search(String s, int len){
        int mod = (int)1e9 + 7;
        int mod2 = (int)1e9 + 9;
        int prime = 113;
        int prime2 = 31;
        int n = s.length();
        Set<Long> set = new HashSet<>();
        Set<Long> set2 = new HashSet<>();
        long hash = 0;
        long hash2 = 0;
        for(int i = 0; i < len; i ++){
            int c = s.charAt(i);
            hash = (hash*prime + c)%mod;
            hash2 = (hash2*prime2 + c)%mod2;
        }
        long power = 1;
        long power2 = 1;
        for(int i = 0; i < len - 1; i ++){
            power = (power*prime)%mod;
            power2 = (power2*prime2)%mod2;
        }
        set.add(hash);
        set2.add(hash2);


        for(int i = 0, j = len; j < n; i ++, j ++){
            int l = s.charAt(i);
            int r = s.charAt(j);
            hash = hash - (l*power%mod) + mod;
            hash = (hash *prime + r)%mod;

            hash2 = hash2 - (l*power2%mod2) + mod2;
            hash2 = (hash2 *prime2 + r)%mod2;

            if(set.contains(hash) && set2.contains(hash2)) return i + 1;
            set.add(hash);
            set2.add(hash2);
        }
        return -1;
    }
}
