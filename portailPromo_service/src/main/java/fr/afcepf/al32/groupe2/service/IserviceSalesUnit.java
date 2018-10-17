package fr.afcepf.al32.groupe2.service;


import java.util.Map;

import fr.afcepf.al32.groupe2.entity.SalesUnit;


public interface IserviceSalesUnit {
	
	SalesUnit rechercheUniteDeVenteParIdentifiant(Long id);
	SalesUnit AjouterSalesUnit(SalesUnit salesUnit);
	
}
