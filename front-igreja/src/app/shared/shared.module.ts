import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SituacaoPipe } from './pipes/situacao.pipe';



@NgModule({
  declarations: [
    SituacaoPipe
  ],
  imports: [
    CommonModule
  ],
  exports: [
    SituacaoPipe
  ]
})
export class SharedModule { }
