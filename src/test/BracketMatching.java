package test;

import stack.LinkStack;

/**
 * 使用栈解决括号匹配问题
 */
public class BracketMatching {

    public static void main(String[] args){
        try {
            checkBrachet("asdfas(gdfg){g[}]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String[] stringToArray(String s){
        int n = s.length();
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = s.substring(i,i+1);
        }
        return array;
    }

    public static void checkBrachet(String string) throws Exception{
        String[] array = stringToArray(string);
        LinkStack stack = new LinkStack();
        for (String s : array) {
            if (s.equals("(") || s.equals("[") || s.equals("{")){
                //左括号全部入栈
                stack.push(s);
            }else if (s.equals("(") && !stack.isEmpty() && stack.getTop().equals(")")){
                stack.pop();
            }else if (s.equals("[") && !stack.isEmpty() && stack.getTop().equals("]")){
                stack.pop();
            }else if (s.equals("{") && !stack.isEmpty() && stack.getTop().equals("}")){
                stack.pop();
            }else if (s.equals(")") && !stack.isEmpty() && !stack.getTop().equals("(")){
                System.out.print("括号次序不对！");
                return;
            }else if (s.equals("]") && !stack.isEmpty() && !stack.getTop().equals("[")){
                System.out.print("括号次序不对！");
                return;
            }else if (s.equals("}") && !stack.isEmpty() && !stack.getTop().equals("{")){
                System.out.print("括号次序不对！");
                return;
            }else if ((s.equals(")") || s.equals("]") || s.equals("}")) && stack.isEmpty()){
                System.out.print("右括号多于左括号！");
                return;
            }
        }
        if (!stack.isEmpty()){
            System.out.print("左括号多于右括号！");
        }else {
            System.out.print("匹配正确！");
        }
    }
}
