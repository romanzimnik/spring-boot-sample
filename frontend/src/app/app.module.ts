import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InputButtonUnitComponent } from './input-button-unit/input-button-unit.component';
import { TodoComponent } from './todo/todo.component';
import { ListManagerComponent } from './list-manager/list-manager.component';
import {TodoListService} from "./services/todo-list.service";

@NgModule({
  declarations: [
    AppComponent,
    InputButtonUnitComponent,
    TodoComponent,
    ListManagerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [TodoListService],
  bootstrap: [AppComponent]
})
export class AppModule { }
