import { Component, OnInit } from '@angular/core';
import { EstrellaService } from 'src/app/Service/estrella.service';
import { Estrella } from 'src/app/Modelo/estrella';
import { Router } from '@angular/router';

@Component({
  selector: 'app-estrellas',
  templateUrl: './estrellas.component.html',
  styles: []
})
export class EstrellasComponent implements OnInit {

  estrellas:Estrella[] = [];

  constructor(private eservicio:EstrellaService, private router:Router) { 
    this.getAll();
  }

  ngOnInit() {
  }

  getAll(){this.eservicio.getAll().subscribe((data)=>{
    this.estrellas = data;
    console.log(this.estrellas);

  })
}

delete(id:number){
  this.eservicio.delete(id).subscribe((data)=>{
  console.log("borrado");  
  window.location.reload();
  },
  ()=>{
    console.log("no borrado");
  });
}

update(id:number){
  this.router.navigate(["estrella/"+ id]);
}




}