package com.rest.app;

import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepo extends JpaRepository<book, Long> {


}
