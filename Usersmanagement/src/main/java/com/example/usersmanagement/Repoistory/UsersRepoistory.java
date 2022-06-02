package com.example.usersmanagement.Repoistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.usersmanagement.model.Users;


@Repository
public interface UsersRepoistory extends JpaRepository<Users,Integer> {

    Users findByName(String name);


    @Query(value = "SELECT s FROM Users s WHERE s.age=?1")
    List<Users> findAllByAgeGreaterThanEqual(Integer age);



    @Query("SELECT s FROM Users s WHERE s.Joiningyear=?1 or s.Joiningyear>?1")
    List<Users> findAllByJoiningyear(String Joiningyear);

    @Query("SELECT s FROM Users s WHERE (s.Joiningyear=?1 or s.Joiningyear<?1) and age =?2")
    List<Users> findAllByJoiningyearAndAge(String Joiningyear,int age);

}
