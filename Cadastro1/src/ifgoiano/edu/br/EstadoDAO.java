package ifgoiano.edu.br;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EstadoDAO {

    Scanner s = new Scanner(System.in);

    public boolean cadastrar() {
        try {
            String sql = "INSERT INTO estado " +
                "(nome, regiao) " +
                "VALUES (?, ?)";
            PreparedStatement p = ConnectionFactory.getConnection().prepareStatement(sql);

            System.out.println("Adicione o nome: ");
            p.setString(1, s.nextLine());

            System.out.println("Adicione a região: ");
            p.setString(2, s.nextLine());

            p.execute();
            p.close();
            ConnectionFactory.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean remove() {
        try {
            String sql = "DELETE FROM estado " + 
                "WHERE id = ? ";
            PreparedStatement p = ConnectionFactory.getConnection().prepareStatement(sql);
            Scanner s = new Scanner(System.in);
            System.out.println("Digite o ID do estado:");
            p.setInt(1, s.nextInt());
            p.execute();
            p.close();
            ConnectionFactory.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update() {
        try {
            String sql = "UPDATE estado SET nome = ?, regiao = ? WHERE id = ?";
            PreparedStatement p = ConnectionFactory.getConnection().prepareStatement(sql);

            System.out.println("Informe o novo nome: ");
            p.setString(1, s.nextLine());

            System.out.println("Informe a nova região: ");
            p.setString(2, s.nextLine());

            System.out.println("Informe o ID do estado a ser atualizado: ");
            p.setInt(3, s.nextInt());

            int rowsAffected = p.executeUpdate();
            p.close();
            ConnectionFactory.close();

            if (rowsAffected > 0) {
                System.out.println("Estado atualizado com sucesso!");
                return true;
            } else {
                System.out.println("Nenhum estado foi atualizado. Verifique o ID do estado.");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
