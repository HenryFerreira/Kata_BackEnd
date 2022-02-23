package co.com.sofka.crud.services;

import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    //Listar todos los elementos
    public Iterable<Todo> getAllTodos(){
        return this.todoRepository.findAll();
    }

    //Insertar todos a la lista
    public Todo insertTodo(Todo element){
        return this.todoRepository.save(element);
    }

    //Obtener todos por la id
    public Todo getTodoById(Long id){
        //Si le id no existe devuelve una excepcion
        return this.todoRepository.findById(id).orElseThrow();
    }

    //Eliminar todos de la lista
    public void deleteTodo(Long id){
        this.todoRepository.delete(getTodoById(id));
    }
}
