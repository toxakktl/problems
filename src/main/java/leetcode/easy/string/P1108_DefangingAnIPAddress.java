package leetcode.easy.string;

public class P1108_DefangingAnIPAddress {

    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();
        for (char c: address.toCharArray()){
            if (c == '.'){
                res.append("[.]");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
