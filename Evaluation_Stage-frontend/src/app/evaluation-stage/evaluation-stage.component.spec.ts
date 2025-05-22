import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EvaluationStageComponent } from './evaluation-stage.component';

describe('EvaluationStageComponent', () => {
  let component: EvaluationStageComponent;
  let fixture: ComponentFixture<EvaluationStageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EvaluationStageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EvaluationStageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
