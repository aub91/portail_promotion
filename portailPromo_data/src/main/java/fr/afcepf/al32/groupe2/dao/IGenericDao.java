package fr.afcepf.al32.groupe2.dao;

import java.util.List;

/*
 * DAO = Data Access Object (objet specialise dans l'acces aux donnees)
 * couche logicielle "persistance" ou "acces aux donnees"
 * avec methodes "CRUD" 
 * C: Create (insert into)
 * R: Recherche
 * U: Update
 * D: Delete
 */

public interface IGenericDao<T extends Object> { // pattern générique pour la classe T
	public T findOne(Long numero); //recherche par clef primaire
	public void save(T p); //saveOrUpdate (insert into ou update)
	public void delete(Long numero);
	//...
	public List<T> findAll();
	//...
}
