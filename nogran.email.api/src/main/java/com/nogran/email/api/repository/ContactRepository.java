package com.nogran.email.api.repository;

import java.util.List;

import com.nogran.email.api.domain.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findAllByNameContainingIgnoreCase(@Param("name") String name);
}
