package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	
////DRIVER DE CONEXAO
	private static final String DRIVER 			= "org.postgresql.Driver";
    
	//Dados de caminho, porta e nome da base de dados que irá ser feita a conexão
	private static final String DATABASE_URL	= "jdbc:postgresql://localhost:5432/ReservaLab";
    
    //Nome do Usuario do Postgres
    private static final String USERNAME 		= "postgres";
    
    //Senha do Postgre
    private static final String PASSWORD 		= "123456";
	
    private static Connection connection        = null;    		
	
				  //RETORNO       //NOME DO MÉTODO
    public static Connection createConnectionToPostgres() throws Exception {
        try {        	
        	
        	//Faz com que a classe seja carregada pela JVM
        	Class.forName(DRIVER);
        	//Cria a conexão com o banco de dados
        	connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);        	
        } catch (ClassNotFoundException ex) {
            System.out.println("ERRO ao conectar a base de dados!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
                		
		return connection;
    }

}
