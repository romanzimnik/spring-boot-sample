import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Note} from "../../interfaces/note";

@Injectable({
  providedIn: 'root'
})
export class NoteRestServiceService {

  private readonly noteUrl!: string;

  constructor(private http: HttpClient) {
    this.noteUrl = 'http://localhost:8081/api/note';
  }

  /**
   * findAll
   */
  public findAll(): Observable<Note[]> {
    return this.http.get<Note[]>(this.noteUrl);
  }


  /**
   * findOne
   */
  // TODO

  /**
   * create
   * update
   * @param note
   */
  public save(note: Note) {
    return this.http.post<Note>(this.noteUrl, note);
  }

  /**
   * delete
   */

}
