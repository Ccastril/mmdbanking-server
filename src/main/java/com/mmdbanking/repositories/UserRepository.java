package com.mmdbanking.repositories;

import com.mmdbanking.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{_id:?0}")
    User findOneById(String id);
    @Query("{_id:?0}")
    User findOneById(ObjectId id);

    @Query("{password:?0}")
    User findOne(String password);

    @Query("{email:?0}")
    User findUserByEmail(String email);

    @Query("{firstName:?0,lastName: ?1}")
    User findUserByFullName(String firstName, String lastName);



}
