 
INSERT INTO catalog
    (id,name,description,referenceId)
VALUES
    (1,'Heavy Equipment','Catalog to Hold the Heavy Equipment Details','H-EQUIPMENT');
    
     
INSERT INTO item
    (id,name,description,referenceId, price, catalogId)
VALUES
    (1,'Crane','Crane to move items from Shore to Land','I-Crane',20000,1);