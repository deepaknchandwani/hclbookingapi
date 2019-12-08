import { Component, OnInit, Input } from '@angular/core';
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router'; 
@Component({
  selector: 'app-booking-add',
  templateUrl: './booking-add.component.html',
  styleUrls: ['./booking-add.component.css']
})
export class BookingAddComponent implements OnInit {

  @Input() productData = { prod_name:'', prod_desc: '', prod_price: 0 };
  @Input() bookingData = { dateBegin:new Date(), dateEnd : new Date(), purpose: '', roomId: 0 };
 

  public time = {hour: 13, minute: 30};
  public model:any = {};
  public selectedDate:Date;
  public selectedDate2:Date;

  public dateWording:string = "yyyy-mm-dd ";
  public startDateObj:any = {};
  public endDateObj:any = {};

  onSelect(evt:any){
    
    this.selectedDate = new Date(evt.year,evt.month-1,evt.day);
    this.bookingData.dateBegin=this.selectedDate;
    console.log(this.selectedDate);
  }

  onSelect2(evt:any){
     this.selectedDate2 = new Date(evt.year,evt.month-1,evt.day);
     this.bookingData.dateEnd=this.selectedDate2;
    console.log(this.selectedDate2);
  }

  constructor(public rest:RestService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
  }

  addProduct() {
    console.log('Booking  ',this.bookingData);
    this.rest.addBooking(this.bookingData).subscribe((result) => {
      alert(result);
      this.router.navigate(['']);
    }, (err) => {
      console.log(err);
    });
  }

}


 
 



