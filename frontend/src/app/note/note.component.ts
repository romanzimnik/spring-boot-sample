import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Note} from "../interfaces/note";

@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css']
})
export class NoteComponent implements OnInit {
  @Input() item!: Note;

  @Output() remove: EventEmitter<Note> = new EventEmitter();

  @Output() update: EventEmitter<any> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  removeItem() {
    this.remove.emit(this.item);
  }

  completeItem() {
    this.update.emit({
      item: this.item,
      changes: {completed: !this.item.completed}
    });
  }
}
