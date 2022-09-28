//package com.eql.Hotel.dto;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.validation.Valid;
//import java.util.Date;
//
//@Entity
//@Table(name = "room_reservations")
//public class RoomReservation {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//
//    @Valid
//    @ManyToOne(fetch = FetchType.EAGER)//
//    @JoinColumn(name="rooms_id", nullable = false)
//    private Room room;
//
//
//    @Valid
//    @ManyToOne(fetch = FetchType.EAGER)//
//    @JoinColumn(name="users_id", nullable = false)
//    private UserDto user;
//
//    @Column(name = "end_price", nullable = false)
//    private int endPrice;
//
//    @Column(name="check_in_date")
//    private Date checkInDate;
//
//    @Column(name="check_out_date")
//    private Date checkOutDate;
//
//    @Column(name="number_of_people", nullable=false)
//    private int numberOfPeople;
//
//    @Column(name="reservation_start_date", nullable=false)
//    private Date reservationStartDate;
//
//    @Column(name="reservation_end_date", nullable=false)
//    private Date reservationEndDate;
//
//    @Column
//    private boolean verified;
//
//    @Column
//    private boolean paid;
//
//}
