package fr.afcepf.al32.groupe2.dao;


import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.SalesUnit;

@Transactional
@Component
public class SalesUnitJpaDao implements ISalesUnitDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override 
	public SalesUnit findOne(Long id) {
		return entityManager.find(SalesUnit.class, id);}
	@Override
	public  List<SalesUnit> findAll(){
		return entityManager.createNamedQuery("SalesUnit.findAll",SalesUnit.class).getResultList();
		
	}
//	@Override 
//	public SalesUnit  findall() {
//		return entityManager.find(SalesUnit.class, id);
//	}
//	public interface CrudRepository<T, ID extends Serializable>
//	  extends Repository<T, ID> {
//
//	  <S extends T> S save(S entity);      
//
//	  Optional<T> findById(ID primaryKey); 
//
//	  Iterable<T> findAll();               
//
//	  long count();                        
//
//	  void delete(T entity);               
//
//	  boolean existsById(ID primaryKey);   
//
//	  // … more functionality omitted.
	
	@Override 
	public SalesUnit createOne(SalesUnit salesUnit) {
		entityManager.persist(salesUnit);
		return salesUnit;
	}
	
	
}
