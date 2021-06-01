package com.j2kb.jibapi.global.config;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.repository.CrudRepository;

@SpringBootTest
public class RedisConfigTest {

    @Autowired
    private PersonRedisRepository redisRepository;

    @Test
    public void basicSave() {
        // given
        Address address = new Address("서울특별시 서울시청");
        Person person = new Person(null, "first", "last", address);

        // when
        Person savedPerson = redisRepository.save(person);

        // then
        Optional<Person> findPerson = redisRepository.findById(savedPerson.getId());

        assertThat(findPerson.isPresent()).isEqualTo(Boolean.TRUE);
        assertThat(findPerson.get().getFirstname()).isEqualTo(person.getFirstname());
    }
}

@Getter
@RedisHash("people")
class Person {
    @Id
    String id;
    String firstname;
    String lastname;
    Address address;

    @Builder
    public Person(String id, String firstname, String lastname, Address address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }
}

@Getter
class Address {
    private String address;

    public Address(String address) {
        this.address = address;
    }
}

interface PersonRedisRepository extends CrudRepository<Person, String> {

}