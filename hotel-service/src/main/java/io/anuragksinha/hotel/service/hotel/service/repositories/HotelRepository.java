package io.anuragksinha.hotel.service.hotel.service.repositories;

import io.anuragksinha.hotel.service.hotel.service.entities.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
}
