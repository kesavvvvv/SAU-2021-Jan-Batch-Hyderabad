import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { FormBuilder, Validators } from '@angular/forms';
import {LOCAL_STORAGE, WebStorageService} from 'angular-webstorage-service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  profile = this.fb.group({
    firstName: ['', Validators.required],
    lastName: [''],
    email: [''],
    op: ['']
  });

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
  }

  populateForm(){
    if("form-data" in localStorage){
      let name = localStorage.getItem('lastname');
      console.log(name);
    }
  }
  
  onSubmit() {
    console.warn(this.profile.value);
    // localStorage.setItem(‘name’, 'kesav');
  //  localStorage.setItem('flag', '1');

    
    var flag = localStorage.getItem('flag');

    let string = 'form-data-' + flag;

    console.log(string);  

    if(flag != null){
      var s = parseInt(flag);
      s += 1;
      flag = s.toString();
      localStorage.setItem('flag', flag);
    }
   
    console.log(flag);


    let form = localStorage.getItem('form-data');

    var form1 = JSON.parse(form!);
    
  //  form1.push(JSON.parse(this.profile.value));

    console.log(form1);

    localStorage.setItem(string, JSON.stringify(this.profile.value));

    localStorage.setItem('lastname', JSON.stringify(this.profile.value));

    let name = localStorage.getItem('lastname');

  //  console.log(name);
 //   console.log(this.profile.value);
 //   let formValue = JSON.parse(localStorage.getItem('form-data'));
 //   console.log(formValue);
  }
  form2: any;
  headers = ['firstName', 'lastName', 'email'];
  rows: object[] = [];
  updateTable() {

    this.rows = [];
    let flag = localStorage.getItem('flag');
    console.log(flag);
    var string = 'form-data-';
    if(flag != null){
      for(let i = 1; i<=parseInt(flag);i++){
        string += i.toString();
        console.log(string);
        if(string in localStorage){
          this.form2 = localStorage.getItem(string);
          if(this.form2 != null){
          this.form2 = JSON.parse(this.form2!);
          this.rows.push(this.form2);
          console.log(this.rows);
          }
    }
    string = 'form-data-';

    }
  }
  }

  updateProfile() {

    this.profile.patchValue({
      firstName: 'Kesav',
      lastName: "Ravichandran",
      email: "kesav@gmail.com"
    })
  }

}
