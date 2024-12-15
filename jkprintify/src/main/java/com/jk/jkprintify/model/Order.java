package com.jk.jkprintify.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class Order {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String studentName;
        private String email;
        private String mobileNumber;
        private String pdfLink;
        private Integer orderQuantity;
        private String message;
        private LocalDateTime deadlineDate;
        private LocalDateTime orderDate;
        private String status;

        @ManyToOne
        @JoinColumn(name = "service_id", nullable = false)
        private Service service;

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getPdfLink() {
            return pdfLink;
        }

        public void setPdfLink(String pdfLink) {
            this.pdfLink = pdfLink;
        }

        public Integer getOrderQuantity() {
            return orderQuantity;
        }

        public void setOrderQuantity(Integer orderQuantity) {
            this.orderQuantity = orderQuantity;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public LocalDateTime getDeadlineDate() {
            return deadlineDate;
        }

        public void setDeadlineDate(LocalDateTime deadlineDate) {
            this.deadlineDate = deadlineDate;
        }

        public LocalDateTime getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(LocalDateTime orderDate) {
            this.orderDate = orderDate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Service getService() {
            return service;
        }

        public void setService(Service service) {
            this.service = service;
        }


}



