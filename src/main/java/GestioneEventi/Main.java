package GestioneEventi;

import java.time.LocalDate;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        EventoDAO dao = new EventoDAO();

        Evento e1 = new Evento(new Random().nextInt(10, 1000), "Matrimonio",
                LocalDate.of(2024,10,12),
                "Evento all'aperto con cerimonia",TipoEvento.PRIVATO,180);

        try {
            dao.save(e1);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(dao.getById(e1.getId()));

        dao.delete(e1.getId());
    }

}
