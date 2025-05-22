import { Routes } from '@angular/router';
import { EvaluationStageComponent } from './evaluation-stage/evaluation-stage.component';

export const routes: Routes = [
  { path: '', component: EvaluationStageComponent },
  { path: 'evaluation', component: EvaluationStageComponent }
];
