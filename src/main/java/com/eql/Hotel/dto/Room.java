//package com.eql.Hotel.dto;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import java.util.Set;
//
//@Entity
//@Table(name = "rooms")
//public class Room {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Column(name = "max_number_of_people", nullable = false)
//    private int maxNumberOfPeople;
//
//    @Column(name = "room_number", nullable = false)
//    private int roomNumber;
//
//    @Column(nullable = false)
//    private int floor;
//
//    @Column(nullable = false)
//    private int price;
//
//    @Column(name = "double_beds", nullable = false)
//    private int doubleBeds;
//
//    @Column(name = "single_beds", nullable = false)
//    private int singleBeds;
//
////    @Valid
////    @ManyToOne(fetch = FetchType.EAGER)//EAGER powoduje pobranie obiektu roomtype wraz z obiektem Room.
////    @JoinColumn(name="types_id", nullable = false)
////    private RoomType RoomType;
//
//
//    @OneToMany(mappedBy="room")
//    private Set<RoomReservation> roomReservations;
//}