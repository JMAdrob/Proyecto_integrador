import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Skills } from 'src/app/model/skills.model';
import { SkillsService } from 'src/app/service/skills.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  public Skills: Skills[] = [];
  public editSkills: Skills | undefined;
  public deleteSkills: Skills | undefined;

  constructor(private skillsService: SkillsService) { }

  ngOnInit(): void {
    this.getSkills();
  }

  public getSkills(): void {
    this.skillsService.getSkills().subscribe({
      next: (Response: Skills[]) => {
        this.Skills = Response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }

  public onOpenModal(mode: string, skills?: Skills): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addSkillModal');
    } else if (mode === 'delete') {
      this.deleteSkills = skills;
      button.setAttribute('data-target', '#deleteSkillModal');
    } else if (mode === 'edit') {
      this.editSkills = skills;
      button.setAttribute('data-target', '#editSkillModal');
    }

    container?.appendChild(button);
    button.click();
  }

  public onAddSkills(addForm: NgForm): void {
    document.getElementById('add-skills-form')?.click();
    this.skillsService.addSkills(addForm.value).subscribe({
      next: (response: Skills) => {
        console.log(response);
        this.getSkills();
        addForm.reset();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      },
    });
  }

  public onUpdateSkills(skills: Skills) {
    this.editSkills = skills;
    this.skillsService.updateSkills(skills).subscribe({
      next: (response: Skills) => {
        console.log(response);
        this.getSkills();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }

  public onDeleteSkills(idS: number): void {
    this.skillsService.deleteSkills(idS).subscribe({
      next: (response: void) => {
        console.log(response);
        this.getSkills();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }


}