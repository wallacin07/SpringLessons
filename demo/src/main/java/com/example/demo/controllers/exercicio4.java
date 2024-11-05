// package com.example.demo.controllers;

// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;


// // import com.example.demo.dto.Ex3;
// import com.example.demo.dto.Ex4.Ex4;
// // import com.example.demo.dto.Ex4.dados;
// // import com.google.gson.Gson;
// import com.example.demo.implementations.Verificator;

// // import java.io.BufferedReader;
// // import java.io.IOException;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// // import java.net.HttpURLConnection;
// // import java.io.InputStreamReader;
// // import java.net.URL;
// // import java.util.logging.Logger;



// @RestController
// // @RequestMapping("")
// public class exercicio4 {
    
//     @GetMapping("/curitiba")
//     @CrossOrigin(origins = { "http://localhost:5257/" })
//     public ResponseEntity<Ex4> login(@RequestParam(value = "cep",defaultValue = "83020610")String cep, @RequestParam(value = "cpf", defaultValue = "12345678909")String cpf)   
// {
//     Verificator teste = new Verificator();
//     var sla = teste.CpfVerify(cpf);
//     return ResponseEntity.ok(sla);
        
//     }          
// }
    



