import { Component, OnChanges, SimpleChanges } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { SidebarComponent } from '../sidebar/sidebar.component';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-base-layout',
  standalone: true,
  imports: [CommonModule, HeaderComponent, SidebarComponent, RouterOutlet],
  templateUrl: './base-layout.component.html',
  styleUrl: './base-layout.component.css'
})
export class BaseLayoutComponent {
  
  sidebarIsOpen: Boolean = true;

  statusIsOpen(event: Boolean): void{
    this.sidebarIsOpen = event
    console.log("BaseLayoutComponent.statusIsOpen.isOpen: ", this.sidebarIsOpen)
  }
}
