import { Component, OnInit } from '@angular/core';
import { PlanetaService } from 'src/app/Service/planeta.service';
import { Planeta } from 'src/app/Modelo/planeta';
import { Router } from '@angular/router';

@Component({
  selector: 'app-planetas',
  templateUrl: './planetas.component.html',
  styles: []
})
export class PlanetasComponent implements OnInit {

    planetas:Planeta [] = [];

  constructor(private servicio:PlanetaService, private router:Router) {
      this.getAll();
      

  }

  ngOnInit() {
  }

  getAll(){this.servicio.getAll().subscribe((data)=>{
      this.planetas = data;
      console.log(this.planetas);

    })
  }

  delete(id:number){
    this.servicio.delete(id).subscribe((data)=>{
    console.log("borrado");  
    window.location.reload();
    },
    ()=>{
      console.log("no borrado");
    });
  }

  update(id:number){
    this.router.navigate(["planetas/"+ id]);
  }
}
