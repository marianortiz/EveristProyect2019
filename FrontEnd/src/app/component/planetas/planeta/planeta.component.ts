import { Component, OnInit } from '@angular/core';
import { Planeta } from 'src/app/Modelo/planeta';
import { ActivatedRoute, Router } from '@angular/router';
import { PlanetaService } from 'src/app/Service/planeta.service';
import { Estrella } from 'src/app/Modelo/estrella';
import { EstrellaService } from 'src/app/Service/estrella.service';

@Component({
  selector: 'app-planeta',
  templateUrl: './planeta.component.html',
  styleUrls: []
})
export class PlanetaComponent implements OnInit {

  estrellas: Estrella[] = []

  

  planeta: Planeta = {
    id: undefined,
    name: " ",
    tamanio: null,
    dencidad: null,
    estrellaDTO: {
      id: undefined,
      nombre: " ",
      tamanio: null
    }
  }





  constructor(private pservice: PlanetaService, private actRoute: ActivatedRoute,
    private router: Router, private eservice: EstrellaService) {

    this.getEstrella()
    this.actRoute.params.subscribe((data) => {
      if (data.id != 0) {
        this.pservice.getOne(data.id).subscribe((data2) => {
          this.planeta = data2;
        })
      }
    })
  }


  ngOnInit() {
  }


  save() {
    if (this.planeta.id != undefined) {
      
      //update
      this.pservice.put(this.planeta.id, this.planeta).subscribe((data) => {
      console.log("entro al put desde save() con :", this.planeta); 
      this.router.navigate(["planetas"]);

      });
    }
    else {

      //new
      this.pservice.post(this.planeta).subscribe((data) => {
        console.log("entro al post desde save() con :", this.planeta); 
      this.router.navigate(['planetas']);
      
      });
    }
  }


  getOne(id: number) {
    this.pservice.getOne(id).subscribe((data) => {
      this.planeta = data;
    })
  }

  getEstrella() {
    this.eservice.getAll().subscribe((data) => {
      this.estrellas = data;
    })
  }


}
