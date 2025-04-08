package com.project.springboot.footballapp.repository;

import com.project.springboot.footballapp.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,String> {
}
