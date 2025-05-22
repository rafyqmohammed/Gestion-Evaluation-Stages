import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-evaluation-stage',
  imports: [CommonModule, FormsModule],
  standalone: true,
  templateUrl: './evaluation-stage.component.html',
  styleUrl: './evaluation-stage.component.css'
})
export class EvaluationStageComponent {
  currentStep: number = 1;
  totalSteps: number = 6;

  formData = {
    stage: {
      description: '',
      objectif: '',
      entreprise: ''
    },
    tuteur: {
      nom: '',
      prenom: '',
      email: '',
      entreprise: ''
    },
    stagiaire: {
      nom: '',
      prenom: '',
      email: '',
      institution: ''
    },
    periode: {
      db: '',
      df: ''
    },
    appreciation: {
      commentaire: ''
    },
    evaluation: [] as any[],
    competences: [
      {
        intitule: 'Compétences liées à l\'individu',
        note: 0,
        categories: [] as any[]
      },
      {
        intitule: 'Compétences liées à l\'entreprise',
        note: 0,
        categories: [] as any[]
      },
      {
        intitule: 'Compétences scientifiques et techniques',
        note: 0,
        categories: [] as any[]
      },
      {
        intitule: 'Compétences spécifiques métier',
        note: 0,
        categories: [] as any[]
      }
    ]
  };

  // Add radio button models
  radioValues = {
    implication: '',
    ouverture: '',
    qualite: '',
    indiv1: '',
    indiv2: '',
    indiv3: '',
    indiv4: '',
    indiv5: '',
    company1: '',
    company2: '',
    company3: '',
    company4: '',
    tech1: '',
    tech2: '',
    tech3: ''
  };

  observations: string = '';

  // Update competencesSpecifiques initialization
  competencesSpecifiques = Array(5).fill(null).map(() => ({ intitule: '', valeur: '' }));

  notes = {
    individu: 0,
    entreprise: 0,
    technique: 0,
    specifique: 0
  };

  showAlert = false;
  alertMessage = '';
  alertType = '';

  constructor(private http: HttpClient) {}

  isFormValid(): boolean {
    // Check basic info
    if (!this.formData.stagiaire.nom || !this.formData.stagiaire.prenom || 
        !this.formData.stagiaire.email || !this.formData.stagiaire.institution ||
        !this.formData.tuteur.nom || !this.formData.tuteur.prenom || 
        !this.formData.tuteur.email || !this.formData.stage.entreprise ||
        !this.formData.periode.db || !this.formData.periode.df ||
        !this.formData.stage.description || !this.formData.stage.objectif) {
      return false;
    }

    // Check evaluations
    if (!this.radioValues.implication || !this.radioValues.ouverture || 
        !this.radioValues.qualite || !this.observations) {
      return false;
    }

    // Check individual competencies
    if (!this.radioValues.indiv1 || !this.radioValues.indiv2 || 
        !this.radioValues.indiv3 || !this.radioValues.indiv4 || 
        !this.radioValues.indiv5 || !this.notes.individu) {
      return false;
    }

    // Check company competencies
    if (!this.radioValues.company1 || !this.radioValues.company2 || 
        !this.radioValues.company3 || !this.radioValues.company4 || 
        !this.notes.entreprise) {
      return false;
    }

    // Check technical competencies
    if (!this.radioValues.tech1 || !this.radioValues.tech2 || 
        !this.radioValues.tech3 || !this.notes.technique) {
      return false;
    }

    // Check specific competencies (at least one should be filled)
    const hasSpecificCompetencies = this.competencesSpecifiques.some(
      comp => comp.intitule && comp.valeur
    );
    if (!hasSpecificCompetencies || !this.notes.specifique) {
      return false;
    }

    return true;
  }

  onSubmit() {
    if (!this.isFormValid()) {
      this.alertType = 'danger';
      this.alertMessage = 'Veuillez remplir tous les champs obligatoires';
      this.showAlert = true;
      setTimeout(() => this.showAlert = false, 5000);
      return;
    }

    this.collectFormData();
    
    this.http.post('http://localhost:8087/stage', this.formData)
      .subscribe({
        next: (response) => {
          console.log('Success:', response);
          this.showSuccessAlert();
          this.resetForm();
        },
        error: (error) => {
          console.error('Error:', error);
          this.showErrorAlert();
        }
      });
  }

  nextStep() {
    // Add validation for each step
    if (this.currentStep === 1 && !this.isFirstStepValid()) {
      this.showStepValidationError();
      return;
    }
    if (this.currentStep === 2 && !this.isSecondStepValid()) {
      this.showStepValidationError();
      return;
    }
    // ... similar validation for other steps ...

    if (this.currentStep < this.totalSteps) {
      this.currentStep++;
    }
  }

  previousStep() {
    if (this.currentStep > 1) {
      this.currentStep--;
    }
  }

  private isFirstStepValid(): boolean {
    return !!(this.formData.stagiaire.nom && this.formData.stagiaire.prenom && 
             this.formData.stagiaire.email && this.formData.stagiaire.institution &&
             this.formData.tuteur.nom && this.formData.tuteur.prenom && 
             this.formData.tuteur.email && this.formData.stage.entreprise &&
             this.formData.periode.db && this.formData.periode.df &&
             this.formData.stage.description && this.formData.stage.objectif);
  }

  private isSecondStepValid(): boolean {
    return !!(this.radioValues.implication && this.radioValues.ouverture && 
             this.radioValues.qualite && this.observations);
  }

  private showStepValidationError() {
    this.alertType = 'warning';
    this.alertMessage = 'Veuillez remplir tous les champs de cette étape avant de continuer';
    this.showAlert = true;
    setTimeout(() => this.showAlert = false, 5000);
  }

  isLastStep(): boolean {
    return this.currentStep === this.totalSteps;
  }

  private showSuccessAlert() {
    this.alertType = 'success';
    this.alertMessage = 'Évaluation envoyée avec succès!';
    this.showAlert = true;
    setTimeout(() => this.showAlert = false, 5000); // Hide after 5 seconds
  }

  private showErrorAlert() {
    this.alertType = 'danger';
    this.alertMessage = 'Erreur lors de l\'envoi de l\'évaluation';
    this.showAlert = true;
    setTimeout(() => this.showAlert = false, 5000);
  }

  private resetForm() {
    // Reset all form data
    this.formData = {
      stage: { description: '', objectif: '', entreprise: '' },
      tuteur: { nom: '', prenom: '', email: '', entreprise: '' },
      stagiaire: { nom: '', prenom: '', email: '', institution: '' },
      periode: { db: '', df: '' },
      appreciation: { commentaire: '' },
      evaluation: [],
      competences: [
        { intitule: 'Compétences liées à l\'individu', note: 0, categories: [] },
        { intitule: 'Compétences liées à l\'entreprise', note: 0, categories: [] },
        { intitule: 'Compétences scientifiques et techniques', note: 0, categories: [] },
        { intitule: 'Compétences spécifiques métier', note: 0, categories: [] }
      ]
    };

    this.radioValues = {
      implication: '', ouverture: '', qualite: '',
      indiv1: '', indiv2: '', indiv3: '', indiv4: '', indiv5: '',
      company1: '', company2: '', company3: '', company4: '',
      tech1: '', tech2: '', tech3: ''
    };

    this.observations = '';
    this.notes = { individu: 0, entreprise: 0, technique: 0, specifique: 0 };
    this.competencesSpecifiques = Array(5).fill(null).map(() => ({ intitule: '', valeur: '' }));
    
    // Reset to first step
    this.currentStep = 1;
  }

  private collectFormData() {
    // Collect evaluations
    this.formData.evaluation = [
      {
        categorie: 'Implication dans ses activités',
        valeur: this.getSelectedRadioValue('implication')
      },
      {
        categorie: 'Ouverture aux autres',
        valeur: this.getSelectedRadioValue('ouverture')
      },
      {
        categorie: 'Qualité de ses productions',
        valeur: this.getSelectedRadioValue('qualite')
      },
      {
        categorie: 'Observations sur l\'ensemble du travail accompli',
        valeur: this.observations
      }
    ];

    // Collect competences
    this.collectCompetencesIndividu();
    this.collectCompetencesEntreprise();
    this.collectCompetencesTechniques();
    this.collectCompetencesSpecifiques();

    // Add notes to competences
    this.formData.competences[0].note = this.notes.individu;
    this.formData.competences[1].note = this.notes.entreprise;
    this.formData.competences[2].note = this.notes.technique;
    this.formData.competences[3].note = this.notes.specifique;
    
    // Add appreciation
    this.formData.appreciation.commentaire = this.observations;
  }

  private getSelectedRadioValue(name: string): string {
    return this.radioValues[name as keyof typeof this.radioValues] || '';
  }

  // Add method to set radio value
  setRadioValue(name: string, value: string) {
    this.radioValues[name as keyof typeof this.radioValues] = value;
  }

  private collectCompetencesIndividu() {
    this.formData.competences[0].categories = [
      { intitule: 'Etre capable d\'analyse et de synthèse', valeur: this.getSelectedRadioValue('indiv1') },
      { intitule: 'Etre capable de proposer des méthodes et des axes de travail', valeur: this.getSelectedRadioValue('indiv2') },
      { intitule: 'Etre capable faire adhérer les acteurs', valeur: this.getSelectedRadioValue('indiv3') },
      { intitule: 'Etre capable de s\'autoévaluer', valeur: this.getSelectedRadioValue('indiv4') },
      { intitule: 'Etre capable d\'identifier des problèmes complexes', valeur: this.getSelectedRadioValue('indiv5') }
    ];
  }

  private collectCompetencesEntreprise() {
    this.formData.competences[1].categories = [
      { intitule: 'Etre capable d\'analyser le fonctionnement de l\'entreprise d\'accueil', valeur: this.getSelectedRadioValue('company1') },
      { intitule: 'Etre capable d\'analyse la démarche projet , et de structurer un projet', valeur: this.getSelectedRadioValue('company2') },
      { intitule: 'Etre capable d\'apprendre à déceler et à comprendre la politique environnementale de l\'entreprise', valeur: this.getSelectedRadioValue('company3') },
      { intitule: 'Etre capable de rechercher et sélectionner l\'information nécessaire à ses activités', valeur: this.getSelectedRadioValue('company4') }
    ];
  }

  private collectCompetencesTechniques() {
    this.formData.competences[2].categories = [
      { intitule: 'Etre capable d\'assurer la Conception préliminaire de produits/services / processus', valeur: this.getSelectedRadioValue('tech1') },
      { intitule: 'Etre capable analyser les besoins clients et traduire en spécifications techniques', valeur: this.getSelectedRadioValue('tech2') },
      { intitule: 'Etre capable participer à l\'élaboration de prototypes et tests de validation', valeur: this.getSelectedRadioValue('tech3') }
    ];
  }

  private collectCompetencesSpecifiques() {
    this.formData.competences[3].categories = this.competencesSpecifiques
      .filter(comp => comp.intitule && comp.valeur)
      .map(comp => ({
        intitule: comp.intitule,
        valeur: comp.valeur
      }));
  }
}
