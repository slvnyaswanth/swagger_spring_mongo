package com.restApplication.servers.repository;

import com.restApplication.servers.entity.ServersEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServersRepository extends MongoRepository<ServersEntity,String> {
    @Query("{'name' : ?0}")
    public List<ServersEntity> findServerByName(String name);
}
