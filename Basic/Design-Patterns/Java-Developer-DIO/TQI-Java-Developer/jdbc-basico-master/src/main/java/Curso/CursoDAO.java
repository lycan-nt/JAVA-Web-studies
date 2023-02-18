package Curso;

import part3.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//CRUD
public class CursoDAO {

    //Create
    public void create(Curso curso) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO curso (nome, data_duracao) values (?, ?)";
            PreparedStatement pstmt = connection.prepareCall(sql);
            pstmt.setString(1, curso.getNome());
            pstmt.setString(2, curso.getDataHora());

            System.out.println("SQL: " + pstmt);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Reade
    public Curso getById(int id) throws Exception {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM curso where id = ?";
            PreparedStatement psmtm = connection.prepareStatement(sql);
            psmtm.setInt(1, id);
            ResultSet rs = psmtm.executeQuery();
            if (rs.next()) {
                Curso curso = new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("data_duracao")
                );
                return curso;
            }
            else {
                throw new Exception("Erro ao buscar Curso");
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao buscar Curso");
        }
    }

    //READ List
    public List<Curso> readCursos() throws Exception {
        List<Curso> cursoList = new ArrayList<Curso>();
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM curso;";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("data_duracao")
                );
                cursoList.add(curso);
            }
            return cursoList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao buscar dados");
        }
    }

    //UPDATE
    public Curso update(Curso curso) throws Exception {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE curso SET nome = ?, data_duracao = ? WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, curso.getNome());
            pstmt.setString(2, curso.getDataHora());
            pstmt.setInt(3, curso.getId());
            pstmt.executeUpdate();
            return curso;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao atualizar dados");
        }
    }

    //DELETE
    public Curso delete(Curso curso) throws Exception {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM curso where id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, curso.getId());
            pstmt.executeUpdate();
            return curso;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao deletar curso");
        }
    }

}
