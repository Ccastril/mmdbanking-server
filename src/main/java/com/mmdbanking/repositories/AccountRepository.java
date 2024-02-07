package com.mmdbanking.repositories;

import com.mmdbanking.models.Account;
import com.mmdbanking.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    @Query("{_id:?0}")
    Account findOneById(String id);


}
