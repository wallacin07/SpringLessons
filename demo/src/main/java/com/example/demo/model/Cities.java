// package com.example.demo.model;

// import jakarta.persistence.Id;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;

// @Entity
// public class Cities {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column
//     private String City;

//     @Column
//     private String State;

//     @Column
//     private String Country;

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getCity() {
//         return City;
//     }

//     public void setCity(String City) {
//         this.City = City;
//     }

//     public String getState() {
//         return State;
//     }

//     public void setState(String State) {
//         this.State = State;
//     }

//     public String getCountry() {
//         return Country;
//     }

//     public void setCountry(String Country) {
//         this.Country = Country;
//     }


// }