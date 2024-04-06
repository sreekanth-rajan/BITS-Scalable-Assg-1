import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { UIHeaderComponent } from './uiheader/uiheader.component';
import { CustomerUIComponent } from './customer-ui/customer-ui.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { WelcomeUIComponent } from './welcome-ui/welcome-ui.component';
import { ItemUIComponent } from './item-ui/item-ui.component';
import { SalesOrderUIComponent } from './sales-order-ui/sales-order-ui.component';

import { TableModule } from 'primeng/table';
import { InputTextModule } from 'primeng/inputtext';
import { DialogModule } from 'primeng/dialog';
import { ButtonModule } from 'primeng/button';
import { AutoCompleteModule } from 'primeng/autocomplete';
import { PanelModule } from 'primeng/panel';
import { MegaMenuModule } from 'primeng/megamenu';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/components/common/messageservice';
import { OrganizationChartModule } from 'primeng/organizationchart';
import { TooltipModule } from 'primeng/tooltip';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';

@NgModule({
  declarations: [
    AppComponent,
    UIHeaderComponent,
    CustomerUIComponent,
    WelcomeUIComponent,
    ItemUIComponent,
    SalesOrderUIComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    TableModule,
    InputTextModule,
    DialogModule,
    ButtonModule,
    AutoCompleteModule,
    PanelModule,
    MegaMenuModule,
    ToastModule,
    OrganizationChartModule,
    TooltipModule,
    MessagesModule,
    MessageModule,
  ],
  providers: [MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
