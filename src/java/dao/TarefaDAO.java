package dao;

import entidades.Tarefa;
import java.util.List;

public interface TarefaDAO {

    public void save(Tarefa tarefa);

    public void delete(Tarefa tarefa);

    public Tarefa find(int id);

    public List<Tarefa> list();
}
