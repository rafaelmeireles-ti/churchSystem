import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'situacao'
})
export class SituacaoPipe implements PipeTransform {

  transform(value: boolean): string {
    return value ? 'Ativo' : 'Inativo';
  }

}
