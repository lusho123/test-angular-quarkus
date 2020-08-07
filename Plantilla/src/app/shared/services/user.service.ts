import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User, UserVO } from '../model/User';
import { Response } from '../model/Response';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  options = {
    headers: new HttpHeaders({ 
      'Access-Control-Allow-Origin':'*'
    })
  };
  url = 'http://localhost:5200/api/users';

  constructor(private http: HttpClient) { }

  getUsers(): Observable<Response> {
    // return this.http.get<User[]>(this.url, this.options);
    return this.http.get<Response>(this.url);
  }

  getUserById(id: any): Observable<Response> {
    return this.http.get<Response>(`${this.url}/${id}`);
  }

  getUserByName(name: string): Observable<Response> {
    return this.http.get<Response>(`${this.url}/name/${name}`);
  }

  postUser(user: User): Observable<Response> {
    return this.http.post<Response>(this.url, user);
  }

  putUser(user: UserVO): Observable<Response> {
    return this.http.put<Response>(this.url, user);
  }

  deleteUser(id: any): Observable<Response> {
    console.log(`${this.url}/${id}`);
    
    return this.http.delete<Response>(`${this.url}/${id}`);
  }

  getProfile(): Observable<Response> {
    return this.http.get<Response>(`${this.url}/profiles`);
  }

}
