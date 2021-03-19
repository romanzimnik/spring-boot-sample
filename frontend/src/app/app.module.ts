import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InputButtonUnitComponent } from './input-button-unit/input-button-unit.component';
import { NoteComponent } from './note/note.component';
import { ListManagerComponent } from './list-manager/list-manager.component';
import {NoteListService} from "./services/note-list.service";

@NgModule({
  declarations: [
    AppComponent,
    InputButtonUnitComponent,
    NoteComponent,
    ListManagerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [NoteListService],
  bootstrap: [AppComponent]
})
export class AppModule { }
