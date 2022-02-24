package co.com.sofka.crud.controllers;

import co.com.sofka.crud.models.Todo;
import co.com.sofka.crud.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//Permite el intercambio entre dominios
@CrossOrigin(origins = "http://localhost:3000/")
public class TodoController {
    @Autowired
    TodoService todoService;

    //Listar todos los elementos
    @GetMapping(value = "api/todos")
    public Iterable<Todo> getAllTodos(){
        return this.todoService.getAllTodos();
    }

    //Obtener todos por la id
    @GetMapping(value = "api/{id}/todo/")
    public Todo getTodoById(@PathVariable("id") Long id){
        //Si le id no existe devuelve una excepcion
        return this.todoService.getTodoById(id);
    }

    //Insertar todos a la lista
    @PostMapping(value = "api/todo")
    public Todo insertTodo(@RequestBody Todo element){
        return this.todoService.insertTodo(element);
    }

    //Insertar todos a la lista
    @PutMapping(value = "api/todo")
    public Todo updateTodoById(@RequestBody Todo element){
        if(element.getId() != null){
            return this.todoService.insertTodo(element);
        } else {
            throw new RuntimeException("No existe el id a actualizar");
        }
    }

    //Eliminar todos de la lista
    @DeleteMapping(value = "/api/{id}/todo")
    public void deleteTodo(@PathVariable("id") Long id){
        this.todoService.deleteTodo(id);
    }
}
