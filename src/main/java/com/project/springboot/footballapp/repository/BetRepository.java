package com.project.springboot.footballapp.repository;

import com.project.springboot.footballapp.entity.Bet;
import com.project.springboot.footballapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Long> {
    List<Bet> findByUser(User user);

    List<Bet> findByResultCheckedFalse();
}
