package com.example.splash;

public class User {



        String name;
        String email;
       // String contact;
        String pass;

        public User() {
        }

        public User(String name, String email, String pass) {
            this.name = name;
            this.email = email;
            this.pass = pass;
           // this.contact = contact;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

   //     public String getContact() {
   //         return contact;
      //  }

   //     public void setContact(String contact) {
 //           this.contact = contact;
 //       }
    }

