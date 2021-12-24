import { Component, OnInit } from '@angular/core';
import {StudentService} from "../service/student.service";
import {Student} from "../service/student";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.less']
})
export class StudentFormComponent implements OnInit {

  public student = new Student(-1, "", -1);

  constructor(public studentService: StudentService, public route: ActivatedRoute, public router: Router) { }

  ngOnInit(): void {  }

  save() {

  }
}
