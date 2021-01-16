import { Component } from '@angular/core';
import { CalculatorService } from './services/calculator.service';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})


export class AppComponent {

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
}
