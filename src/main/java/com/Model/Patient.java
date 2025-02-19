package com.Model;

public class Patient {
        private int id;
        private String username;
        private String email;
        private int telephone;
        private String motif;

        public Patient(int id, String username, String email, int telephone, String motif) {
            this.id = id;
            this.username = username;
            this.email = email;
            this.telephone = telephone;
            this.motif = motif;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getTelephone() {
            return telephone;
        }

        public void setTelephone(int telephone) {
            this.telephone = telephone;
        }

        public String getMotif() {
            return motif;
        }

        public void setMotif(String motif) {
            this.motif = motif;
        }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", motif='" + motif + '\'' +
                '}';
    }
}
