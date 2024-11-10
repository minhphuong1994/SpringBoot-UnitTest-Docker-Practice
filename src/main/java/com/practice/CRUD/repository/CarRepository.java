package com.practice.CRUD.repository;

import com.practice.CRUD.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

    @Query(value= """
            SELECT * FROM CAR_DETAILS WHERE MAKE=:make
            """,nativeQuery = true)
    Car getCarByMake(@Param("make") String make);
}
