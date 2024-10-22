import { Component, EventEmitter, Input, OnInit, Output, output } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [],
  template: `<aside>
    <button (click)="updateStatusSidebar()">botao</button>
  </aside>`,
  styles: [`
    `]
})
export class SidebarComponent implements OnInit{

  @Input() isOpen: Boolean = true;
  @Output() statusIsOpen:  EventEmitter<Boolean> = new EventEmitter();

  updateStatusSidebar(){
    console.log("SidebarComponent.updateStatusSidebar.isOpen: ", this.isOpen)
    this.emitirAbrirFechar()
    console.log("SidebarComponent.updateStatusSidebar.isOpen: ", this.isOpen)
  }

  emitirAbrirFechar(){
    this.isOpen = !this.isOpen;
    this.statusIsOpen.emit(this.isOpen)
  }
  
  ngOnInit(): void {
    console.log("SidebarComponent.ngOnInit.isOpen: ", this.isOpen)
  }




}
