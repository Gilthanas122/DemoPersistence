package com.demojpa.demo.repository;

import com.demojpa.demo.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

  // JPQL query
  @Query("SELECT s FROM Car s WHERE s.brand = 'Audi'")
  Car findMyFavouriteCar();

  // Native SQL query
  @Query(value = "select * FROM car WHERE brand = 'Audi'", nativeQuery = true)
  Car findMyFavouriteCarative();

  //// Using named query parameters
  @Query(value = "select * FROM car WHERE brand Like :brand", nativeQuery = true)
  List<Car> findMyStudentWithSimilarName(@Param("brand") String brand);



  // Using wildcard
  @Query(value = "SELECT * from car WHERE brand LIKE ?1%", nativeQuery =true)
  List<Car> findCarWithWildCard(String brand);

  List<Car> findAllByBrandContaining(String brand);

  // Using indexed query parameters
  @Query(value = "SELECT * FROM car WHERE brand = ?1 AND speed > ?2", nativeQuery = true)
   List<Car> findStudentByAge(String brand, int speed);
}
