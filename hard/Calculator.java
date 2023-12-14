import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Calculator {
    public static void main(String[] args){
        String s = "2*(5+5*2)/3+(6/2+8)";
        String s2 = "6-4/2";
        int ans = calculate(s2);
        System.out.println(ans);
    }
    public static int calculate(String s){
        Map<Character, Integer> map = new HashMap<>(){{
            put('-',1);
            put('+',1);
            put('*',2);
            put('/',2);
        }};

        s = s.replaceAll(" ", "");
        char[] cs = s.toCharArray();
        int n = s.length();

        Deque<Integer> nums = new ArrayDeque<>();
        nums.push(0);
        Deque<Character> ops = new ArrayDeque<>();

        for(int i = 0; i < n; i ++){
            char c = cs[i];
            if(c == '('){
                ops.push(c);
            }else if(c == ')'){
                //to the first left bracket
                while(!ops.isEmpty()){
                    if(ops.peek() != '('){
                        calc(nums, ops);
                    }else{
                        ops.poll();
                        break;
                    }
                }
            }else{
                if(Character.isDigit(c)){
                    int u = 0;
                    int j = i;
                    while(j < n && Character.isDigit(cs[j])) u = u*10 + cs[j++] - '0';
                    nums.push(u);
                    i = j - 1;
                }else{
                    if(i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')){
                        nums.push(0);
                    }
                    while(!ops.isEmpty() && ops.peek() != '('){
                        char prev = ops.peek();
                        if(map.get(prev) >= map.get(c)){
                            calc(nums, ops);
                        }else break;
                    }
                    ops.push(c);
                }
            }
        }

        while(!ops.isEmpty()) calc(nums, ops);
        return nums.poll();
    }
    public static void calc(Deque<Integer> nums, Deque<Character> ops){
        if(nums.isEmpty() || nums.size() < 2) return;
        if(ops.isEmpty()) return;
        int b = nums.poll(), a = nums.poll();
        char op = ops.poll();
        int ans = 0;
        if(op == '+') ans = a + b;
        else if(op == '-') ans = a - b;
        else if(op == '*') ans = a * b;
        else if(op == '/') ans = a / b;
        nums.push(ans);
    }


}
