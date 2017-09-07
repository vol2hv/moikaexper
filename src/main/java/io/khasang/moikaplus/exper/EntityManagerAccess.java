package io.khasang.moikaplus.exper;

import io.khasang.moikaplus.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.util.List;
import java.util.Map;
@Repository
@Transactional
public class EntityManagerAccess {
    @PersistenceContext
    @Autowired
    private EntityManager em ;



    EntityManagerAccess(EntityManager entityManager){
        this.em = entityManager;
    }


    public void proba(){
        Phone phone = new  Phone(0l,"xxx");
        em.persist(phone);


    }
}

