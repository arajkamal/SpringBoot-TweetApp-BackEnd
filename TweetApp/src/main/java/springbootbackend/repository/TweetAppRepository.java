package springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springbootbackend.entity.RegisterEntity;

@Repository
public interface TweetAppRepository extends JpaRepository<RegisterEntity, Integer> {

}
