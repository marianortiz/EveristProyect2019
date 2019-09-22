import { Component, OnInit } from '@angular/core';
import { Estrella } from 'src/app/Modelo/estrella';
import { EstrellaService } from 'src/app/Service/estrella.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-estrella',
  templateUrl: './estrella.component.html',
  styleUrls: ['./estrella.component.css']
})
export class EstrellaComponent implements OnInit {

  estrella: Estrella = {
    id: undefined,
    nombre: null,
    tamanio: null
  }

  constructor(private eservice:EstrellaService, private actRoute: ActivatedRoute, private router: Router) { 
      this.actRoute.params.subscribe((data) => {
        if (data.id != 0) {
          this.eservice.getOne(data.id).subscribe((data2) => {
            this.estrella = data2;
          })
        }
      })
  }

  ngOnInit() {
  }



  save() {
    if (this.estrella.id != undefined) {
      
      //update
      console.log("entra en put del save() con: ", this.estrella)
      this.eservice.put(this.estrella.id, this.estrella).subscribe((data) => {
        this.router.navigate(["estrellas"]);
        
      });
    }
    else {

      //new

      console.log("entra en post del save() con: ", this.estrella)
      this.eservice.post(this.estrella).subscribe((data) => {
      this.router.navigate(['estrellas']);
      
      });
    }
  }

  getOne(id: number) {
    this.eservice.getOne(id).subscribe((data) => {
      this.estrella = data;
    })
  }


}
