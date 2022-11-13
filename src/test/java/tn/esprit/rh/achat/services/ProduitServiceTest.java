package tn.esprit.rh.achat.services;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Produit;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProduitServiceTest {

    @Autowired
    IProduitService ps;


   @Order(1)
	@Test
    public void addProduitWithSuccess() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Date dateCreation = dateFormat.parse("30/08/2021");
        Date dateDerniereModification =dateFormat.parse("30/09/2022");
        Produit produit = new Produit();
        produit.setPrix(11);
        produit.setDateCreation(dateCreation);
        produit.setDateDerniereModification(dateDerniereModification);
        produit.setLibelleProduit("libelleProduitrr8");
        produit.setCodeProduit("code221");
        Produit p = ps.addProduit(produit);
        System.out.print("Produit"+p);
        assertNotNull(produit.getCodeProduit());
        assertNotNull(produit.getPrix());
        assertTrue(produit.getLibelleProduit().length() > 0 );
    }
    @Order(2)
	@Test
     public void deleteClientWithSuccess() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateCreation = dateFormat.parse("30/08/2021");
        Date dateDerniereModification =dateFormat.parse("30/09/2021");
        Produit produit = new Produit();
        produit.setPrix(11);
        produit.setDateCreation(dateCreation);
        produit.setDateDerniereModification(dateDerniereModification);
        produit.setLibelleProduit("libelleProduit");
        produit.setCodeProduit("code2212222");
        Produit p = ps.addProduit(produit);
        ps.deleteProduit(p.getIdProduit());
        assertNull(ps.retrieveProduit(p.getIdProduit()));


    }

}
