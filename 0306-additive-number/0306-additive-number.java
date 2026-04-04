import java.math.BigInteger;

class Solution {
    boolean check(List<BigInteger> temp){
        BigInteger fn = temp.get(0);
        BigInteger ln = temp.get(1);

        for(int i = 2; i < temp.size(); i++){
            if(temp.get(i).equals(fn.add(ln))){
                fn = ln;
                ln = temp.get(i);
            }else return false;
        }
        return true;
    }

    boolean func(int index, List<BigInteger> temp, String num){
        if(index == num.length()){
            return temp.size() > 2 && check(temp);
        }

        for(int i = index; i < num.length(); i++){
            String part = num.substring(index, i+1);

            if(part.length() > 1 && part.startsWith("0")) break;

            BigInteger curr = new BigInteger(part);

            if(temp.size() < 2 || 
               curr.equals(temp.get(temp.size()-1).add(temp.get(temp.size()-2)))) {

                temp.add(curr);
                if(func(i+1, temp, num)) return true;
                temp.remove(temp.size()-1);
            }    
        }
        return false;
    }

    public boolean isAdditiveNumber(String num) {
        return func(0, new ArrayList<>(), num);
    }
}