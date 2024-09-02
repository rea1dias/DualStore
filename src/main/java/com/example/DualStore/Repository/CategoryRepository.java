package com.example.DualStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.DualStore.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {


    public Boolean existsByName(String name);



}
