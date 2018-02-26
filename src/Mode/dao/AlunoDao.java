package Mode.dao;

import Model.bean.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
Buscas por nome, por turma e por escolas ok
exclusão ok

 */

public class AlunoDao {

    private Connection con = null;//contrutor do conector

    public AlunoDao() {
        con = Conection.ConectionFactory.getConection();//invocando o conector do DB
    }

    public boolean save(Aluno user, String esc, String turm) {//Classe que insere e salva os dados
        String sql = "INSERT INTO aluno (nome,turma_nome, turma_Escola_nome) VALUES (?,?,?);";

        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);// preparando o DB para inserção
            stmt.setNString(1, user.getNome());//inserindo o objeto aluno
            stmt.setNString(2, esc);
            stmt.setNString(3, turm);

            stmt.executeUpdate();// update
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro, não salvo" + ex);
            return false;
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt);
        }

    }

public boolean InsertNotas(int id, double nota){// insere uma nota no DB
    
    PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO notas (aluno_idaluno,nota)VALUES (?,?) ");// preparando o DB para inserção
            stmt.setInt(1, id);
            stmt.setDouble(2, nota);
            

            stmt.executeUpdate();// update
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro, Nota Não INSERIDA " + ex);
            return false;
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt);
        }
}
    public List<Aluno> buscaporNome(String a) {// array do tipo aluno
        String sql = "SELECT *FROM aluno WHERE nome LIKE ?";//selecionando todos os componentes da tabela
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> user = new ArrayList();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setNString(1, "%" + a + "%");
            rs = stmt.executeQuery();// executando o select from 

            while (rs.next()) {// while para adicionar o objeto aluno na arraylist do tipo aluno
                Aluno us = new Aluno();
                us.setId(rs.getInt("idAluno"));
                us.setNome(rs.getString("nome"));
                us.turma.escola.setNome(rs.getNString("turma_Escola_nome"));
                us.turma.setNome(rs.getNString("turma_nome"));
                user.add(us);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO, não encontrado");
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt, rs);// fechando conecção 
        }
        return user;
    }

    public List<Aluno> buscaporTurma(String a) {// array do tipo aluno
        String sql = "SELECT *FROM aluno WHERE turma_nome LIKE ?";//selecionando todos os componentes da tabela
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> user = new ArrayList();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setNString(1, "%" + a + "%");
            rs = stmt.executeQuery();// executando o select from 

            while (rs.next()) {// while para adicionar o objeto aluno na arraylist do tipo aluno
                Aluno us = new Aluno();
                us.setId(rs.getInt("idAluno"));
                us.setNome(rs.getString("nome"));
                us.turma.escola.setNome(rs.getNString("turma_Escola_nome"));
                us.turma.setNome(rs.getNString("turma_nome"));
                user.add(us);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO, não encontrado");
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt, rs);// fechando conecção 
        }
        return user;
    }

    public List<Aluno> buscaporEscola(String a) {// array do tipo aluno
        String sql = "SELECT *FROM aluno WHERE turma_Escola_nome LIKE ?";//selecionando todos os componentes da tabela
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> user = new ArrayList();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setNString(1, "%" + a + "%");
            rs = stmt.executeQuery();// executando o select from 

            while (rs.next()) {// while para adicionar o objeto aluno na arraylist do tipo aluno
                Aluno us = new Aluno();
                us.setId(rs.getInt("idAluno"));
                us.setNome(rs.getString("nome"));
                us.turma.escola.setNome(rs.getNString("turma_Escola_nome"));
                us.turma.setNome(rs.getNString("turma_nome"));
                user.add(us);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO, não encontrado");
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt, rs);// fechando conecção 
        }
        return user;
    }

        public boolean alterar(String nome, String escola, String turma, int id) {//Classe que insere e salva os dados
        
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE aluno SET nome = ? , turma_nome = ? , turma_Escola_nome = ? WHERE idAluno = ?");// preparando o DB para inserção
            stmt.setNString(1, nome);//inserindo o objeto aluno
            stmt.setNString(2, turma);
            stmt.setNString(3, escola);
            stmt.setInt(4,id);

            stmt.executeUpdate();// update
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro, Não Alterado!" + ex);
            return false;
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt);
        }

    }
        
     public List<Aluno> pegaNotas( ) {// array do tipo aluno
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> user = new ArrayList();

        try {
            stmt = con.prepareStatement("SELECT idaluno, nome,turma_nome,turma_escola_nome, GROUP_CONCAT(DISTINCT nota ORDER BY und ASC SEPARATOR ';') as notas\n" +
"FROM notas as a inner join aluno as b on (a.aluno_idaluno = b.idaluno) group by nome  ;");
           // stmt.setInt(1, id);
            rs = stmt.executeQuery();// executando o select from 

            while (rs.next()) {// while para adicionar o objeto aluno na arraylist do tipo aluno
                Aluno us = new Aluno();
                us.setId(rs.getInt("idaluno"));
                us.setNome(rs.getString("nome"));
                us.turma.escola.setNome(rs.getNString("turma_Escola_nome"));
                us.turma.setNome(rs.getNString("turma_nome"));
                us.setNotas(rs.getString("notas"));
                user.add(us);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO, não encontrado");
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt, rs);// fechando conecção 
        }
        return user;
    }       
   
     

    public boolean delete(int id) {
        String sql3 = "DELETE FROM aluno WHERE idAluno = ?"; // deleta aluno onde o nome é igual ao inserido
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql3);
            stmt.setInt(1, id); // id
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("NÃO EXCLUIU" + ex);
            return false;
        } finally {
            Conection.ConectionFactory.CloseConnection(con, stmt);
        }

    }

}
