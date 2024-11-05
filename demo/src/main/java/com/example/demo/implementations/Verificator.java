// package com.example.demo.implementations;

// import com.example.demo.dto.Ex4.Ex4;
// import com.example.demo.services.ValidateCPF;

// public class Verificator implements ValidateCPF {

//     @Override
//     public Ex4 CpfVerify(String cpf) {

//         Integer sumFirst = 0;
//         for (int i = 0; i < cpf.length()-2 ; i++) {
//             sumFirst +=  Integer.valueOf(cpf.charAt(i))*(i+1);
//         }
//         sumFirst = sumFirst%11;
//         char FirstDigit = cpf.charAt(cpf.length()-2);
//         var teste = FirstDigit == String.valueOf(FirstDigit).charAt(String.valueOf(FirstDigit).length()-1) ? true : false;


//         return new Ex4(teste, sumFirst);
//     }
    
// }
