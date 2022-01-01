package application;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
    public static void main(String[] args) {
        //deixamos o id como null pois o banco já irá criar os ids

        Pessoa pessoa1 = new Pessoa(null,"luis pires", "luis@gmail.com");
        Pessoa pessoa2 = new Pessoa(null,"maria", "maria@gmail.com");
        Pessoa pessoa3 = new Pessoa(null,"gustavo", "gustavo@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
        Pessoa p = em.find(Pessoa.class, 2);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        System.out.println(p);
       em.close();
       emf.close();
    }
}
