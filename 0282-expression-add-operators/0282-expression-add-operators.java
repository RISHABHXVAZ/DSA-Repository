class Solution {
    void func(int i, List<String> lst, String num, int target,
              long val, long last, String expr) {

        if (i == num.length()) {
            if (val == target) lst.add(expr);
            return;
        }

        for (int j = i; j < num.length(); j++) {
            if (j != i && num.charAt(i) == '0') break;

            String currstr = num.substring(i, j + 1);
            long curr = Long.parseLong(currstr);

            if (i == 0) {
                func(j + 1, lst, num, target, curr, curr, currstr);
            } else {
                // addition
                func(j + 1, lst, num, target,
                     val + curr, curr, expr + "+" + currstr);

                // subtraction
                func(j + 1, lst, num, target,
                     val - curr, -curr, expr + "-" + currstr);

                // multiplication
                func(j + 1, lst, num, target,
                     val - last + last * curr,
                     last * curr,
                     expr + "*" + currstr);
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        List<String> lst = new ArrayList<>();
        func(0, lst, num, target, 0, 0, "");
        return lst;
    }
}