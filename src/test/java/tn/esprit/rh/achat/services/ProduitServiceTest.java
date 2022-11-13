package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProduitServiceTest {

    @Autowired
    IProduitService ps;

    @Test
    @Order(1)
    public void testRetrieveAllUsers() {
        List<Produit> listProduits = ps.retrieveAllProduits();
        Assertions.assertEquals(0, listProduits.size());
    }
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
    
    public void retrieveAllProduits() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateCreation = dateFormat.parse("30/08/2021");
        Date dateDerniereModification =dateFormat.parse("30/09/2022");
        List<Produit> produits = ps.retrieveAllProduits();
        int expected = produits.size(); 
        Produit produit = new Produit();
        produit.setPrix(11);
        produit.setDateCreation(dateCreation);
        produit.setDateDerniereModification(dateDerniereModification);
        produit.setLibelleProduit("markaa");
        produit.setCodeProduit("code2212222");
        Produit p = ps.addProduit(produit);
        assertEquals(expected + 1,ps.retrieveAllProduits().size());
        ps.deleteProduit(p.getIdProduit());

    }
}
