import {Component} from '@angular/core';

@Component({
  selector: 'ngbd-datepicker-popup',
  templateUrl: './datepicker-popup.html'
})
export class NgbdDatepickerPopup {
  public model:any = {};
  public selectedDate:Date;
  public dateWording:string = "yyyy-mm-dd";
  public currentDateObj:any = {};
  onSelect(evt:any){
    this.selectedDate = new Date(evt.year,evt.month-1,evt.day);
    console.log(this.selectedDate);
  }


}