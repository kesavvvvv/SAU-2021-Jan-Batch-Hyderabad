import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

import { CalculatorService } from '../calculator.service';

@Component({
  selector: 'app-name-editor',
  templateUrl: './name-editor.component.html',
  styleUrls: ['./name-editor.component.css']
})
export class NameEditorComponent implements OnInit {


  title = 'calculator';
	result:number = 0;
	num1:number = 0;
	num2:number = 0;

	constructor(private calc:CalculatorService){

	}
	
	addition () {		
		this.result = this.calc.add(this.num1, this.num2);
	}

	subtraction (a: number, b: number) {
		this.result = this.calc.sub(a, b);
	}
	multiplication (a: number, b: number) {
		this.result = this.calc.mul(a, b);
	}
	division (a: number, b: number) {
		this.result = this.calc.div(a, b);
	}



  // name = new FormControl('');
  
  // constructor() { }

  // ngOnInit(): void {
  // }

  // updateName() {
  //   this.name.setValue("Kesav");
  // }

}
