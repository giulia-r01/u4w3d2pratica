package GestioneEventi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    public void save(Evento evento){
        em.getTransaction().begin();

        em.persist(evento);

        em.getTransaction().commit();
    }

    public Evento getById(int id){
        return em.find(Evento.class, id);
    }

    public void delete(int id){
        Evento e = getById(id);

        if (e != null) {
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        }else {
            System.out.println("L'evento con id " + id + "non è stato trovato");
        }
    }

}
