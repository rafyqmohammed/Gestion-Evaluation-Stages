import { Component } from '@angular/core';
import { EvaluationStageComponent } from './evaluation-stage/evaluation-stage.component';

@Component({
  selector: 'app-root',
  imports: [EvaluationStageComponent],
  standalone: true,
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Evaluation_Stage-frontend';
}
