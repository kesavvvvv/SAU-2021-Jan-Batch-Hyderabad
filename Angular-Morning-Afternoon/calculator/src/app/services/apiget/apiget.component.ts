import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

export class data {
  
  userId: string | undefined;
  id: string | undefined;
  title: string | undefined;
  body: string | undefined;
}

@Component({
  selector: 'app-apiget',
  templateUrl: './apiget.component.html',
  styleUrls: ['./apiget.component.css']
})

export class ApigetComponent implements OnInit {

  data: data[] | undefined;
  
  constructor(private pull: ApiService) { }
  ngOnInit(): void {
  }

  getData() {
    this.pull.getData()
      .subscribe(
        (response) => {                       
          this.data = response; 
        })
  }
}
