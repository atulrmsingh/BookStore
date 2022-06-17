package com.bookstore.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bookstore.entity.UserEntity;

@Repository
public interface BookStoreRepo extends JpaRepository<UserEntity,Integer> {

	Optional<UserEntity> findByUserName(String userName);

}
