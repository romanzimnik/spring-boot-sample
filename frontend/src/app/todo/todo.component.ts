import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Todo} from "../interfaces/todo";

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  @Input() item!: Todo;

  @Output() remove: EventEmitter<Todo> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  removeItem() {
    this.remove.emit(this.item);
  }
}
