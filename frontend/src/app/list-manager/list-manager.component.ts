import { Component, OnInit } from '@angular/core';
import {Todo} from "../interfaces/todo";
import {TodoListService} from "../services/todo-list.service";

@Component({
  selector: 'app-list-manager',
  templateUrl: './list-manager.component.html',
  styleUrls: ['./list-manager.component.css']
})
export class ListManagerComponent implements OnInit {

  todoList!: Todo[];

  constructor(private todoListService: TodoListService) { }

  ngOnInit() {
    this.todoList = this.todoListService.getTodoList();
  }

  addItem(title: string) {
    this.todoListService.addItem({ title });
  }

  removeItem(item: Todo) {
    this.todoListService.deleteItem(item);
  }

  updateItem(item: Todo, changes: any) {
    this.todoListService.updateItem(item, changes);
  }
}
