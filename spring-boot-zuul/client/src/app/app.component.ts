import {Component, OnInit} from '@angular/core';
import {AppService} from './app.service';
import {PersonModel} from './person.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'app';

  people: Array<PersonModel> = [];

  constructor(private backend: AppService) {
    this.fetchPeople();
  }

  fetchPeople(): void {
    this.backend.get('/people/list/', (success) => {
      this.people = success;
    }, (error) => {
      console.log(error);
    });
  }

  delete(id: number): void {
    this.backend.delete('/people/delete/' + id, (success) => {
      console.log(success);
      this.fetchPeople();
    }, (error) => {
      console.log(error);
    });
  }

  ngOnInit(): void {
  }

}
