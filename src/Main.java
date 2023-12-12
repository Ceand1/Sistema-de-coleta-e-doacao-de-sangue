import javax.swing.SwingUtilities;

import model.dao.DoadorDAO;
import model.dao.DoadorDoacaoDAO;
import model.dao.PostoDAO;
import model.dao.ReceptorDAO;
import model.dao.ReceptorRecebeDAO;
import model.dao.Usuario_emailDAO;
import model.implementations.DoadorDAOJDBC;
import model.implementations.DoadorDoacaoDAOJDBC;
import model.implementations.PostoDAOJDBC;
import model.implementations.ReceptorDAOJDBC;
import model.implementations.ReceptorRecebeDAOJDBC;
import model.implementations.Usuario_emailDAOJDBC;
import telas.TelaInicialFrame;

public class Main {
    public static void main(String[] args) {
        // Assegura que a criação da GUI seja feita na Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DoadorDAO doadorDAO = new DoadorDAOJDBC(ConnectionFactory.getConnection());
                ReceptorDAO receptorDAO = new ReceptorDAOJDBC(ConnectionFactory.getConnection());
                PostoDAO postoDAO = new PostoDAOJDBC(ConnectionFactory.getConnection());
                Usuario_emailDAO usuario_emailDAO = new Usuario_emailDAOJDBC(ConnectionFactory.getConnection());
                DoadorDoacaoDAO doadorDoacaoDAO = new DoadorDoacaoDAOJDBC(ConnectionFactory.getConnection());
                ReceptorRecebeDAO receptorRecebeDAO = new ReceptorRecebeDAOJDBC(ConnectionFactory.getConnection());
                new TelaInicialFrame(doadorDAO, receptorDAO, postoDAO, usuario_emailDAO, doadorDoacaoDAO,
                        receptorRecebeDAO);
            }
        });
    }
}