package com.arithmetic.practise.foundation.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 测试用例：算数表达式中序转后续
 *
 * @author qixiafei
 */
public class InfixToPostFix {

    public static void main(String[] args) {

        try (FileReader fr = new FileReader("/self-study-files/1310.txt"); BufferedReader br = new BufferedReader(fr)) {
            String line = null;
            while ((line = br.readLine()) != null) {
                for (Character c : line.toCharArray()) {
//					if()
                }
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
