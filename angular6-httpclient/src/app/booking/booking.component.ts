import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  bookings:any = [];

  constructor(public rest:RestService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.getBookings();
  }

  getBookings() {
    this.bookings = [];
    this.rest.getBookings().subscribe((data: {}) => {
      console.log(data);
      this.bookings = data;
    });
  }

  add() {
    this.router.navigate(['/booking-add']);
  }

  delete(id) {
    this.rest.deleteBooking(id)
      .subscribe(res => {
          this.getBookings();
        }, (err) => {
          console.log(err);
        }
      );
  }

}









 