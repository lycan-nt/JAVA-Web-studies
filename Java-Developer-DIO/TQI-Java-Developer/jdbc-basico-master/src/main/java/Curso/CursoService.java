package Curso;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class CursoService {
    public static void main(String[] args) throws Exception {
        //Teste Create
//        Curso curso = new Curso();
//        curso.setNome("GO");
//        curso.setDataHora("08:45:00");
//
//        CursoDAO cursoDAO = new CursoDAO();
//        cursoDAO.create(curso);

        //Teste READ By ID
//        Curso curso = new Curso();
//        CursoDAO cursoDAO = new CursoDAO();
//        curso = cursoDAO.getById(2);
//        System.out.println("Curso: " + curso.toString());

        //Teste Read List
//        List<Curso> cursoList = new ArrayList<Curso>();
//        CursoDAO cursoDAO = new CursoDAO();
//        cursoList = cursoDAO.readCursos();
//        System.out.println("Cursos: " + cursoList);

        //Teste update
//        Curso curso = new Curso(2,"AWS", "250:00:25");
//        CursoDAO cursoDAO = new CursoDAO();
//        curso = cursoDAO.update(curso);
//        System.out.println("Curso atualizado: " + curso.toString());

        //Teste delete
        Curso curso = new Curso();
        CursoDAO cursoDAO = new CursoDAO();
        curso = cursoDAO.getById(6);
        curso = cursoDAO.delete(curso);
        System.out.println("Curso deletado: " + curso);
    }

}
