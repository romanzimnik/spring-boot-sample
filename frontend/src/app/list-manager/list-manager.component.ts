import { Component, OnInit } from '@angular/core';
import {Todo} from "../interfaces/todo";

@Component({
  selector: 'app-list-manager',
  templateUrl: './list-manager.component.html',
  styleUrls: ['./list-manager.component.css']
})
export class ListManagerComponent implements OnInit {

  todoList : Todo[] = [
    {title: 'install NodeJS'},
    {title: 'install Angular CLI'},
    {title: 'create new app'},
    {title: 'serve app'},
    {title: 'develop app'},
    {title: 'deploy app'},
  ];

  constructor() { }

  ngOnInit(): void {
  }

  addItem(title: string) {
    this.todoList.push({ title });
  }

}
