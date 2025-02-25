package com.mihir.doctorlist.repository;

import com.mihir.doctorlist.entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public
interface DoctorRepository extends MongoRepository<Doctor, Long> {
    Optional<Doctor> findByName(String name);
    void deleteByName(String name);

}
