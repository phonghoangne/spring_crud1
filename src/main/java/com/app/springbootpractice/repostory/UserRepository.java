package com.app.springbootpractice.repostory;

import com.app.springbootpractice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

// tuong tac voi database
public interface UserRepository  extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
    // user map voi abng duoi database , kieu du lieu cua khoa chinh
    //JpaSpecificationExecuto -> tao ra dieu kien truy van dong
    List<User> findAll();
     Optional<User> findByUserId(Integer id);
     Optional<User> findByUserName(String name);
     Optional<User> findByPassword(String password);

    @Query("select p from User p where p.country = :country")
    Optional<User>  findByCountrys(@Param("country") String country);
    @Query( value = "select u from user u where u.phone = :phone",nativeQuery = true)
    Optional<User>  findByPhones(String phone);

    @Query(value = "select u.user_id from user u where u.user_name = :userName",nativeQuery = true)
    Integer getIdByUserName(String userName);
}
