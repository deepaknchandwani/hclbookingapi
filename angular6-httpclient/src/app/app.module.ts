import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { BookingComponent } from './booking/booking.component';
import { BookingAddComponent } from './booking-add/booking-add.component';
import { BookingDetailComponent } from './booking-detail/booking-detail.component';
import { BookingEditComponent } from './booking-edit/booking-edit.component';

import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { OwlDateTimeModule, OwlNativeDateTimeModule } from 'ng-pick-datetime';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { NgbdDatepickerPopup } from './datepicker-popup';

const appRoutes: Routes = [
  {
    path: 'bookings',
    component: BookingComponent,
    data: { title: 'Product List' }
  },
  {
    path: 'product-details/:id',
    component: BookingDetailComponent,
    data: { title: 'Product Details' }
  },
  {
    path: 'booking-add',
    component: BookingAddComponent,
    data: { title: 'Product Add' }
  },
  {
    path: 'product-edit/:id',
    component: BookingEditComponent,
    data: { title: 'Product Edit' }
  },
  { path: '',
    redirectTo: '/bookings',
    pathMatch: 'full'
  }
];
@NgModule({
  declarations: [
    NgbdDatepickerPopup,
    AppComponent,  
    BookingComponent,
    BookingAddComponent,
    BookingDetailComponent,
    BookingEditComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    OwlDateTimeModule,
    OwlNativeDateTimeModule,
    NgbModule,
    FormsModule,    
    HttpClientModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
