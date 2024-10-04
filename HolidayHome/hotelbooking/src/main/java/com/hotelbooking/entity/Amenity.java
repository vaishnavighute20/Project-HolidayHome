package com.hotelbooking.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "amenities")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    
    @ManyToMany(mappedBy = "amenities")
    private List<Room> rooms;
}
