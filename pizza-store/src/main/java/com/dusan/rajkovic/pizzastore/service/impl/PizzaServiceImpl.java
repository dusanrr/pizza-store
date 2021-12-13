package com.dusan.rajkovic.pizzastore.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.dusan.rajkovic.pizzastore.dao.PizzaDao;
import com.dusan.rajkovic.pizzastore.entity.PizzaEntity;
import com.dusan.rajkovic.pizzastore.service.PizzaService;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Transactional
public class PizzaServiceImpl implements PizzaService {
    @Autowired
    private PizzaDao pizzaDao;

    @Override
    @CacheEvict(value = "pizza",allEntries = true)
    public void deletePizzaByName(String name) {
        pizzaDao.deleteByName(name);
    }

    @Override
    @Cacheable("pizza")
    public PizzaEntity getPizzaByName(String name) {
        return pizzaDao.findByNameOrderByDateDesc(name);
    }

    @Override
    @CacheEvict(value = "pizza",allEntries = true)
    public PizzaEntity savePizza(PizzaEntity pizzaEntity) {
    	PizzaEntity pizza = pizzaDao.save(pizzaEntity);
    	return pizza;
    }

    @Override
    public List<PizzaEntity> getAllPizzas() {
        return pizzaDao.findAll(Sort.by(Sort.Direction.DESC, "date"));
    }

    @CacheEvict(value = "pizza",allEntries = true)
    public void updatePizzaBySlug(String slug, PizzaEntity PizzaEntity){
        PizzaEntity newPizza = pizzaDao.findBySlug(slug);
        boolean needUpdate = false;

        if (StringUtils.hasLength(PizzaEntity.getName())) {
            newPizza.setName(PizzaEntity.getName());
            needUpdate = true;
        }
        if (PizzaEntity.getPrice()!=0D) {
            newPizza.setPrice(PizzaEntity.getPrice());
            needUpdate = true;
        }
        if (PizzaEntity.getSize()!=null) {
            newPizza.setPrice(PizzaEntity.getPrice());
            needUpdate = true;
        }
        if (needUpdate) {
            //Auto update date
            PizzaEntity.setDate(Instant.now().truncatedTo(ChronoUnit.SECONDS));
            pizzaDao.save(newPizza);
        }
    }

    public boolean existsBySlug(String slug){
        return pizzaDao.existsById(slug);
    }
}
