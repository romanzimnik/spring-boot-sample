import { Injectable } from '@angular/core';
import {Note} from "../interfaces/note";
import {StorageService} from "./storage.service";

const noteListStorageKey = 'Todo_List';

const defaultNoteList = [
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
export class NoteListService {
  noteList!: Note[];

  constructor(private storageService: StorageService) {
    this.noteList =
      storageService.getData(noteListStorageKey) || defaultNoteList;
  }

  getNoteList() {
    return this.noteList;
  }

  addItem(item: Note) {
    this.noteList.push(item);
    this.saveList();
  }

  deleteItem(item: Note) {
    const index = this.noteList.indexOf(item);
    this.noteList.splice(index, 1);
    this.saveList();
  }

  updateItem(item: Note, changes: Note) {
    const index = this.noteList.indexOf(item);
    this.noteList[index] = { ...item, ...changes };
    this.saveList();
  }

  saveList() {
    this.storageService.setData(noteListStorageKey, this.noteList);
  }
}
