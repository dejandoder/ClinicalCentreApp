package isa.project.repository;

import java.util.List;

import isa.project.model.Klinika;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KlinikaRepository extends JpaRepository<Klinika, Long> {
	
	List<Klinika> findAll();
	
	//@Query("select klinika from Klinika klinika where klinika.id in (select id from Pregled p where p.tip = ?1)")
	//@Query("select k from Klinika as k join k.pregledi as p where p.tip = ?1")
	//List<Klinika> pronadjiPoTipuPregleda(String parametar);
	
	//List<Klinika> findById();
    
	/*
	 * from Book b where b.id in (select bookId from Author a
                              where a.lastname = :ln
                              and a.firstname = :fn)
       "select c from Category as c " +
    "inner join c.product as product " +
    "where product.productId=:productId"
	 * Query query2 = session.createQuery("SELECT DISTINCT cont FROM "
                    + "Continent cont JOIN cont.countries t WHERE cont.name='Europe'");
            Continent europe_cont = (Continent) query2.getSingleResult();*/
}
