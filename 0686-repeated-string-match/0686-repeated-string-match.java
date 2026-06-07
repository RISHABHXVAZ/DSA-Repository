class Solution {
    public int repeatedStringMatch(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        
        // 1. Calculate minimum repetitions needed to at least cover length of b
        int count = (int) Math.ceil((double) n2 / n1);
        
        // 2. Build the initial string using StringBuilder for performance
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(a);
        }
        
        // 3. Check current state and up to 2 extra repetitions
        // Extra repetitions are needed to account for b starting at the end of A
        for (int i = 0; i <= 2; i++) {
            if (sb.toString().contains(b)) {
                return count + i;
            }
            sb.append(a);
        }
        
        return -1;
    }
}