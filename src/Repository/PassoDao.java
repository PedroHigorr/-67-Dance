package Repository;

import Model.Passo;
import Repository.ConnectionFactory;
import java.sql.SQLException;

public class PassoDao {
    
    public void insertPassos(Passo passo){
    
        String sql = "INSERT INTO passos(id, nome, historia, caminho_video) VALUES (?,?,?,?)";
        
        try(var conn = ConnectionFactory.getConnection();
            var pstmt = conn.prepareStatement(sql)){
            
            pstmt.setString(1, passo.getId());
            pstmt.setString(2, passo.getNome());
            pstmt.setString(3, passo.getHistoria());
            pstmt.setString(4, passo.getCaminho_video());
            pstmt.executeUpdate();
            
        }catch(SQLException e){
        
            System.err.println("Erro ao inserir dados no banco: \n"+e.getMessage());
        }
    }
    
    
}
