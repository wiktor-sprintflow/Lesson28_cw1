package com.example.springdataexcercise.repository;

import com.example.springdataexcercise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u")
    List<User> jpqlFindAll();

    @Query(value = "SELECT * FROM User", nativeQuery = true)
    List<User> nativeFindAll();

    List<User> findByLastNameContaining(String letter);

    @Query(value= "SELECT u FROM User u WHERE u.lastName LIKE %:letter%")
    List<User> jpqlFindByLastNameContains(String letter);

    @Query(value = "SELECT * FROM User u WHERE u.last_name LIKE %:letter%", nativeQuery = true)
    List<User> nativeFindByLastNameContains(@Param("letter") String letters);


    @Transactional
    void deleteUserByFirstNameStartsWith(String letter);

    @Transactional
    @Modifying
    @Query(value= "DELETE FROM User u WHERE u.firstName LIKE :letter%")
    void jpqlDeleteByFirstNameStartingWith(String letter);

    @Transactional
    @Modifying
    @Query(value= "DELETE FROM User u WHERE u.first_name LIKE :letter%", nativeQuery = true)
    void nativeDeleteByFirstNameStartingWith(String letter);

    List<User> findByOrderByLastNameDesc();

    @Query(value= "SELECT u FROM User u ORDER BY u.lastName DESC")
    List<User> jpqlFindUsersByLastNameOrderByLastNameDesc();

    @Query(value= "SELECT * FROM User u ORDER BY u.last_name DESC", nativeQuery = true)
    List<User> nativeFindUsersByLastNameOrderByLastNameDesc();

}
