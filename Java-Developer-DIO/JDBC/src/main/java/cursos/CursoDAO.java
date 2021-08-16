package cursos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    //Listar Todos Os Cursos
    public List<Curso> list()
    {

        List<Curso> cursos = new ArrayList<>();

        try (Connection connect = ConnectionFactory.getConnection())
        {
            PreparedStatement psmt = connect.prepareStatement("SELECT * FROM curso");
            ResultSet rs = psmt.executeQuery();

            while (rs.next())
            {
                Curso curso = new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("duracao_horas")
                );

                cursos.add(curso);
            }
        }
        catch(Exception e)
        {
            System.out.println("Erro ao Listar Cursos");
            e.printStackTrace();
        }

        return cursos;

    }

    //Lista um curso especifico
    public Curso getById(int id)
    {
        Curso curso = new Curso();

        try (Connection connect = ConnectionFactory.getConnection())
        {
            PreparedStatement psmtp = connect.prepareStatement("SELECT * FROM CURSO WHERE id = ?");
            psmtp.setInt(1, id);

            ResultSet rs = psmtp.executeQuery();

            if (rs.next())
            {
                curso.setId(rs.getInt("ID"));
                curso.setNome(rs.getString("NOME"));
                curso.setDuracaoHoras(rs.getInt("DURACAO_HORAS"));
            }
        }
        catch (Exception e)
        {
            System.out.println("Erro ao busca curso");
            e.printStackTrace();
        }

        return curso;
    }
}
