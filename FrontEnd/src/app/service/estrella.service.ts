import { Injectable } from '@angular/core';
import { Estrella } from '../Modelo/estrella';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EstrellaService {

  _url:string = 'http://localhost:8084/api/v1/estrellas/'

  constructor(private http:HttpClient) { }

  getAll() : Observable <Estrella[]>{
    return this.http.get<Estrella[]>(this._url);
  }

  getOne(id:number) : Observable <Estrella>{
    return this.http.get<Estrella>(this._url + id)
  }

  post(estrella:Estrella) : Observable <Estrella>{
    return  this.http.post<Estrella>(this._url, estrella)
  }

  put(id:number, estrella:Estrella) : Observable <Estrella>{
    return  this.http.put<Estrella>(this._url + id , estrella)  
  }

  delete(id:number) : Observable <any>{
    return this.http.delete(this._url + id)
  }

}
