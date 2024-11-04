package com.example.demo.implementations;

import com.example.demo.dto.Ex1;
import com.example.demo.services.Palindrome;

public class EhPalindrome implements  Palindrome {

    @Override
    public Ex1 palindromo(String palavra) {
        String result = new StringBuilder(palavra).reverse().toString();
        
        for (int i = 0, j = palavra.length() -1 ;i < j; i++, j--) {
            if (palavra.charAt(i) != palavra.charAt(j))
                return new Ex1(result, false);
        }
        return new Ex1(result, true);
    }
    
}
