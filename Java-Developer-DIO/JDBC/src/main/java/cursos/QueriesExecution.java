package cursos;

import java.util.List;

public class QueriesExecution {
    public static void main(String[] args) {
        CursoDAO cursoDAO = new CursoDAO();

        List<Curso> cursos = cursoDAO.list();

        cursos.stream().forEach(System.out::println);
    }
}