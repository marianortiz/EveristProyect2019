import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Planeta } from '../Modelo/planeta';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PlanetaService {

  _url:string = 'http://localhost:8084/api/v1/planetas/'

  constructor(private http:HttpClient) { }

  getAll() : Observable <Planeta[]>{
    return this.http.get<Planeta[]>(this._url);
  }

  getOne(id:number) : Observable <Planeta>{
    return this.http.get<Planeta>(this._url + id)
  }

  post(planeta:Planeta) : Observable <Planeta>{
    return  this.http.post<Planeta>(this._url, planeta)
  }

  put(id:number, planeta:Planeta) : Observable <Planeta>{
    return  this.http.put<Planeta>(this._url + id , planeta)  
  }

  delete(id:number) : Observable <any>{
    return this.http.delete(this._url + id)
  }


}