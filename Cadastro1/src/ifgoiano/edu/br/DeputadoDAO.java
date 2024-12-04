package ifgoiano.edu.br;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Scanner;

public class DeputadoDAO {

	Scanner s = new Scanner(System.in);
	public boolean cadastrar() {
		try {
			String sql = "INSERT INTO deputado " + 
		"(nome, data_ingresso, partido, idestado) " +
		"VALUES (?, ?, ?, ?)";
			PreparedStatement p = ConnectionFactory.getConnection().prepareStatement(sql);
			
			System.out.println("Adicione o nome do Deputado: ");
			p.setString(1,s.nextLine());
			
			System.out.println("Adicione a dia: ");
            int dia = s.nextInt();
            System.out.println("Adicione o mês:");
            int mes = s.nextInt();
            System.out.println("Adicione o ano:");
            int ano = s.nextInt();
            Date utilDate = new Date(ano - 1900, mes - 1, dia);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            p.setDate(2, sqlDate);
	        
	        System.out.println("Adicione o partido: ");
	        p.setString(3, s.next());
	        
	        System.out.println("Adicione o ID: ");
			p.setInt(4, s.nextInt());
			
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
				String sql = "DELETE FROM deputado " + 
				"WHERE id = ? ";
				PreparedStatement p = ConnectionFactory.getConnection().prepareStatement(sql);
				Scanner s = new Scanner(System.in);
				System.out.println("Digite o ID do usuário:");
				p.setInt(1, s.nextInt());
				p.execute();
				p.close();
				ConnectionFactory.close();
				return true;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		public boolean update(){
			try {
				String sql = "UPDATE deputado SET nome = ?, "
						+ "data_ingresso = ?,"
						+ " partido = ?,"
						+ " idestado = ?"
						+ " WHERE id = ?";
				Scanner sc = new Scanner(System.in);
				PreparedStatement p = ConnectionFactory.getConnection().prepareStatement(sql);
				
				System.out.println("Informe  o nome do deputado?");
				p.setString(1, sc.next());
				System.out.println("informe o ano:");
				int ano = sc.nextInt();
				System.out.println("informe o mes:");
				int mes = sc.nextInt();
				System.out.println("Informe o dia:");
				int dia = sc.nextInt();
				Date utilDate = new Date(ano - 1900, mes - 1, dia);
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				p.setDate(2, sqlDate);
				
				System.out.println("De qual partido o deputado e :");
				p.setString(3, sc.next());
				
				System.out.println("Qual o id do Estado: ");
				p.setInt(4, sc.nextInt());
				
				System.out.println("Informe o ID do deputado para remove-lo: ");
				p.setInt(5, sc.nextInt()); 
				p.execute();
				
				int rowsAffected = p.executeUpdate();
		        p.close();
		        ConnectionFactory.close();

		        if (rowsAffected > 0) {
		            System.out.println("Deputado atualizado com sucesso!");
		            return true;
		        } else {
		            System.out.println("Nenhum deputado foi atualizado. Verifique o ID do deputado.");
		            return false;
		        }
			}catch(Exception ex) {
				return false;
			}
		}
}
