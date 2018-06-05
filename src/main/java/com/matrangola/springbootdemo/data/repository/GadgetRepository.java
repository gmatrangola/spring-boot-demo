package com.matrangola.springbootdemo.data.repository;

import com.matrangola.springbootdemo.data.model.Gadget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GadgetRepository extends JpaRepository<Gadget, Long> {
}
