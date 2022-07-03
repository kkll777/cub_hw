package com.example.cub_hw.repositories;

import com.example.cub_hw.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, String> {}