import { Component, OnInit } from '@angular/core';
import {Note} from "../interfaces/note";
import {NoteListService} from "../services/note-list.service";

@Component({
  selector: 'app-list-manager',
  templateUrl: './list-manager.component.html',
  styleUrls: ['./list-manager.component.css']
})
export class ListManagerComponent implements OnInit {

  noteList!: Note[];

  constructor(private noteListService: NoteListService) { }

  ngOnInit() {
    this.noteList = this.noteListService.getNoteList();
  }

  addItem(title: string) {
    this.noteListService.addItem({ title });
  }

  removeItem(item: Note) {
    this.noteListService.deleteItem(item);
  }

  updateItem(item: Note, changes: any) {
    this.noteListService.updateItem(item, changes);
  }
}
