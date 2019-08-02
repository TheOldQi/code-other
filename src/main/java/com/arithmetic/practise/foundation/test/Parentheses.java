package com.arithmetic.practise.foundation.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.arithmetic.practise.foundation.collection.ArrayStack;

public class Parentheses {

    public static void main(String[] args) {
        File file = new File("/self-study-files/Parentheses.txt");

        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            String str = null;
            ArrayStack<String> stack = new ArrayStack<String>();
            while ((str = br.readLine()) != null) {
                for (Character c : str.toCharArray()) {
                    String aCharStr = c.toString();
                    if ("(".equals(aCharStr) || "[".equals(aCharStr) || "{".equals(aCharStr)) {
                        stack.push(aCharStr);
                    } else if (")".equals(aCharStr)) {
                        if (!stack.pop().equals("(")) {
                            System.out.println(false);
                            return;
                        }
                    } else if ("]".equals(aCharStr)) {
                        if (!stack.pop().equals("[")) {
                            System.out.println(false);
                            return;
                        }
                    } else if ("}".equals(aCharStr)) {
                        if (!stack.pop().equals("{")) {
                            System.out.println(false);
                            return;
                        }
                    }
                }
            }
            System.out.println(true);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
