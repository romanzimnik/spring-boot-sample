import { Injectable } from '@angular/core';
import {Todo} from "../interfaces/todo";
import {StorageService} from "./storage.service";

const todoListStorageKey = 'Todo_List';

const defaultTodoList = [
  {title: 'install NodeJS'},
  {title: 'install Angular CLI'},
  {title: 'create new app'},
  {title: 'serve app'},
  {title: 'develop app'},
  {title: 'deploy app'},
];

@Injectable({
  providedIn: 'root'
})
export class TodoListService {
  todoList!: Todo[];

  constructor(private storageService: StorageService) {
    this.todoList =
      storageService.getData(todoListStorageKey) || defaultTodoList;
  }

  getTodoList() {
    return this.todoList;
  }

  addItem(item: Todo) {
    this.todoList.push(item);
    this.saveList();
  }

  deleteItem(item: Todo) {
    const index = this.todoList.indexOf(item);
    this.todoList.splice(index, 1);
    this.saveList();
  }

  updateItem(item: Todo, changes: Todo) {
    const index = this.todoList.indexOf(item);
    this.todoList[index] = { ...item, ...changes };
    this.saveList();
  }

  saveList() {
    this.storageService.setData(todoListStorageKey, this.todoList);
  }
}
