INSERT INTO sales_unit(id,name) VALUE(1,'piece')
INSERT INTO sales_unit(id,name) VALUE(2,'kilo')
INSERT INTO sales_unit(id,name) VALUE(3,'litre')
INSERT INTO reference_product(id,name, date_referencing,date_derefencing,unite_de_vente,categorie_Produit) VALUES (id, 'nom',sysdate(),null,1,null)
INSERT INTO reference_product(id,name, date_referencing,date_derefencing,unite_de_vente,categorie_Produit) VALUES (id, 'nom',sysdate(),null,2,null)
INSERT INTO reference_product(id,name, date_referencing,date_derefencing,unite_de_vente,categorie_Produit) VALUES (id, 'nom',sysdate(),null,3,null)
INSERT INTO reference_product(id,name, date_referencing,date_derefencing,unite_de_vente,categorie_Produit) VALUES (id, 'nom',sysdate(),null,1,1)